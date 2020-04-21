package com.randotimer;

import org.apache.wicket.protocol.http.WebApplication;

public class RandoTimerApplication extends WebApplication {
    public RandoTimerApplication() {
    }
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class getHomePage() {
        return RandoTimer.class;
    }
}