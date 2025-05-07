package com.demo.project.resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerDemo {

	@Scheduled(fixedDelayString = "${time.interval}")
	public void printHello() {
		System.out.println("Hello");
	}
}
