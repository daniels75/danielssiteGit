package org.daniels.projects.site.dao.hibernate;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.daniels.projects.site.dao.AddressDao;
import org.daniels.projects.site.entities.Address;
import org.springframework.stereotype.Repository;


@Repository("addressDao")
public class AddressDaoHibernate extends GenericDaoHibernate<Address, Long> implements AddressDao {

    public AddressDaoHibernate() {
        super(Address.class);
    }

}