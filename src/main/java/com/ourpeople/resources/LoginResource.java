package com.ourpeople.resources;

import java.util.concurrent.atomic.AtomicLong;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.jetty.util.security.Password;

import com.google.common.base.Optional;
import com.ourpeople.models.Saying;
import com.ourpeople.models.UserDetails;
import com.ourpeople.services.OurPeopleUser;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import com.yammer.metrics.annotation.Timed;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {
	
	@GET
    @Timed
    @ApiOperation(value = "Get Sku by ID", notes = "Gets Sku for the given ID.", response = UserDetails.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful retrieval of Sku", response = UserDetails.class),
            @ApiResponse(code = 404, message = "Sku doesn't exist"), @ApiResponse(code = 500, message = "Internal server error") })
	public UserDetails sayHello(@QueryParam("name") String name, @QueryParam("password") String password) {
		return new OurPeopleUser().getUserDetails(name,password);
    }
}
