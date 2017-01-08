package ru.electronikas.ttest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import ru.electronikas.ttest.ui.TestUI;

public class TemperamentTestGame extends ApplicationAdapter {
	SpriteBatch batch;
    Stage stage;
    TestUI testUI;

	@Override
	public void create () {
		batch = new SpriteBatch();
        stage = new Stage();

        testUI = new TestUI(stage);
        testUI.animateOpen();
	}

    private void createButtons() {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        float butW = w / 4;
        float butH = h / 15;

        Label gameName = new Label(Assets.bdl().get("gameName"), Textures.getUiSkin());
        gameName.setFontScale(1);
        gameName.setAlignment(Align.center);
        gameName.setPosition(w/2 - gameName.getPrefWidth()/2, butH * 13);

        stage.addActor(gameName);
    }


    @Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
	}
}
