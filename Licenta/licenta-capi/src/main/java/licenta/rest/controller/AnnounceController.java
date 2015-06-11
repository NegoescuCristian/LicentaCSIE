package licenta.rest.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import ro.licenta.customer.models.AnnounceDetailsResponse;
import ro.licenta.customer.models.AnnounceModel;
import ro.negoescu.licenta.announce.AnnounceService;

import java.util.List;

@Path("/announce")
public class AnnounceController {

    @Autowired
    private AnnounceService announceService;
   
    //private TestService testService;

    protected Logger logger = LoggerFactory.getLogger(AnnounceController.class);
    
    @POST
    @Path("/register/{user_name}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response registerAnnounce(@PathParam("user_name") String userName,AnnounceModel announce){
        boolean isSaved = announceService.registerAnnounce(announce, userName);
        if(!isSaved){
            logger.error("Error when saving announce");
            return Response.status(500).build();
        }
      
        return Response.status(200).build();
    }

}
