package by.herzhot.html;

import by.herzhot.core.Clicker;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class ClickerHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new Clicker();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
