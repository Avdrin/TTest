package ru.electronikas.ttest.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import ru.electronikas.ttest.Assets;
import ru.electronikas.ttest.Textures;
import ru.electronikas.ttest.logic.Test;

public class TestUI {
    public static final float SELECTED_FONT_SCALE = 1.3f;
    private final Integer RESP_ONE = 1;
    private final Integer RESP_ZERO = 0;


    Label questionLabel;
    Label resultLabel;
    TextButton yesBut;
    TextButton noBut;
    Table leveMenu;
    Skin uiSkin;
    float butW = 0;
    float h = 0;
    float w;

    private Test testLogic;


    public TestUI(Stage stage, Test testLogic) {
        this.testLogic = testLogic;
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        butW = w / 5;
        float butH = h; //w / 5;
        uiSkin = Textures.getUiSkin();

        createButtonsGroup();

        leveMenu = new Table(uiSkin);
        leveMenu.align(Align.topLeft);
        leveMenu.setPosition(0, 0); //h);
        leveMenu.setWidth(w);
        leveMenu.setHeight(h);
        leveMenu.defaults().width(w);
        leveMenu.row().height(h / 6);
        leveMenu.add(createHeaderLabel());
        leveMenu.row().height(h * (2f / 6 + 1f / 8)); //h / 8); //.width(w / 6);  //.height(h * (2f / 4 + 1f / 8));
        leveMenu.add(questionBlock());
        leveMenu.row().height(h / 8).width(w / 4);
        leveMenu.add(exitButton()).pad(w/30);
        leveMenu.setDebug(true);
        stage.addActor(leveMenu);
        Gdx.input.setInputProcessor(stage);  // Gdx.input.setInputProcessor(stage);

    }

    ButtonGroup<Button> buttonsGroup;
    private void createButtonsGroup() {
        buttonsGroup = new ButtonGroup<Button>();
        buttonsGroup.setMaxCheckCount(1);
        buttonsGroup.setMinCheckCount(0);
        buttonsGroup.setUncheckLast(true);
    }


    Table lvlTable;


    private Actor questionBlock() {
        lvlTable = new Table();
        lvlTable.setSkin(uiSkin);
        lvlTable.align(Align.center);
        lvlTable.defaults();

        //Question row
        lvlTable.row().width(w - w/10);
        lvlTable.add(createQuestionLabel()).pad(w/30).colspan(2);

        //Buttons Yes No row
        lvlTable.row().height(h / 8);
        lvlTable.add(createYesTestButton()).width(w/6).align(Align.right).pad(w/30);
        lvlTable.add(createNoTestButton()).width(w/6).align(Align.left).pad(w/30);

//        lvlTable.setDebug(true);

//        ScrollPane scrollPane = new ScrollPane(lvlTable, Textures.getUiSkin());
//        scrollPane.setWidth(butW);
////        scrollPane.setHeight(h/2);
//        scrollPane.getStyle().background = null;
        return lvlTable;
    }

    private Actor createResultLabel() {

        resultLabel = new Label(testLogic.getTestResult(), uiSkin);
        resultLabel.setWrap(true);
        resultLabel.setAlignment(Align.center);
//        if (resultLabel == null){
//            resultLabel = new Label("!!!", uiSkin);
//        }
        //Result row
        lvlTable.row().width(w - w/10);
        lvlTable.add(resultLabel).pad(w/30).colspan(2);//createResultLabel()).pad(w/30).colspan(2);

        return resultLabel;
    }

    private Actor createQuestionLabel() {
        questionLabel = new Label(testLogic.getCurrentQuestionText(), uiSkin);
        questionLabel.setWrap(true);
        questionLabel.setAlignment(Align.center);
        return questionLabel;
    }

    private TextButton createNoTestButton() {
        noBut = new TextButton(Assets.bdl().get("no"),  uiSkin.get("testBut", TextButton.TextButtonStyle.class));//"Button1", buttonStyle);
        buttonsGroup.add(noBut);
        noBut.addListener(onQuestionClicked);
        return noBut;
    }

    private TextButton createYesTestButton() {
        yesBut = new TextButton(Assets.bdl().get("yes"), uiSkin.get("testBut", TextButton.TextButtonStyle.class));//"Button1", buttonStyle);
        buttonsGroup.add(yesBut);
        yesBut.addListener(onQuestionClicked);
        return yesBut;
    }

