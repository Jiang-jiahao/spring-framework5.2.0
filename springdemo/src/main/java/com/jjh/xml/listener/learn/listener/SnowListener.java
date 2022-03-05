package com.jjh.xml.listener.learn.listener;

import com.jjh.xml.listener.learn.event.SnowEvent;
import com.jjh.xml.listener.learn.event.WeatherEvent;

public class SnowListener implements WeatherListener {

	@Override
	public void onWeatherEvent(WeatherEvent weatherEvent) {
		if (weatherEvent instanceof SnowEvent) {
			System.out.println("hello " + weatherEvent.getWeather());
		}
	}
}
