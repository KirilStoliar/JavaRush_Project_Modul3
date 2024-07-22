package org.example.final_progect_modul3.model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DataTest {
    Data dataMock = Mockito.spy(Data.class);
    Question questionMock = Mockito.spy(Question.class);
    Question questionMock1 = Mockito.spy(Question.class);
    List<Question> questions = new ArrayList<>();

    @Test
    void checkCallMethodFindQuestionByAnswer() {
        Answer answerMock = Mockito.spy(Answer.class);
        Answer answerMock1 = Mockito.spy(Answer.class);
        answerMock.setId(1);
        answerMock1.setId(2);
        questionMock.setId(1);
        questionMock1.setId(2);
        List<Answer> answers = new ArrayList<>();
        answers.add(answerMock);
        answers.add(answerMock1);
        questions.add(questionMock);
        questions.add(questionMock1);
        dataMock.setQuestions(questions);
        dataMock.setAnswers(answers);
        dataMock.findQuestionByAnswer(1);
        Mockito.verify(dataMock).findQuestionByAnswer(1);
        Mockito.when(dataMock.findQuestionByAnswer(1)).thenReturn(questionMock);
        assertEquals(questionMock, dataMock.findQuestionByAnswer(1));
    }

    @Test
    void checkCallMethodFindAnswerByQuestion() {
        questionMock.setId(1);
        List<Integer> listAnswers = new ArrayList<>();
        listAnswers.add(1);
        listAnswers.add(2);
        questionMock.setAnswers(listAnswers);
        questionMock1.setId(2);
        List<Integer> listAnswers1 = new ArrayList<>();
        listAnswers1.add(3);
        listAnswers1.add(4);
        questionMock1.setAnswers(listAnswers1);
        questions.add(questionMock);
        questions.add(questionMock1);
        dataMock.setQuestions(questions);
        questionMock.setAnswers(listAnswers1);
        dataMock.findAnswerByQuestion(1);
        Mockito.verify(dataMock).findAnswerByQuestion(1);
        int[] i = new int[]{1,2};
        Mockito.when(dataMock.findAnswerByQuestion(1)).thenReturn(i);
        assertEquals(i, dataMock.findAnswerByQuestion(1));
    }
}