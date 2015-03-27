package org.devoware.encounterplanner.resource;

import static org.devoware.encounterplanner.resource.ErrorResponse.newErrorResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.devoware.encounterplanner.model.Weather;
import org.devoware.encounterplanner.service.EncounterPlannerService;

@Path("weather-generator")
public class WeatherGeneratorResource {
    private final EncounterPlannerService service = new EncounterPlannerService();
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
		try {
            Weather weather = service.generateWeather();
	        return Response.ok(weather).build();
		} catch (Throwable t) {
			return newErrorResponse(t);
		}
    }
    
}
