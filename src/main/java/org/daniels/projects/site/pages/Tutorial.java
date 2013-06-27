package org.daniels.projects.site.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.daniels.projects.site.entities.Address;
import org.hibernate.Session;


public class Tutorial {
    @Inject
    private Session session;
	
    public List<Address> getAddresses()
    {
        return session.createCriteria(Address.class).list();
        //return new ArrayList<Address>();
    }
}
