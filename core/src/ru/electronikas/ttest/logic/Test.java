package ru.electronikas.ttest.logic;

import ru.electronikas.ttest.data.QuestionSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nikas on 1/8/17.
 * <p>
 * <p>
 * Logic of test
 */
public class Test {
    QuestionSource questionSource;
    Integer lieScala;
    Boolean honestAnswers;
    Integer introversionScala;
    Integer neuroticismScala;

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

        if (questionSource.getCurrentQuestion() == null) {
            calculateTestResult();
            return false;
        }
        return true;
    }

    private String testResult;

    private void calculateTestResult() {

        lieScala = testAnswersMap.get(6) + testAnswersMap.get(24) + testAnswersMap.get(36) +
                testAnswersMap.get(12) + testAnswersMap.get(18) + testAnswersMap.get(30) +
                testAnswersMap.get(42) + testAnswersMap.get(48) + testAnswersMap.get(54);

        if (lieScala > 5) {
            honestAnswers = false;
        } else {
            honestAnswers = true;
        }


        if (honestAnswers) {
            introversionScala = testAnswersMap.get(1) + testAnswersMap.get(3) +
                    testAnswersMap.get(8) + testAnswersMap.get(10) +
                    testAnswersMap.get(13) + testAnswersMap.get(17) +
                    testAnswersMap.get(22) + testAnswersMap.get(25) +
                    testAnswersMap.get(27) + testAnswersMap.get(39) +
                    testAnswersMap.get(44) + testAnswersMap.get(46) +
                    testAnswersMap.get(49) + testAnswersMap.get(53) +
                    testAnswersMap.get(56) +
                    testAnswersMap.get(5) + testAnswersMap.get(15) +
                    testAnswersMap.get(20) + testAnswersMap.get(29) +
                    testAnswersMap.get(32) + testAnswersMap.get(34) +
                    testAnswersMap.get(37) + testAnswersMap.get(41) +
                    testAnswersMap.get(51);

            neuroticismScala = testAnswersMap.get(2) + testAnswersMap.get(4) +
                    testAnswersMap.get(7) + testAnswersMap.get(9) +
                    testAnswersMap.get(11) + testAnswersMap.get(14) +
                    testAnswersMap.get(16) + testAnswersMap.get(19) +
                    testAnswersMap.get(21) + testAnswersMap.get(23) +
                    testAnswersMap.get(26) + testAnswersMap.get(28) +
                    testAnswersMap.get(31) + testAnswersMap.get(33) +
                    testAnswersMap.get(35) + testAnswersMap.get(38) +
                    testAnswersMap.get(40) + testAnswersMap.get(43) +
                    testAnswersMap.get(45) + testAnswersMap.get(47) +
                    testAnswersMap.get(50) + testAnswersMap.get(52) +
                    testAnswersMap.get(55) + testAnswersMap.get(57);

            if (introversionScala >= 19) {
            };
            if (introversionScala >= 15 && introversionScala < 19) {
            };
            if (introversionScala > 12 && introversionScala < 15) {
            };
            if (introversionScala == 12) {
            };
            if (introversionScala < 12) {
            };
            if (introversionScala <= 9 && introversionScala > 5) {
            };
            if (introversionScala <= 5) {
            };


            if (neuroticismScala >= 19) {
            };
            if (neuroticismScala >= 13 && neuroticismScala < 19) {
            };
            if (neuroticismScala >= 9 && neuroticismScala < 13) {
            };
            if (neuroticismScala < 9) {
                //шкала неройтизма.
            };


        } else {
            //return
            // "неискренность в ответах, свидетельствующая также о некоторой демонстративности поведения и ориентированности испытуемого на социальное одобрение"
            // "Вам следует пройти другой тест, т.к. Вы стремитесь давать только "хорошие" ответы, а значит не можете быть оценены этим тестом."
            // и здесь же добавить кнопку на другой тест.
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
