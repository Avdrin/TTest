package ru.electronikas.ttest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import ru.electronikas.ttest.logic.Test;
import ru.electronikas.ttest.ui.TestUI;

public class TemperamentTestGame extends ApplicationAdapter {
    Stage stage;
    TestUI testUI;
    Test testLogic;

	@Override
	public void create () {
        stage = new Stage();
        testLogic = new Test();
        testUI = new TestUI(stage, testLogic);
        testUI.animateOpen();
	}

    @Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
	}
}
