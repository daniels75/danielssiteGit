package org.daniels.projects.site.services;

import org.appfuse.service.GenericManager;
import org.daniels.projects.site.entities.Person;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@WebService
@Path("/people")
public interface PersonManager extends GenericManager<Person, Long> {

    @GET
    @Path("{lastname}")
    List<Person> findByLastName(@PathParam("lastname") String lastName);

    @GET
    List<Person> getPeople();
}