package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.model.Treasure;
import org.devoware.encounterplanner.service.EncounterPlannerService;

@Path("treasure-generator")
public class TreasureGeneratorResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("treasureType") String treasureType, @QueryParam("challengeRating") String challengeRating ) {
		try {
            Treasure treasure = service.generateTreasure(treasureType, challengeRating);
	        return Response.ok(treasure).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
