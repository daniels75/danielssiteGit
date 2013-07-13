package org.daniels.projects.site.services.impl;

import java.util.List;

import javax.jws.WebService;

import org.appfuse.service.impl.GenericManagerImpl;
import org.daniels.projects.site.dao.AddressDao;
import org.daniels.projects.site.entities.Address;
import org.daniels.projects.site.services.AddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addressManager")
@WebService(serviceName = "AddressService", endpointInterface = "org.daniels.projects.site.services.PersonManager")
public class AddressManagerImpl extends GenericManagerImpl<Address, Long>
		implements AddressManager {
	AddressDao addressDao;

	public AddressManagerImpl() {
	}

	@Autowired
	public AddressManagerImpl(AddressDao addressDao) {
		super(addressDao);
		this.addressDao = addressDao;
	}
	
	public List<Address> getAddresses() {
		return addressDao.getAll();
	}


}