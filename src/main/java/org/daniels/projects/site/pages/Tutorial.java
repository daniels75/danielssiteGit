package org.daniels.projects.site.pages;

import java.util.List;

import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.appfuse.service.GenericManager;
import org.daniels.projects.site.entities.Address;

public class Tutorial {

	@Inject
	@Service("addressManager")
	private GenericManager<Address, Long> addressManager;

	public List<Address> getAddresses() {
		return addressManager.getAll();
	}
}
