package com.randotimer;

import org.apache.wicket.markup.html.basic.Label;

public class WorkoutIdLabel extends Label
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1452278814350329770L; 

	public WorkoutIdLabel(String id, int workoutId)
    {
        super(id, new WorkoutIdModel(workoutId));
    }
	
	/*@Override
	public void onEvent(IEvent event) {
		if (event.getPayload() instanceof TimerCompleted)
			this.remove(behaviors)
	}*/
}