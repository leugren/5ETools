package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.model.MonsterStatistics;
import org.devoware.encounterplanner.service.EncounterPlannerService;

@Path("monster-stat-generator")
public class MonsterStatGeneratorResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("challengeRating") @DefaultValue("1") double challengeRating) {
		try {
            MonsterStatistics stats = service.generateMonsterStats(challengeRating);
	        return Response.ok(stats).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
