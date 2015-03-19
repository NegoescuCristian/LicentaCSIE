package licenta.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import licenta.persistence.dao.CustomerDao;
import licenta.persistence.entities.CustomerEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Path("/customer")
@Consumes("application/json")
@Produces("application/json")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;
	/**
	 * Test method only
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getCustomer() {
		//Authentication auth = SecurityContextHolder.getContext()
		//		.getAuthentication();
		//System.out.println(auth.getName());
		//System.out.println(auth.getCredentials());
		CustomerEntity customer = customerDao.findById(5);
		return Response.status(200).entity(customer.getName()).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response validateCustomer() {
	    System.out.println("name");
	    CustomerEntity customerEntity = new CustomerEntity();
	    customerEntity.setName("ffffffffffffff");
	    customerDao.persist(customerEntity);
	    return Response.status(200).build();
	}

}
