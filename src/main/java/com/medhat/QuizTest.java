package com.medhat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @since 4/8/09
 * @author levi JUnit test for the Quiz class.
 */
public class QuizTest {
    private Quiz quizUnderTest = new Quiz();;

    @Test
    public void testIsCorrect() {
        /* at first question, answer should be "9" */
        assertTrue("first question answer should be '9'", quizUnderTest.isCorrect(Integer.parseInt("9")));
    }

    @Test
    public void testGetNumberQuestions() {
        /* answer should be 5 regardless of what question we're at */
        assertEquals(5, quizUnderTest.getNumQuestions());
    }

    @Test
    public void testGetNumberCorrect() {
        /* at first question, answer should be 0 */
        assertEquals(0, quizUnderTest.getNumCorrect());

       // quizUnderTest.scoreAnswer(); // increments the score and the current question number
        assertEquals(1, quizUnderTest.getNumCorrect());
        assertEquals(1, quizUnderTest.getCurrentQuestionIndex());
    }
}
