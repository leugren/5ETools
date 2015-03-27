package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.model.Building;
import org.devoware.encounterplanner.service.EncounterPlannerService;

@Path("tavern-generator")
public class TavernGeneratorResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
		try {
            Building building = service.generateTavern();
	        return Response.ok(building).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
