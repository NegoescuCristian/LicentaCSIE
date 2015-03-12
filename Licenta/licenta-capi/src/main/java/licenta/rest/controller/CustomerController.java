package licenta.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Path("/customer")
public class CustomerController {

	/**
	 * Test method only
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getCustomer() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		System.out.println(auth.getName());
		System.out.println(auth.getCredentials());
		return Response.status(200).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response validateCustomer() {

		return null;
	}

}
