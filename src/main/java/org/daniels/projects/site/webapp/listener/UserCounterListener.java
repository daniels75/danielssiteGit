package org.daniels.projects.site.webapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * UserCounterListener class used to count the current number of active users
 * for the applications. Does this by counting how many user objects are stuffed
 * into the session. It also grabs these users and exposes them in the servlet
 * context.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class UserCounterListener implements ServletContextListener,
		HttpSessionAttributeListener, HttpSessionListener {

	public synchronized void contextInitialized(ServletContextEvent sce) {

	}

	/**
	 * Set the servletContext, users and counter to null
	 * 
	 * @param event
	 *            The servletContextEvent
	 */
	public synchronized void contextDestroyed(ServletContextEvent event) {

	}

	/**
	 * This method is designed to catch when user's login and record their name
	 * 
	 * @param event
	 *            the event to process
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {

	}

	/**
	 * When user's logout, remove their name from the hashMap
	 * 
	 * @param event
	 *            the session binding event
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {

	}

	/**
	 * Needed for Acegi Security 1.0, as it adds an anonymous user to the
	 * session and then replaces it after authentication.
	 * http://forum.springframework.org/showthread.php?p=63593
	 * 
	 * @param event
	 *            the session binding event
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {

	}

	public void sessionCreated(HttpSessionEvent se) {
	}

	public void sessionDestroyed(HttpSessionEvent se) {

	}
}
