package com.randotimer;

import java.util.TimerTask;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;

public class updateWorkoutTimerTask extends TimerTask {
	
	private int counter = 0;
	private Integer workoutNumber;
	
	public updateWorkoutTimerTask(Integer workoutNumber) {
		this.workoutNumber = workoutNumber;
	}

	@Override
	public void run() {
		workoutNumber = ++counter;
		if (counter > 10)
			this.cancel();
	}
}
