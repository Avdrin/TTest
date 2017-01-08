package ru.electronikas.ttest.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.electronikas.ttest.TemperamentTestGame;

import java.util.Locale;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		Locale.setDefault(new Locale("ru", "RU"));
//		Locale.setDefault(new Locale("en", "US"));

		config.width = 500;
		config.height = 809;
		new LwjglApplication(new TemperamentTestGame(), config);
	}
}
