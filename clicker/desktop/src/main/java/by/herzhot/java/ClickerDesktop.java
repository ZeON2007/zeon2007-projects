package by.herzhot.java;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import by.herzhot.core.Clicker;

import java.awt.*;

public class ClickerDesktop {
	public static void main (String[] args) {

		System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL30 = true;
		new LwjglApplication(new Clicker(), config);
	}
}
