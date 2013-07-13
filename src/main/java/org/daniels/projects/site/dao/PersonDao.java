package org.daniels.projects.site.dao;

import org.appfuse.dao.GenericDao;
import org.daniels.projects.site.entities.Person;

import java.util.List;

public interface PersonDao extends GenericDao<Person, Long> {
    public List<Person> findByLastName(String lastName);
}