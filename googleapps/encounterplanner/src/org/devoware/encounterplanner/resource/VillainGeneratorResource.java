package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.model.VillainNpc;
import org.devoware.encounterplanner.service.EncounterPlannerService;

@Path("villain-generator")
public class VillainGeneratorResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("includeWeakness") @DefaultValue("false") boolean includeWeakness,
    		@QueryParam("idealType") int idealType ) {
		try {
            VillainNpc villainNpc = service.generateVillain(includeWeakness, idealType);
	        return Response.ok(villainNpc).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
