package org.daniels.projects.site.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.daniels.projects.site.dao.PersonDao;
import org.daniels.projects.site.entities.Person;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoHibernate extends GenericDaoHibernate<Person, Long> implements PersonDao {

    public PersonDaoHibernate() {
        super(Person.class);
    }

    public List<Person> findByLastName(String lastName) {
        return getSession().createCriteria(Person.class).add(Restrictions.eq("lastName", lastName)).list();
    }
}