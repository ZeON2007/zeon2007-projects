package by.herzhot.html;

import by.herzhot.core.GameTest;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GameTestHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new GameTest();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
