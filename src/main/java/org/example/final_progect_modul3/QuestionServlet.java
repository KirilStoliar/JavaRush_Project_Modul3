package org.example.final_progect_modul3;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.example.final_progect_modul3.model.Data;
import org.example.final_progect_modul3.model.Player;
import org.example.final_progect_modul3.model.Question;
import org.example.final_progect_modul3.service.QuestionService;

import static org.example.consts.Variables.*;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
    public QuestionService questionService;
    public Data data;
    public Player player;
    HttpSession session;

    @SneakyThrows
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        questionService = new QuestionService();
        data = questionService.readFromFile();
        player = new Player();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {
        String path = "";
        String query = request.getQueryString();
        String[] valuesQuery = new String[2];
        Question root;
        session = request.getSession();

        try {
                valuesQuery = query.split(defaultSeparatorToQuery);
                int answerId = Integer.parseInt(valuesQuery[1]);
                root = data.findQuestionByAnswer(answerId);
                if (root.isFailed()) {
                    path = getFinishPage(request, root);
                } else if (root.isSuccess()) {
                    path = getVictoryPage(request, root);
                } else {
                    path = getOtherPage(request, root);
                }
        } catch (Exception e) {
            if (valuesQuery.length == 2) {
                player.setName(valuesQuery[1]);
            } else {
                player.setName(defaultName);
            }
            path = getStartPage(request);
        }
        ServletContext servletContext = getServletContext();;
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    private String getVictoryPage(HttpServletRequest request, Question root) {
        String path;
        request.setAttribute("question", root.getQuestion());
        player.setSessionLoses(player.getSessionLoses());
        player.setSessionWins(player.getSessionWins() + 1);
        getSessionAttribute();
        path = pageVictory;
        return path;
    }

    private String getFinishPage(HttpServletRequest request, Question root) {
        String path;
        request.setAttribute("question", root.getQuestion());
        player.setSessionLoses(player.getSessionLoses() + 1);
        player.setSessionWins(player.getSessionWins());
        getSessionAttribute();
        path = pageFinish;
        return path;
    }

    private void getSessionAttribute() {
        player.setSessionPlay(player.getSessionPlay() + 1);
        session.setAttribute("sessionPlay", player.getSessionPlay());
        session.setAttribute("sessionWins", player.getSessionWins());
        session.setAttribute("sessionLoses", player.getSessionLoses());
    }

    private String getOtherPage(HttpServletRequest request, Question root) {
        String path;
        request.setAttribute("question", root.getQuestion());
        int[] answersId = data.findAnswerByQuestion(root.getId());
        request.setAttribute("answer1", data.getAnswers().get(answersId[0] - defaultId).getField());
        request.setAttribute("answer2", data.getAnswers().get(answersId[1] - defaultId).getField());
        if (!root.getAnswers().isEmpty()) {
            request.setAttribute("nextAnswer1", root.getAnswers().get(0));
            request.setAttribute("nextAnswer2", root.getAnswers().get(1));
        }
        path = pageQuestion;
        return path;
    }

    private String getStartPage(HttpServletRequest request) {
        String path;
        request.setAttribute("question", data.getQuestions().get(0).getQuestion());
        request.setAttribute("answer1", data.getAnswers().get(0).getField());
        request.setAttribute("answer2", data.getAnswers().get(1).getField());
        request.setAttribute("nextAnswer1", data.getQuestions().get(0).getAnswers().get(0));
        request.setAttribute("nextAnswer2", data.getQuestions().get(0).getAnswers().get(1));
        session.setAttribute("player", player);
        session.setAttribute("playerName", player.getName());
        path = pageQuestion;
        return path;
    }
}