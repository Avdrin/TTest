package ru.electronikas.ttest.logic;

import ru.electronikas.ttest.data.QuestionSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nikas on 1/8/17.
 *
 *
 * Logic of test
 */
public class Test {
    QuestionSource questionSource;

    //key - number of question
    //value - answer
    Map<Integer, Integer> testAnswersMap = new HashMap<Integer, Integer>();

    public Test() {
        questionSource = new QuestionSource();
    }

    public void start() {
        questionSource.reset();
    }

    //true  - there is next question
    //false - test Done
    public boolean goToNextQuestion() {
        questionSource.goToNextQuestion();

        if(questionSource.getCurrentQuestion()==null) {
            calculateTestResult();
            return false;
        }
        return true;
    }

    private String testResult;
    private void calculateTestResult() {
        //use testAnswersMap to write testResult
    }

    public String getTestResult() {
        return testResult;
    }

    public String getCurrentQuestionText() {
        return questionSource.getCurrentQuestion();
    }

    public void answerCurrentQuestion(Integer answerValue) {
        testAnswersMap.put(questionSource.getCurrentQuestionNumber(), answerValue);
    }

    public Integer getQuestionNumber() {
        return questionSource.getCurrentQuestionNumber();
    }
}
