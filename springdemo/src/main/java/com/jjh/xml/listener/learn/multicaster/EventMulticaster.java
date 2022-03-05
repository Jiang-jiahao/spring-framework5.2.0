package com.jjh.xml.listener.learn.multicaster;

import com.jjh.xml.listener.learn.event.WeatherEvent;
import com.jjh.xml.listener.learn.listener.WeatherListener;

public interface EventMulticaster {

	void multicasterEvent(WeatherEvent weatherEvent);

	void addListener(WeatherListener weatherListener);

	void removeListener(WeatherListener weatherListener);
}
