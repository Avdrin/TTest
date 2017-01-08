package ru.electronikas.ttest.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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

import java.util.HashMap;
import java.util.Map;

public class TestUI {
    public static final float SELECTED_FONT_SCALE = 1.3f;

    Map<Integer, String> lineQuestion = new HashMap<Integer, String>();

    //    TextView tvOut;
    Label info;

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
        leveMenu = new Table(uiSkin);
        leveMenu.align(Align.topLeft);
        leveMenu.setPosition(0, 0); //h);
        leveMenu.setWidth(w);
        leveMenu.setHeight(h);
        leveMenu.defaults().width(w);
        leveMenu.row().height(h / 4);
        leveMenu.add(createHeaderLabel());
        leveMenu.row().height(h * (2f / 6 + 1f / 8)); //h / 8); //.width(w / 6);  //.height(h * (2f / 4 + 1f / 8));
        leveMenu.add(levelsBlock());
        leveMenu.row().height(h / 8).width(w / 4);
        leveMenu.add(nextButton());
        leveMenu.row().height(h / 8).width(w / 4);
        leveMenu.add(exitButton());
        leveMenu.setDebug(true);
        stage.addActor(leveMenu);
        Gdx.input.setInputProcessor(stage);  // Gdx.input.setInputProcessor(stage);

    }


    Table lvlTable;

    private Actor levelsBlock() {

        lvlTable = new Table();
        lvlTable.setSkin(Textures.getUiSkin());
        lvlTable.align(Align.center);
        lvlTable.defaults().width(20 * butW).height(h / 8);
        lvlTable.row().height(h / 8).width(w / 6);

        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.checked = uiSkin.newDrawable("white", Color.MAGENTA);//getDrawable("checked-button"); //""//new Drawable("wed",1234,3421,2342,50));

        buttonStyle.font = new BitmapFont();

        buttonStyle.up = uiSkin.newDrawable("white", Color.LIGHT_GRAY); //skin.getDrawable("up-button");
        buttonStyle.down = uiSkin.newDrawable("white", Color.DARK_GRAY); //skin.getDrawable("down-button");
//        textButtonStyle.checked = skin.getDrawable("checked-button");
        TextButton exitButton23 = new TextButton(Assets.bdl().get("exitButton"), Textures.getUiSkin());//"Button1", buttonStyle);
        TextButton exitButton24 = new TextButton(Assets.bdl().get("exitButton"), Textures.getUiSkin());//"Button1", buttonStyle);
        exitButton23.setStyle(buttonStyle);
        exitButton23.setText("Yes");

        exitButton24.setStyle(buttonStyle);
        exitButton24.setText("No");


        exitButton23.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                System.out.print("exitButton1.");
            }
        });
        exitButton24.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                System.out.print("exitButton2.");
            }
        });
//        TextButton exitButton2 = new TextButton(Assets.bdl().get("exitButton"), Textures.getUiSkin());
//        TextButton exitButton3 = new TextButton(Assets.bdl().get("exitButton"), Textures.getUiSkin());

        ButtonGroup<Button> buttons = new ButtonGroup<Button>(); //exitButton1, exitButton2, exitButton3);
        buttons.setMaxCheckCount(1);
        buttons.setMinCheckCount(0);
        buttons.setUncheckLast(true);
        buttons.add(exitButton23);
        buttons.add(exitButton24);

        lvlTable.add(exitButton23);
        lvlTable.add(exitButton24);


        ScrollPane scrollPane = new ScrollPane(lvlTable, Textures.getUiSkin());
        scrollPane.setWidth(butW);
//        scrollPane.setHeight(h/2);
        scrollPane.getStyle().background = null;
        return scrollPane;
    }

/*
    private void createRowByLevel(Level lvl, Table lvlTable) {
        final Label nameLabel = new Label(lvl.name(), Textures.getUiSkin());
        nameLabel.setAlignment(Align.center);
        nameLabel.setUserObject(lvl);
        nameLabel.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Level lvl = (Level)event.getListenerActor().getUserObject();
//                Assets.reloadModelByLevel(lvl);
                if(lvl.ordinal() <= Level.getCurrentLevel().ordinal()) {
                    currentLevel = lvl;
                    setSelected(nameLabel);
                }
//                nameLabel.setColor(Color.GREEN);
            }
        });

        if(lvl.ordinal() <= currentLevel.ordinal()) {
            nameLabel.setColor(Color.WHITE);
            if(lvl.ordinal() == currentLevel.ordinal()) {
                nameLabel.setFontScale(SELECTED_FONT_SCALE);
            }
        } else {
            nameLabel.setColor(Color.DARK_GRAY);
        }

        lvlTable.row();
        lvlTable.add(nameLabel).width(butW*0.8f);

    }
*/

    private void setSelected(Label nameLabel) {
        for (Cell cell : lvlTable.getCells()) {
            ((Label) cell.getActor()).setFontScale(1);
        }
        nameLabel.setFontScale(SELECTED_FONT_SCALE);
    }


    private Actor openLevelButton() {
        TextButton openLevelBut = new TextButton(Assets.bdl().get("question1"), Textures.getUiSkin());
        openLevelBut.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        return openLevelBut;
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

    private Actor nextButton() {
        TextButton nextButton = new TextButton(Assets.bdl().get("nextButton"), Textures.getUiSkin());
        nextButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                String question = null;

                if(testLogic.goToNextQuestion()) {
                  question = testLogic.getCurrentQuestionText();
                } else {
                    testDone();
                    return;
                }

                Cell<Label> hb = lvlTable.getCell(info);
                if (hb != null) {
                    lvlTable.getCell(info).reset();
                }
                info = new Label(question, uiSkin);
                info.setWrap(true);
                lvlTable.add(info).width(w);
                System.out.print("nextButtonnn.= " + testLogic.getQuestionNumber());
            }
        });
        return nextButton;
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