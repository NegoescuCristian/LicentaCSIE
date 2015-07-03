package licenta.rest.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import ro.licenta.customer.models.AnnounceDetailsComplexResponse;
import ro.licenta.customer.models.AnnounceDetailsResponse;
import ro.licenta.customer.models.AnnounceModel;
import ro.negoescu.licenta.announce.AnnounceService;

import java.util.List;

@Path("/announce")
public class AnnounceController {

    @Autowired
    private AnnounceService announceService;

    //private TestService testService;

    private static final Logger logger = LoggerFactory.getLogger(AnnounceController.class);
    
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

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public Response getAllAnnounces() {
        List<AnnounceDetailsResponse> response = announceService.getAnnounceDetails();
        if(response == null) {
            logger.error("No announce was found in DB");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @GET
    @Path("/{announceId}")
    @Produces("application/json")
    public Response getAnnounceByAnnounceId(@PathParam("announceId") long announceId) {
        AnnounceDetailsComplexResponse response = announceService.getAnnounceByAnnounceId(announceId);
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @GET
    @Path("/category/{category}")
    @Produces("application/json")
    public Response getAnnounceByCategory(@PathParam("category") String category) {
        List<AnnounceDetailsResponse> response = announceService.getAnnounceByCategory(category);

        logger.info("response size:"+response.size());

        return Response.status(Response.Status.OK).entity(response).build();
    }

}
