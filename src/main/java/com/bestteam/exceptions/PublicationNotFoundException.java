package com.bestteam.exceptions;

@SuppressWarnings("serial")
public class PublicationNotFoundException extends RuntimeException {
    public PublicationNotFoundException(String publicationId) {
        super("Publication ID " + publicationId + " not found.");
    }
}
