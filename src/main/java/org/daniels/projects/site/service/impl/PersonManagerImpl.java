package org.daniels.projects.site.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.appfuse.service.impl.GenericManagerImpl;
import org.daniels.projects.site.dao.PersonDao;
import org.daniels.projects.site.entities.Person;
import org.daniels.projects.site.service.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personManager")
@WebService(serviceName = "PersonService", endpointInterface = "org.daniels.projects.site.service.PersonManager")
public class PersonManagerImpl extends GenericManagerImpl<Person, Long>
		implements PersonManager {
	PersonDao personDao;

	public PersonManagerImpl() {
	}

	@Autowired
	public PersonManagerImpl(PersonDao personDao) {
		super(personDao);
		this.personDao = personDao;
	}

	public List<Person> findByLastName(String lastName) {
		return personDao.findByLastName(lastName);
	}

	public List<Person> getPeople() {
		return personDao.getAll();
	}
}