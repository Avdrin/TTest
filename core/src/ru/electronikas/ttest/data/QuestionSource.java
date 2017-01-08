package ru.electronikas.ttest.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nikas on 1/8/17.
 */
public class QuestionSource {

    Map<Integer, String> listQuestion = new HashMap<Integer, String>();

    Integer currentQuestionNumber; //примитивные типы не могут быть ключами Map.

    public QuestionSource() {
        reset();
        fillQuestions();
    }

    private void fillQuestions() {
        listQuestion.put(1, "Часто ли Вы испытываете тягу к новым впечатлениям, к тому, чтобы отвлечься, испытывать сильные ощущения?");
        listQuestion.put(2, "Часто ли Вы чувствуете, что нуждаетесь в друзьях, которые могут Вас понять, ободрить или посочувствовать?");
        listQuestion.put(3, "Считаете ли Вы себя беззаботным человеком?");
        listQuestion.put(4, "Очень ли трудно Вам отказываться от своих намерений?");
        listQuestion.put(5, "Обдумываете ли Вы свои дела, не спеша, и предпочитаете ли подождать, прежде чем действовать?");
        listQuestion.put(6, "Всегда ли сдерживаете Вы свои обещания, даже если это Вам невыгодно?");
        listQuestion.put(7, "Часто ли у Вас бывают спады и подъемы настроения?");
        listQuestion.put(8, "Быстро ли Вы обычно действуете и говорите, не тратите ли много времени на обдумывание?");
        listQuestion.put(9, "Возникало ли у Вас когда-нибудь чувство, что Вы несчастны, хотя никакой серъезной причины для этого не было?");
        listQuestion.put(10, "Верно ли, что \"на спор\" Вы способны решиться на все?");
        listQuestion.put(11, "Смущаетесь ли Вы, когда хотите познакомиться с человеком противоположного пола, который Вам симпатичен?");
        listQuestion.put(12, "Бывает ли когда-нибудь, что разозлившись, Вы выходите из себя?");
        listQuestion.put(13, "Часто ли бывает, что Вы действуете необдуманно, под влиянием момента?");
        listQuestion.put(14, "Часто ли Вас беспокоят мысли о том, что Вам не следовало чего-либо делать или говорить?");
        listQuestion.put(15, "Предпочитаете ли Вы чтение книг встречам с людьми?");
        listQuestion.put(16, "Верно ли, что Вас легко задеть?");
        listQuestion.put(17, "Любите ли Вы часто бывать в компании?");
        listQuestion.put(18, "Бывают ли у Вас иногда такие мысли, которыми Вам не хотелось бы делиться с другими людьми?");
        listQuestion.put(19, "Верно ли, что иногда Вы настолько полны энергии, что все \"горит в руках\", а иногда чувствуете сильную вялость?");
        listQuestion.put(20, "Стараетесь ли Вы ограничить круг своих знакомых небольшим числом самых близких друзей?");
        listQuestion.put(21, "Много ли Вы мечтаете?");
        listQuestion.put(22, "Когда на Вас кричат, отвечаете ли тем же?");
        listQuestion.put(23, "Считаете ли Вы все свои привычки хорошими?");
        listQuestion.put(24, "Часто ли у Вас появляется чувство, что Вы в чем-то виноваты?");
        listQuestion.put(25, "Способны ли Вы иногда дать волю своим чувствам и беззаботно развлечься с веселой компанией?");
        listQuestion.put(26, "Можно ли сказать, что нервы у Вас часто бывают натянуты до предела?");
        listQuestion.put(27, "Считают ли Вас человеком живым и веселым?");
        listQuestion.put(28, "После того, как дело сделано, часто ли Вы мысленно возвращаетесь к нему и думаете, что могли бы сделать лучше?");
        listQuestion.put(29, "Чувствуете ли Вы себя неспокойно, находясь в большой компании?");
        listQuestion.put(30, "Бывает ли, что Вы передаете слухи?");
        listQuestion.put(31, "Бывает ли, что Вам не спится из-за того, что в голову лезут разные мысли?");
        listQuestion.put(32, "Что Вы предпочитаете, если хотите узнать что-либо: найти в книге (+), или спросить у друзей?");
        listQuestion.put(33, "Бывают ли у Вас сильные сердцебиения?");
        listQuestion.put(34, "Нравится ли Вам работа, требующая сосредоточения?");
        listQuestion.put(35, "Бывают ли у Вас приступы дрожи?");
        listQuestion.put(36, "Всегда ли Вы говорите только правду?");
        listQuestion.put(37, "Бывает ли Вам неприятно находиться в компании, где все подшучивают друг над другом?");
        listQuestion.put(38, "Раздражительны ли Вы?");
        listQuestion.put(39, "Нравится ли Вам работа, требующая быстрого действия?");
        listQuestion.put(40, "Верно ли, что Вам часто не дают покоя мысли о разных неприятностях и \"ужасах\",  которые могли бы произойти, хотя все кончилось благополучно?");
        listQuestion.put(41, "Верно ли, что Вы неторопливы в движениях и несколько медлительны?");
        listQuestion.put(42, "Опаздывали  ли  Вы когда-нибудь на работу или на встречу с кем-либо?");
        listQuestion.put(43, "Часто ли Вам снятся кошмары?");
        listQuestion.put(44, "Верно ли, что Вы так любите поговорить, что не упускаете любого удобного случая побеседовать с новым человеком?");
        listQuestion.put(45, "Беспокоят ли Вас какие-нибудь боли?");
        listQuestion.put(46, "Огорчились бы Вы, если бы долго не могли видеться со своими друзьями?");
        listQuestion.put(47, "Можете ли Вы назвать себя нервным человеком?");
        listQuestion.put(48, "Есть ли среди Ваших знакомых такие, которые Вам явно не нравяться?");
        listQuestion.put(49, "Могли бы Вы сказать, что Вы уверенный в себе человек?");
        listQuestion.put(50, "Легко ли Вас задевает критика Ваших недостатков или Вашей работы?");
        listQuestion.put(51, "Трудно ли Вам получить настоящее удовольствие от мероприятий, в которых участвует много народа?");
        listQuestion.put(52, "Беспокоит ли Вас чувство, что Вы чем-то хуже других?");
        listQuestion.put(53, "Сумели бы Вы внести оживление в скучную компанию?");
        listQuestion.put(54, "Бывает ли, что Вы говорите о вещах, в которых совсем не разбираетесь?");
        listQuestion.put(55, "Беспокоитесь ли Вы о своем здоровье?");
        listQuestion.put(56, "Любите ли Вы подшутить над другими?");
        listQuestion.put(57, "Страдаете ли Вы бессонницей?");

    }

    public void goToNextQuestion() {
        currentQuestionNumber++;
    }

    public String getCurrentQuestion() {
        return listQuestion.get(currentQuestionNumber);
    }

    public Integer getCurrentQuestionNumber() {
        return currentQuestionNumber;
    }

    public void reset() {
        currentQuestionNumber = 0;
    }
}
