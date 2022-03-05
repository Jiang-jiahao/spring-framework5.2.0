package com.jjh.xml.listener.learn.listener;

import com.jjh.xml.listener.learn.event.RainEvent;
import com.jjh.xml.listener.learn.event.SnowEvent;
import com.jjh.xml.listener.learn.multicaster.EventMulticaster;
import com.jjh.xml.listener.learn.multicaster.WeatherEventMulticaster;

public class WeatherRunListener {

	private EventMulticaster eventMulticaster = new WeatherEventMulticaster(){
		{
			addListener(new SnowListener());
			addListener(new RainListener());
		}
	};

	public void snow(){
		eventMulticaster.multicasterEvent(new SnowEvent());
	}


	public void rain(){
		eventMulticaster.multicasterEvent(new RainEvent());
	}
}
