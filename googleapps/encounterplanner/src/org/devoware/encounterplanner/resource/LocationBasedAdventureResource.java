package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.model.LocationBasedAdventure;
import org.devoware.encounterplanner.service.EncounterPlannerService;

@Path("location-based-adventure-generator")
public class LocationBasedAdventureResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("adventureType") String adventureType ) {
		try {
            LocationBasedAdventure adventure = service.generateLocationBasedAdventure(adventureType);
	        return Response.ok(adventure).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
