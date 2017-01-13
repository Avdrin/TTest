package ru.electronikas.ttest.logic;

import ru.electronikas.ttest.data.QuestionSource;

import java.util.HashMap;
import java.util.Map;

public class Test {
    QuestionSource questionSource;
    Integer lieScala;
    Boolean honestAnswers;
    Integer introversionScala;
    Integer neuroticismScala;

    String resultIntroversionScala = "";
    String resultNeuroticismScala = "";
    private String totalResult; //TODO fill it


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
            //getTestResult();
            // calculateTestResult();
            return false;
        }
        return true;
    }

    public Map<Integer, Integer> setTestAnswersMap(Integer valueAnswers) {

        testAnswersMap.put(getQuestionNumber() - 1, valueAnswers);

        return testAnswersMap;
    }


    private Boolean testAnswersMapFull() {
        if (testAnswersMap.size() == 0) {
            return false;
        }else {return true;}
    }

    private Integer getLieScala() {
        if (testAnswersMapFull()) {
//            lieScala = testAnswersMap.get(6);
            lieScala = 0;
            lieScala = testAnswersMap.get(6) + testAnswersMap.get(24) + testAnswersMap.get(36) +
                testAnswersMap.get(12) + testAnswersMap.get(18) + testAnswersMap.get(30) +
                testAnswersMap.get(42) + testAnswersMap.get(48) + testAnswersMap.get(54);
        }else { lieScala = -1;}
        return lieScala;
    }

    private Boolean getHonestAnswers() {
        if (getLieScala() == -1){
            return false;
        }

        if (getLieScala() > 5) {
            honestAnswers = false;
        } else {
            honestAnswers = true;
        }
        return honestAnswers;
    }


    private Integer getIntroversionScala() {
        if (getHonestAnswers()) {
//            introversionScala = testAnswersMap.get(1);
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
        } else {
            introversionScala = -1;
        }

        return introversionScala;
    }

    private Integer getNeuroticismScala() {
        if (getHonestAnswers()) {
//            neuroticismScala = testAnswersMap.get(1);
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
        } else {
            neuroticismScala = -1;
        }

        return neuroticismScala;
    }


//    private void calculateTestResult() {
//            //return
//            // "неискренность в ответах, свидетельствующая также о некоторой демонстративности поведения и ориентированности испытуемого на социальное одобрение"
//            // "Вам следует пройти другой тест, т.к. Вы стремитесь давать только "хорошие" ответы, а значит не можете быть оценены этим тестом."
//            // и здесь же добавить кнопку на другой тест.
//        }
//        //use testAnswersMap to write testResult
//    }

    private String getResultIntroversionScala() {
        if (getHonestAnswers()){
        if (getIntroversionScala() >= 19) {
            resultIntroversionScala = "яркий экстраверт";
        }
        if (getIntroversionScala() >= 15 && getIntroversionScala() < 19) {
            resultIntroversionScala = "экстраверт";
        }
        if (getIntroversionScala() > 12 && getIntroversionScala() < 15) {
            resultIntroversionScala = "склонность к экстраверсии";
        }
        if (getIntroversionScala() == 12) {
            resultIntroversionScala = "пограничное состояние говорит об уравновешенности личностных качеств";
        }
        if (getIntroversionScala() < 12 && getIntroversionScala() > 9) {
            resultIntroversionScala = "склонность к интроверсии";
        }
        if (getIntroversionScala() <= 9 && getIntroversionScala() > 5) {
            resultIntroversionScala = "интроверт";
        }
        if (getIntroversionScala() <= 5) {
            resultIntroversionScala = "глубокий интроверт";
        }}else {
            resultIntroversionScala = "наблюдается неискренность в ответах, свидетельствующая о некоторой демонстративности поведения и ориентированности Вас на социальное одобрение. " +
                    "Вам следует пройти другой тест, т.к. Вы стремитесь давать только \"хорошие\" ответы, а значит не можете быть оценены этим тестом. ";

        }
        return resultIntroversionScala;
    }

    private String getResultNeuroticismScala() {
        if (getHonestAnswers()){
        if (getNeuroticismScala() >= 19) {
            resultNeuroticismScala = "очень высокий уровень нейротизма";
        }
        if (getNeuroticismScala() >= 13 && getNeuroticismScala() < 19) {
            resultNeuroticismScala = "высокий уровень нейротизма";
        }
        if (getNeuroticismScala() >= 9 && getNeuroticismScala() < 13) {
            resultNeuroticismScala = "среднее значение свидетельствует о наличии черт как одного типа темперамента так и другого в зависимости от того на какой границе находится \"координата\"";
        }
        if (getNeuroticismScala() < 9) {
            resultNeuroticismScala = "низкий уровень нейротизма";
        }}else {
            resultNeuroticismScala = "";
        }
        return resultNeuroticismScala;
    }

    public String getTestResult() {

//        for (Map.Entry<Integer, Integer> entry : testAnswersMap.entrySet()) {

//            totalResult = "sd " + entry + "fv";
//for(int i=0;i<=57;i++){
//    totalResult = "sd " + testAnswersMap.get(i) + "fv";
//        }


        totalResult = getLieScala() + ", " + getResultIntroversionScala() + ", " + getResultNeuroticismScala();
        return totalResult;
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
