package org.example.final_progect_modul3.model;


import java.util.List;

@lombok.Data
public class Data {
    private List<Question> questions;
    private List<Answer> answers;

    public Question findQuestionByAnswer(int answer) {
        Answer answerObj = null;
        for (Answer a : answers) {
            if (a.getId() == answer) {
                answerObj = a;
                break;
            }
        }

        if (answerObj != null) {
            Question nextQuestion = null;
            for (Question question : questions) {
                if (question.getId() == answerObj.getQuestion()) {
                    nextQuestion = question;
                    break;
                }
            }
            return nextQuestion;
        }
        return null;
    }

    public int[] findAnswerByQuestion(int number) {
        Question question = null;
        int[] answerId = new int[2];
        for (Question q : questions) {
            if (q.getId() == number) {
                question = q;
            }
        }

        if (!question.getAnswers().isEmpty()) {
            answerId[0] = question.getAnswers().get(0);
            answerId[1] = question.getAnswers().get(1);
        }
        return answerId;
    }
}