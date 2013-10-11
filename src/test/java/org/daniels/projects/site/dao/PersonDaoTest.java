package org.daniels.projects.site.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.daniels.projects.site.entities.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

public class PersonDaoTest extends BaseDaoTestCase {
    @Autowired
    private PersonDao personDao;

    @Test
    public void testFindPersonByLastName() throws Exception {
        List<Person> people = personDao.findByLastName("Sadowski");
        assertTrue(people.size() > 0);
    }

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemovePerson() throws Exception {
        Person person = new Person();
        person.setFirstName("Country");
        person.setLastName("Bry");

        person = personDao.save(person);
        flush();

        person = personDao.get(person.getId());

        assertEquals("Country", person.getFirstName());
        assertNotNull(person.getId());

        log.debug("removing person...");

        personDao.remove(person.getId());
        flush();

        // should throw DataAccessException
        personDao.get(person.getId());
    }
}