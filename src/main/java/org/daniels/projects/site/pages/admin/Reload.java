package org.daniels.projects.site.pages.admin;

import java.io.IOException;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.alerts.Duration;
import org.apache.tapestry5.alerts.Severity;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ApplicationGlobals;
import org.daniels.projects.site.listener.StartupListener;
import org.daniels.samples.webapp.pages.Home;

/**
 * @author Serge Eby
 * @version $Id: Reload.java 5 2008-08-30 09:59:21Z serge.eby $
 */
public class Reload {
    @Inject
    private Messages messages;

    @Inject
    private ApplicationGlobals globals;

    @Inject
    private AlertManager alertManager;


    Object onActivate() throws IOException {
        StartupListener.setupContext(globals.getServletContext());
        alertManager.alert(Duration.TRANSIENT,
                Severity.INFO,
                messages.get("reload.succeeded"));
        return Home.class;
    }

}