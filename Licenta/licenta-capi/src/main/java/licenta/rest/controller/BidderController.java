package licenta.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import ro.licenta.models.BidModel;
import ro.negoescu.licenta.bid.BidderService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by churmuzache on 6/12/15.
 */
@Path("/bid")
public class BidderController {

    @Autowired
    private BidderService bidderService;

    @POST
    @Consumes("application/json")
    public Response bid(BidModel bidModel) {

        boolean isPersisted = bidderService.makeBid(bidModel);
        if(isPersisted) {
            return Response.status(HttpStatus.OK.value()).build();
        }

        return Response.status(HttpStatus.NOT_FOUND.value()).build();
    }

    @GET
    public Response getBulkParams(@Context UriInfo allUri) {

        MultivaluedMap<String, String> maps = allUri.getQueryParameters();

        System.out.println(maps);

        return null;
    }



}
