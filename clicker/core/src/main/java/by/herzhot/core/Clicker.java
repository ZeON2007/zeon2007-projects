package by.herzhot.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import java.awt.*;

public class Clicker implements ApplicationListener, InputProcessor {

	Robot robot;
	boolean isRunning = false;

	@Override
	public void create () {

		Gdx.input.setInputProcessor(this);


		try {
			robot = new Robot();
//			robot.setAutoDelay(500);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void resize (int width, int height) {}

	@Override
	public void render () {
		if (checkIsRunning()) {
			robot.mouseMove(1000, 500);
		}
	}

	private boolean checkIsRunning() {
//		if (Gdx.input.isKeyJustPressed(Input.Keys.F9)) {
//			isRunning = true;
//			System.out.println("RUN!");
//		} else if (Gdx.input.isKeyJustPressed(Input.Keys.F10)) {
//			isRunning = false;
//			System.out.println("STOP!");
//		}
		return isRunning;
	}

	@Override
	public void pause () {}

	@Override
	public void resume () {}

	@Override
	public void dispose () {}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.F9) {
			isRunning = true;
			System.out.println("RUN!");
		} else if (keycode == Input.Keys.F10) {
			isRunning = false;
			System.out.println("STOP!");
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
