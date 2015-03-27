package org.devoware.encounterplanner.parser;

public class ParseException extends Exception { 
	private static final long serialVersionUID = 1L;

    public ParseException(String message) {
	    super(message);
    }

    public ParseException(String messageTemplate, Object ... args) {
	    super(String.format(messageTemplate, args));
    }

}
