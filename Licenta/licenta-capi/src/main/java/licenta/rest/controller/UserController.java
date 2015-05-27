package licenta.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

import ro.licenta.customer.models.AccountDetailsResponse;
import ro.licenta.customer.models.AnnounceModel;
import ro.licenta.customer.models.UserEntityResponse;
import ro.negoescu.licenta.announce.AnnounceService;
import ro.negoescu.licenta.user.UserService;

import ro.licenta.models.UserModel;

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
    public Response getUser(@PathParam("userId") long userId) {

        UserEntityResponse userResponse = userService.getUserById(userId);
        if (userResponse == null) {
            logger.error("User with userId <%s> was not found", userId);
            return Response.status(HttpStatus.NOT_FOUND.value()).build();
        } else {
            return Response.status(HttpStatus.OK.value()).entity(userResponse).build();
        }
    }

    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response registerCustomer(UserModel user) {
        logger.info("Received userName <%s> and role <%s>", user.getUserName(), user.getUserRole());
        boolean isRegistered = userService.registerCustomer(user);
        if (isRegistered) {
            return Response.status(HttpStatus.OK.value()).build();
        }
        return Response.status(HttpStatus.FORBIDDEN.value()).build();
    }

    @GET
    @Path("/getUser/{userName}")
    @Produces("application/json")
    public Response getCustomerByUsername(@PathParam("userName") String userName) {
        UserEntityResponse userResponse = userService.getUserByUserName(userName);
        if (userResponse == null) {
            return Response.status(HttpStatus.NOT_FOUND.value()).build();
        } else {
            return Response.status(HttpStatus.OK.value()).entity(userResponse).build();
        }
    }

    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response validateCustomer(UserModel user) {
        boolean isValidUser = userService.isValidUser(user.getUserName(), user.getPassword());
        if (!isValidUser) {
            return Response.status(HttpStatus.NOT_FOUND.value()).build();
        }
        return Response.status(HttpStatus.OK.value()).build();
    }

    @GET
    @Path("/details/{userName}")
    @Produces("application/json")
    public Response getAccountDetails(@PathParam("userName") String userName) {
        AccountDetailsResponse response = userService.getAccountDetails(userName);
        logger.info("Getting account details for user name %s",userName);
        if (response == null) {
            logger.error("No client was found for userName <%s>", userName);
            return Response.status(HttpStatus.NOT_FOUND.value()).entity(null).build();
        }
        return Response.status(HttpStatus.OK.value()).entity(response).build();
    }
    
   
}