    private Actor exitButton() {
        TextButton exitButton = new TextButton(Assets.bdl().get("exitButton"), Textures.getUiSkin());
        exitButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        return exitButton;
    }

    ClickListener onQuestionClicked = new ClickListener() {
        public void clicked(InputEvent event, float x, float y) {
            String question = null;
Integer currNumberQuestt = testLogic.getQuestionNumber();

            if(testLogic.goToNextQuestion()) { //testLogic.getQuestionNumber() <= 57){  //(testLogic.goToNextQuestion()) {
                question = testLogic.getCurrentQuestionText();

                if (buttonsGroup.getButtons().get(0).isChecked()){ //getChecked()
                    if ((currNumberQuestt) == 12 ||
                            (currNumberQuestt) == 18 ||
                            (currNumberQuestt) == 30 ||
                            (currNumberQuestt) == 42 ||
                            (currNumberQuestt) == 48 ||
                            (currNumberQuestt) == 54 ||
                            (currNumberQuestt) == 5 ||
                            (currNumberQuestt) == 15 ||
                            (currNumberQuestt) == 20 ||
                            (currNumberQuestt) == 29 ||
                            (currNumberQuestt) == 32 ||
                            (currNumberQuestt) == 34 ||
                            (currNumberQuestt) == 37 ||
                            (currNumberQuestt) == 41 ||
                            (currNumberQuestt) == 51
                            ){
                        testLogic.setTestAnswersMap(RESP_ZERO);

                    }else {
                    testLogic.setTestAnswersMap(RESP_ONE);
                    }
                    System.out.print("yesbuttonn");
                }
                if (buttonsGroup.getButtons().get(1).isChecked()){ // == noBut){ //.getChecked() == noBut){
                    if ((currNumberQuestt) == 12 ||
                            (currNumberQuestt) == 18 ||
                            (currNumberQuestt) == 30 ||
                            (currNumberQuestt) == 42 ||
                            (currNumberQuestt) == 48 ||
                            (currNumberQuestt) == 54 ||
                            (currNumberQuestt) == 5 ||
                            (currNumberQuestt) == 15 ||
                            (currNumberQuestt) == 20 ||
                            (currNumberQuestt) == 29 ||
                            (currNumberQuestt) == 32 ||
                            (currNumberQuestt) == 34 ||
                            (currNumberQuestt) == 37 ||
                            (currNumberQuestt) == 41 ||
                            (currNumberQuestt) == 51
                            ) {
                        testLogic.setTestAnswersMap(RESP_ONE);
                    }else {
                        testLogic.setTestAnswersMap(RESP_ZERO);
                    }
                    System.out.print("noButtonn");
//                    testLogic.setTestAnswersMap(respONE); //0);
                }

//System.out.print("kk == " + buttonsGroup.getChecked());  //.getButton().getKeyCode());
//                testLogic.setTestAnswersMap(1);


            } else {
                question = testLogic.getCurrentQuestionText();

                if (buttonsGroup.getButtons().get(0).isChecked()){ //getChecked()
                    testLogic.setTestAnswersMap(RESP_ONE);
                    System.out.print("yesbuttonn");
                }
                if (buttonsGroup.getButtons().get(1).isChecked()){ // == noBut){ //.getChecked() == noBut){
                    testLogic.setTestAnswersMap(RESP_ZERO);
                }

                createResultLabel();
//                resultTest();
//                testDone();
                return;
            }

            questionLabel.setText(question);

            yesBut.setChecked(false);
            noBut.setChecked(false);
//            event.reset();
//            noBut.reset();
        }



    };

    private void resultTest(){
        Test test = new Test();
        test.getTestResult();

    }


    private void testDone() {
        Gdx.app.exit();
    }

    private Actor createHeaderLabel() {
        Label headLabel = new Label(Assets.bdl().get("header"), uiSkin);
        headLabel.setFontScale(1.5f);
        headLabel.setAlignment(Align.center);
        return headLabel;
    }

    public void animateOpen() {
        MoveToAction action = Actions.moveTo(0, 0);
        action.setDuration(0.5f);
        leveMenu.addAction(action);
    }

    public void animateHide() {
        MoveToAction action = Actions.moveTo(0, h);
        action.setDuration(0.5f);
        leveMenu.addAction(action);
    }
}