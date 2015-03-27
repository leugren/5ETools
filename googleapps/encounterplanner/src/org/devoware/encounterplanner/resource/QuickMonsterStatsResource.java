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

@Path("quick-monster-stats")
public class QuickMonsterStatsResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("hitPoints") @DefaultValue("1") int hitPoints, 
    		@QueryParam("armorClass") @DefaultValue("10") int armorClass,
    		@QueryParam("attackValue") @DefaultValue("1") int attackValue,
    		@QueryParam("damagePerRound") @DefaultValue("0") int damagePerRound,
    		@QueryParam("attackType") @DefaultValue("0") int attackType) {
		try {
            MonsterStatistics stats = service.getMonsterStats(hitPoints, armorClass, damagePerRound, attackType, attackValue);
	        return Response.ok(stats).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
