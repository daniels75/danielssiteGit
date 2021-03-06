package org.daniels.projects.site.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

	@DELETE
	@Path("/delete/{id}")
	public Response deletePerson(@PathParam("id") Long id);
	
	@DELETE
	@Path("{id}")
	public Response deletePersonByLastName(@PathParam("id") Long id);
	
	@PUT 
	@Path("/put")
	@Consumes(MediaType.APPLICATION_JSON)
	Response updatePerson(Person person);
	
	@PUT 
	@Consumes(MediaType.APPLICATION_JSON)
	Response updatePersonNoContext(Person person);

	
}