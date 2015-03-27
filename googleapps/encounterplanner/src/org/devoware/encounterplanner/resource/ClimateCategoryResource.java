package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.service.EncounterPlannerService;
import org.devoware.table.weather.ClimateCategory;

@Path("climate-category-generator")
public class ClimateCategoryResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("terrain") @DefaultValue("0") int terrainIdx, 
    		@QueryParam("terrainLocation") @DefaultValue("0") int terrainLocationIdx,
    		@QueryParam("latitude") @DefaultValue("0") double latitudeDouble) {
		try {
			int latitude = (int) Math.abs(Math.floor(latitudeDouble));
            ClimateCategory climateCategory = service.generateClimateCategory(terrainIdx, terrainLocationIdx, latitude);
	        return Response.ok(climateCategory).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
