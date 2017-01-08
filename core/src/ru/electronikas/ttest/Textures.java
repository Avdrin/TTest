package ru.electronikas.ttest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;


public class Textures {
    private static BitmapFont fontComic;
    private static Skin uiSkin;

    public static BitmapFont getFontComic() {
        if(fontComic == null) {
            fontComic = new BitmapFont(Gdx.files.internal("data/skins/comic.fnt"), Gdx.files.internal("data/skins/comic.png"), false);
        }
        return fontComic;
    }

    public static Skin getUiSkin() {
        if(uiSkin == null) {
            uiSkin = new Skin(Gdx.files.internal("data/skins/uiskin.json"));
        }
        return uiSkin;
    }

}
