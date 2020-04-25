package com.randotimer;

import java.util.Random;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.IDetachable;

public class WorkoutIdModel implements IModel<Integer>,IDetachable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2935662640876222468L;
	private static Integer workoutId; 

    public WorkoutIdModel(Integer workoutId)
    {
        this.workoutId = workoutId;
    }

	public Integer getObject() {
		Random r = new Random();
		return r.nextInt((3-1)+1)+1;
	}
	
	public void detach() {
		
	}
}