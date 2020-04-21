package com.randotimer;

import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

public class DisplayTimerLabel extends Label {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8061682939598510826L; 

	public DisplayTimerLabel(String id, Integer countdownTimer) {
		//super(id, new DisplayTimerModel(countdownTimer)); 
		super(id, countdownTimer);
	}
	
	@Override
	public void onModelChanged()
	{
		Integer currentValue = (Integer)this.getDefaultModel().getObject();
		if (currentValue == 0)
			send(this.getWebPage(), Broadcast.EXACT, ComponentEvent.TimerCompleted);
	}
	
	/*private static class DisplayTimerModel implements IModel<Integer>
	{
		private static final long serialVersionUID = -5664225197943441338L;
		private Integer countdownTimer;
		
		public DisplayTimerModel(Integer countdownTimer)
	    {
	        this.countdownTimer = countdownTimer;
	    }
			
		public Integer getObject() {
			countdownTimer--;
			if (countdownTimer < 0) 
				return 0;
			return countdownTimer;
		}
		
		
	}*/
}