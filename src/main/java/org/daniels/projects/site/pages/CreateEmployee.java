package org.daniels.projects.site.pages;

import org.apache.log4j.Logger;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
//import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.daniels.projects.site.entities.Employee;
import org.hibernate.Session;


public class CreateEmployee {
	
	private Logger logger = Logger.getLogger(CreateEmployee.class);
	
	@Property
	private Employee employee;

	@Inject
	private Session session;

	@InjectPage
	private Index index;

	//@CommitAfter
	Object onSuccess() {
		session.persist(employee);
		logger.info(">>>> Created employee: " + employee);
		return index;
	}
}
