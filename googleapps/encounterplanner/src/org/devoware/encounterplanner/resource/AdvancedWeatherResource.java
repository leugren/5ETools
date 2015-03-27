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
import org.devoware.table.weather.AdvancedWeather;

@Path("advanced-weather-generator")
public class AdvancedWeatherResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("climateCategory") @DefaultValue("0") int climateCategoryIdx, 
    		@QueryParam("hemisphere") @DefaultValue("0") int hemisphereIdx,
    		@QueryParam("month") @DefaultValue("0") int monthIdx) {
		try {
            AdvancedWeather weather = service.generateAdvanceWeather(climateCategoryIdx, hemisphereIdx, monthIdx);
	        return Response.ok(weather).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
