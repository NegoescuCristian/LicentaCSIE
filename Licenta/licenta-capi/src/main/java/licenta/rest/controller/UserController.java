package licenta.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import licenta.persistence.dao.UserDao;
import licenta.persistence.entities.UserEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ro.licenta.customer.models.UserEntityResponse;
import ro.negoescu.licenta.user.UserService;

@Path("/user")
@Consumes("application/json")
@Produces("application/json")
public class UserController {

    @Autowired
    private UserService userService;

    protected Logger logger = LoggerFactory.getLogger(UserController.class);
	/**
	 * Test method only
	 * 
	 * @return
	 */
	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public Response getUser(@PathParam("userId")long userId) {

        UserEntityResponse userResponse = userService.getUserById(userId);
        if(userResponse == null) {
            return Response.status(404).build();
        }else {
            return Response.status(200).entity(userResponse).build();
        }
    }

	@POST
	@Path("/register")
	@Consumes("application/json")
	@Produces("application/json")
	public Response registerCustomer(UserModel user) {
        logger.info("Received userName {} and role {}",user.getUserName(),user.getUserRole());
	    boolean isRegistered = userService.registerCustomer(user.getUserName(),user.getPassword(), user.getUserRole());
        if(isRegistered) {
            return Response.status(200).build();
        }
        return Response.status(403).build();
	}
	
	@GET
	@Path("/getUser/{userName}")
	@Produces("application/json")
	public Response getCustomerByUsername(@PathParam("userName")String userName){
	    UserEntityResponse userResponse = userService.getUserByUserName(userName);
        if(userResponse == null) {
            return Response.status(404).build();
        }else {
            return Response.status(200).entity(userResponse).build();
        }
	   }
	
	@POST
	@Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response validateCustomer(UserModel user) {
        boolean isValidUser = userService.isValidUser(user.getUserName(), user.getPassword());
        if(!isValidUser) {
            return Response.status(404).build();
        }
        return Response.status(200).build();
    }
	
}
