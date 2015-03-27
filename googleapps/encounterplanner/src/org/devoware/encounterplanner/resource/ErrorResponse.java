package org.devoware.encounterplanner.resource;

import javax.ws.rs.core.Response;

public class ErrorResponse {
	private final int status;
	private final String message;

	public static Response newErrorResponse(Throwable t) {
		t.printStackTrace();
		ErrorResponse errorResponse = new ErrorResponse(
				Response.Status.BAD_REQUEST.getStatusCode(),
				t.getMessage() != null && !t.getMessage().trim().isEmpty() ? t.getMessage() : "A problem occurred while attempting to process your request");
		return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
		
	}
	
	public ErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
