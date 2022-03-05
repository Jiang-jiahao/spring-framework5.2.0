package com.jjh.xml.listener.learn.listener;

import com.jjh.xml.listener.learn.event.RainEvent;
import com.jjh.xml.listener.learn.event.WeatherEvent;

public class RainListener implements WeatherListener {

	@Override
	public void onWeatherEvent(WeatherEvent weatherEvent) {
		if (weatherEvent instanceof RainEvent) {
			System.out.println("hello " + weatherEvent.getWeather());
		}
	}
}
