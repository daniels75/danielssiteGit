package org.daniels.projects.site.services;

import org.appfuse.model.User;

/**
 *
 * Sends email notification
 *
 * @author Serge Eby
 */
public interface EmailService {
    void send(User user, String subject, String message, String url, boolean hint);
}
