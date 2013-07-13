package org.daniels.projects.site.services;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.appfuse.service.GenericManager;
import org.daniels.projects.site.entities.Address;

@WebService
@Path("/address")
public interface AddressManager extends GenericManager<Address, Long> {

    @GET
    List<Address> getAddresses();
}