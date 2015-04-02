package licenta.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import licenta.persistence.dao.UserDao;
import licenta.persistence.entities.UserEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Path("/user")
@Consumes("application/json")
@Produces("application/json")
public class UserController {

    @Autowired
    private UserDao userDao;
	/**
	 * Test method only
	 * 
	 * @return
	 */
	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public Response getCustomer(@PathParam("userId")long userId) {
		//Authentication auth = SecurityContextHolder.getContext()
		//		.getAuthentication();
		//System.out.println(auth.getName());
		//System.out.println(auth.getCredentials());
		UserEntity user = userDao.findById(userId);
		return Response.status(200).entity(user).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response validateCustomer(UserModel user) {
	    System.out.println("name");
	    UserEntity userEntity = new UserEntity();
	    System.out.println(user.getUserName());
	    userEntity.setUserName(user.getUserName());
	    userEntity.setPassword(user.getPassword());
	    userDao.persist(userEntity);
	    return Response.status(200).build();
	}
	
	@GET
	@Path("/{userName}")
	@Produces("application/json")
	public Response getCustomerByUsername(@PathParam("userName")String userName){
	    UserEntity user = userDao.findByUsername(userName);
	    
	    return Response.status(200).entity(user).build();
	   }

}
