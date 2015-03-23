package licenta.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	@Path("/{customerId}")
	@Produces("application/json")
	public Response getCustomer(@PathParam("customerId")long customerId) {
		//Authentication auth = SecurityContextHolder.getContext()
		//		.getAuthentication();
		//System.out.println(auth.getName());
		//System.out.println(auth.getCredentials());
		CustomerEntity customer = customerDao.findById(customerId);
		return Response.status(200).entity(customer).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response validateCustomer(CustomerModel customer) {
	    System.out.println("name");
	    CustomerEntity customerEntity = new CustomerEntity();
	    System.out.println(customer.getName());
	    customerEntity.setName(customer.getName());
	    customerDao.persist(customerEntity);
	    return Response.status(200).build();
	}

}
