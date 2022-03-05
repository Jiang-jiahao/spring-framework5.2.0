package com.jjh.xml.listener.learn;

import com.jjh.xml.listener.learn.event.RainEvent;
import com.jjh.xml.listener.learn.event.SnowEvent;
import com.jjh.xml.listener.learn.listener.RainListener;
import com.jjh.xml.listener.learn.listener.SnowListener;
import com.jjh.xml.listener.learn.listener.WeatherRunListener;
import com.jjh.xml.listener.learn.multicaster.WeatherEventMulticaster;

public class Test {

	public static void main(String[] args) {
		//普通调用
//		WeatherEventMulticaster weatherEventMulticaster = new WeatherEventMulticaster();
//		RainListener rainListener = new RainListener();
//		weatherEventMulticaster.addListener(rainListener);
//		SnowListener snowListener = new SnowListener();
//		weatherEventMulticaster.addListener(snowListener);
//		weatherEventMulticaster.multicasterEvent(new SnowEvent());
//		weatherEventMulticaster.multicasterEvent(new RainEvent());
//		weatherEventMulticaster.removeListener(rainListener);
//		weatherEventMulticaster.multicasterEvent(new SnowEvent());
//		weatherEventMulticaster.multicasterEvent(new RainEvent());
		//运行器调用
		WeatherRunListener weatherRunListener = new WeatherRunListener();
		weatherRunListener.rain();
		weatherRunListener.snow();
	}
}
