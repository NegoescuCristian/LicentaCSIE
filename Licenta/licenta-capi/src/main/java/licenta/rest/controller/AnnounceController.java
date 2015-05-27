package licenta.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ro.licenta.customer.models.AnnounceModel;
import ro.negoescu.licenta.announce.AnnounceService;

@Path("/announce")
public class AnnounceController {

    @Autowired
    private AnnounceService announceService;
   
    //private TestService testService;

    protected Logger logger = LoggerFactory.getLogger(AnnounceController.class);
    
    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response registerAnnounce(AnnounceModel announce){
        boolean isSaved = announceService.registerAnnounce(announce);
        if(!isSaved){
            logger.error("Error when saving announce");
            return Response.status(500).build();
        }
      
        return Response.status(200).build();
    }

}
