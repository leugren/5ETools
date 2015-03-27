package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.model.EncounterStats;
import org.devoware.encounterplanner.service.EncounterPlannerService;

@Path("difficulty-calculator")
public class DifficultyCalculatorResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("party") String party, @QueryParam("encounter") String encounter ) {
		try {
			EncounterStats stats = service.getEncounterStats(party, encounter);
	        return Response.ok(stats).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
