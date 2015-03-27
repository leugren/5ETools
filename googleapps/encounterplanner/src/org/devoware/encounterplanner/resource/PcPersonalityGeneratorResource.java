package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.model.PcPersonality;
import org.devoware.encounterplanner.service.EncounterPlannerService;

import com.google.appengine.labs.repackaged.com.google.common.collect.ImmutableList;

@Path("pc-personality-generator")
public class PcPersonalityGeneratorResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("background") @DefaultValue("0") int background, 
    		@QueryParam("excludedIdealType") List<String> excludedIdealTypes) {
		try {
			if (excludedIdealTypes == null) {
				excludedIdealTypes = ImmutableList.of();
			}
            PcPersonality personality = service.generatePcPersonality(background, excludedIdealTypes);
	        return Response.ok(personality).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
