package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.model.Npc;
import org.devoware.encounterplanner.service.EncounterPlannerService;

@Path("npc-generator")
public class NpcGeneratorResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("idealType") int idealType ) {
		try {
            Npc npc = service.generateNpc(idealType);
	        return Response.ok(npc).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
