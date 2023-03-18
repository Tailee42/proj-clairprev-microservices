package com.urbanisation_si.microservices_contrat_mongodb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContratInexistantException extends RuntimeException {
    public ContratInexistantException(String message) {
        super(message);
    }
}
