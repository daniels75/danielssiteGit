package org.daniels.projects.site.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.appfuse.service.GenericManager;
import org.daniels.projects.site.entities.Person;

@WebService
@Path("/people")
public interface PersonManager extends GenericManager<Person, Long> {

    @GET
    @Path("{lastname}")
    List<Person> findByLastName(@PathParam("lastname") String lastName);

    @GET
    List<Person> getPeople();
    
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	Response createPersonInJSON(Person person);


	
}