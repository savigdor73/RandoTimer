package com.randotimer;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.wicket.Application;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.time.Duration;

import com.sun.xml.internal.ws.spi.db.FieldSetter;
public class RandoTimer extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7597692892004764401L;
    private TrainingParams trainingParams = new TrainingParams();
    private Map<String, Component> fields = new HashMap<String, Component>();
    private AjaxButton submit;
    private String goMessage = "Go!";
    private Label goMessageLabel = new Label("goMessage",goMessage);
    private Integer workoutNumber = 0;
    private Label workoutNumberLabel = new WorkoutIdLabel("workoutNumber",workoutNumber);
    private Integer timer = 3;
    private Label displayTimerLabel = new DisplayTimerLabel("timer",timer);
    private Component [] displayTimerNotifiedComps = new Component[1];
    private ComponentsNotifier displayTimerCompsNotifier = new ComponentsNotifier(displayTimerLabel,displayTimerNotifiedComps); 
    //private AjaxSelfUpdatingTimerBehavior updateCountdownBehavior = new AjaxSelfUpdatingTimerBehavior(Duration.seconds(1));
    private CountdownAjaxBehavior updateCountdownBehavior = new CountdownAjaxBehavior(Duration.seconds(1));
    private AjaxSelfUpdatingTimerBehavior updateWorkoutIdBehavior = new AjaxSelfUpdatingTimerBehavior(Duration.seconds(3));
    private String submitCaption = "Start";
    private PropertyModel<String> submitCaptionModel = new PropertyModel<String>(this,"submitCaption");
    private Label submitCaptionLabel;
    private Form <?> form = new Form<Void>("mainForm");
    
    @Override
    public void onEvent(IEvent<?> event) {
    	System.out.println("onEvent <page> called.\n");
    	if (event.getPayload() instanceof ComponentEvent)
    	{
    		ComponentEvent ce = (ComponentEvent)event.getPayload(); 
    		if (ce == ComponentEvent.TimerCompleted) {
    			updateCountdownBehavior.stop(null);
				updateWorkoutIdBehavior.stop(null);
				displayTimerLabel.setDefaultModelObject(timer);
				//submitCaptionModel.setObject("Start");
				this.send(submit, Broadcast.EXACT, ce);
    		}
    	}
    }
    
	public RandoTimer() {
		updateCountdownBehavior.stop(null);
		updateWorkoutIdBehavior.stop(null);
		displayTimerLabel.add(updateCountdownBehavior);
		workoutNumberLabel.add(updateWorkoutIdBehavior);
		goMessageLabel.setOutputMarkupId(true);
		workoutNumberLabel.setOutputMarkupId(true);
		displayTimerLabel.setOutputMarkupId(true);
		
	    fields.put("minNumber", 
	    		   new TextField<Integer>("minNumber",new PropertyModel<Integer>(trainingParams,"minNumber")));
	    fields.put("maxNumber", 
	    		   new TextField<Integer>("maxnNumber",new PropertyModel<Integer>(trainingParams,"maxNumber")));
	    fields.put("changeNumberDelay", 
	    		   new TextField<Integer>("changeNumberDelay",new PropertyModel<Integer>(trainingParams,"changeNumberDelay")));
	    fields.put("numSets", 
	    		   new TextField<Integer>("numSets",new PropertyModel<Integer>(trainingParams,"numSets")));
	    fields.put("setDuration", 
	    		   new TextField<Integer>("setDuration",new PropertyModel<Integer>(trainingParams,"setDuration")));
	    fields.put("waitTimeBeforeStart", 
	    		   new TextField<Integer>("waitTimeBeforeStart",new PropertyModel<Integer>(trainingParams,"waitTimeBeforeStart")));
	    
	    submit = new AjaxButton("submit",submitCaptionModel) {
	        @Override
	        public void onEvent(IEvent<?> event) {
	        	System.out.println("onEvent <submit> called.\n");
	        	if (event.getPayload() instanceof ComponentEvent)
	        	{
	        		ComponentEvent ce = (ComponentEvent)event.getPayload(); 
	        		if (ce == ComponentEvent.TimerCompleted) {
	    				submitCaptionModel.setObject("Start");
	    				this.onEvent(event);
	        		}
	        	}
	        }
	    	
	    };	
	    
	    //submitCaptionLabel = new Label("submitCaption",submitCaptionModel);
	    //submit.add(submitCaptionLabel);
	    //ubmitCaptionLabel.setOutputMarkupId(true);
	    AjaxEventBehavior clickBehavior = new AjaxEventBehavior("click") {
	    	
	    	boolean running=false;
			@Override
			protected void onEvent(AjaxRequestTarget target) {
				System.out.println("onEvent click called.\n");
				if (running==false) {
					updateCountdownBehavior.restart(target);
					updateWorkoutIdBehavior.restart(target);
					running = true;
					submitCaptionModel.setObject("Stop");					
				}
				else
				{
					updateCountdownBehavior.stop(target);
					updateWorkoutIdBehavior.stop(target);
					//displayTimerLabel.remove(updateCountdownBehavior);
					//workoutNumberLabel.remove(updateWorkoutIdBehavior);
					running=false;
					submitCaptionModel.setObject("Start");
				}
				target.add(displayTimerLabel,workoutNumberLabel,submit);
			}
	    }; 
	    submit.setOutputMarkupId(true);
	    form.add(submit);
	    add(form);
	    add(goMessageLabel);
	    add(workoutNumberLabel);
	    add(displayTimerLabel);
	}	
}