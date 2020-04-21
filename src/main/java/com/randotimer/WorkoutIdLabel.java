package com.randotimer;

import java.util.Random;

import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

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

    /**
     * A model that returns current time in the specified timezone via a formatted string
     * 
     * @author Igor Vaynberg (ivaynberg)
     */
    private static class WorkoutIdModel implements IModel<Integer>
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
    }
}