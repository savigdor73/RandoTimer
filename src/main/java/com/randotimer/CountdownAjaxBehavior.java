package com.randotimer;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AbstractAjaxTimerBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.util.time.Duration;



public class CountdownAjaxBehavior extends AbstractAjaxTimerBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5546029039535569175L;

	public CountdownAjaxBehavior(Duration updateInterval) {
		super(updateInterval);
	}

	@Override
	protected void onTimer(AjaxRequestTarget target) {
		Component boundComponent = this.getComponent(); 
		Integer countdownTimer = (Integer)boundComponent.getDefaultModelObject();
		countdownTimer--;
		if (countdownTimer < 0) 
		{
			boundComponent.setDefaultModelObject(new Integer(0));
			target.add(boundComponent);
			return;
		}
		boundComponent.setDefaultModelObject(new Integer(countdownTimer));
		target.add(boundComponent);
	}
}
