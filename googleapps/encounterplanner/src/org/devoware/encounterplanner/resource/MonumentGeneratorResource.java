package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.model.Monument;
import org.devoware.encounterplanner.service.EncounterPlannerService;

@Path("monument-generator")
public class MonumentGeneratorResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
		try {
            Monument monument = service.generateMonument();
	        return Response.ok(monument).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
