package com.jjh.xml.listener.learn.multicaster;

import com.jjh.xml.listener.learn.event.WeatherEvent;
import com.jjh.xml.listener.learn.listener.WeatherListener;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEventMulticaster implements EventMulticaster {

	private List<WeatherListener> listenerList = new ArrayList<>();

	@Override
	public void multicasterEvent(WeatherEvent weatherEvent) {
		doStart();
		listenerList.forEach(i -> i.onWeatherEvent(weatherEvent));
		doEnd();
	}


	@Override
	public void removeListener(WeatherListener weatherListener) {
		listenerList.remove(weatherListener);
	}

	@Override
	public void addListener(WeatherListener weatherListener) {
		listenerList.add(weatherListener);
	}


	abstract void doStart();

	abstract void doEnd();
}
