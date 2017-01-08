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
int lieScala;
Boolean honestAnswers;
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
       /*if((questionSource.getCurrentQuestionNumber() == 6 && testAnswersMap.get(6) == 1)
               || (questionSource.getCurrentQuestionNumber() == 24 && testAnswersMap.get(24) == 1)
               || (questionSource.getCurrentQuestionNumber() == 36 && testAnswersMap.get(36) == 1)
               || (questionSource.getCurrentQuestionNumber() == 12 && testAnswersMap.get(12) == 0)
               || (questionSource.getCurrentQuestionNumber() == 18 && testAnswersMap.get(18) == 0)
               || (questionSource.getCurrentQuestionNumber() == 30 && testAnswersMap.get(30) == 0)
               || (questionSource.getCurrentQuestionNumber() == 42 && testAnswersMap.get(42) == 0)
               || (questionSource.getCurrentQuestionNumber() == 48 && testAnswersMap.get(48) == 0)
               || (questionSource.getCurrentQuestionNumber() == 54 && testAnswersMap.get(54) == 0)) */
        if(testAnswersMap.get(6) == 1){ lieScala ++;}
        if (testAnswersMap.get(24) == 1){ lieScala ++;}
        if (testAnswersMap.get(36) == 1){ lieScala ++;}
        if (testAnswersMap.get(12) == 0){ lieScala ++;}
        if (testAnswersMap.get(18) == 0){ lieScala ++;}
        if (testAnswersMap.get(30) == 0){ lieScala ++;}
        if (testAnswersMap.get(42) == 0){ lieScala ++;}
        if (testAnswersMap.get(48) == 0){ lieScala ++;}
        if (testAnswersMap.get(54) == 0){ lieScala ++;}

        if (lieScala > 5){
            honestAnswers = false;
        }else {
            honestAnswers = true;
        }


        if (honestAnswers){
//анализ теста.
        }else {
            //return "Вам следует пройти другой тест, т.к. Вы стремитесь давать только "хорошие" ответы, а значит не можете быть оценены этим тестом."
        }




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
