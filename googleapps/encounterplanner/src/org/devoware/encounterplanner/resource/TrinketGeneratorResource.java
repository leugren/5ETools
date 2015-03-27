package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.model.Trinket;
import org.devoware.encounterplanner.service.EncounterPlannerService;

@Path("trinket-generator")
public class TrinketGeneratorResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
		try {
            Trinket trinket = service.generateTrinket();
	        return Response.ok(trinket).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
