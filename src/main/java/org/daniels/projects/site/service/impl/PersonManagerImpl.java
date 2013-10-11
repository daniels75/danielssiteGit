package org.daniels.projects.site.service.impl;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

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

	@Override
	public Response createPersonInJSON(Person person) {
		String result = "Person saved : " + person;
		personDao.save(person);
		return Response.status(201).entity(result).build();
	}

	@Override
	public Response deletePerson(Long id) {
		personDao.remove(id);
		String result = "Person deleted : " + id;
		return Response.status(201).entity(result).build();
	}

	@Override
	public Response deletePersonByLastName(Long id) {
		personDao.remove(id);
		String result = "Person deleted : " + id;
		return Response.status(201).entity(result).build();
	}

	@Override
	public Response updatePerson(Person person) {
		personDao.save(person);
		String result = "Person updated : " + person;
		return Response.status(201).entity(result).build();
	}

	@Override
	public Response updatePersonNoContext(Person person) {
		personDao.save(person);
		String result = "Person updated : " + person;
		return Response.status(201).entity(result).build();
	}
	
	
}