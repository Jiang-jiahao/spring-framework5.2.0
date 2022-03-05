package com.jjh.xml.listener.learn.multicaster;

public class WeatherEventMulticaster extends AbstractEventMulticaster {

	@Override
	void doStart() {
		System.out.println("开始广播监听事件");
	}

	@Override
	void doEnd() {
		System.out.println("结束广播监听事件");
	}
}
