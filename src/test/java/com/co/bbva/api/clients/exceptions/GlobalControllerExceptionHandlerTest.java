package com.co.bbva.api.clients.exceptions;

import com.co.bbva.api.clients.exceptions.impl.ResourceBadRequestException;
import com.co.bbva.api.clients.exceptions.impl.ResourceNotFoundException;
import com.co.bbva.api.clients.model.generalMessage.MessageDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Clase de pruebas para el manejador de excepciones globales.
 */
class GlobalControllerExceptionHandlerTest {

    private final GlobalControllerExceptionHandler handler = new GlobalControllerExceptionHandler();

    @Test
    void handleException_withGenericException_returnsInternalServerError() {
        Exception ex = new Exception("Internal server error");
        ResponseEntity<MessageDTO> response = handler.handleException(ex);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody(), "Response body should not be null");
        MessageDTO body = response.getBody();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), body.getCode());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), body.getMessage());
    }

    @Test
    void handleResourceNotFoundException_withResourceNotFoundException_returnsNotFound() {
        ResourceNotFoundException ex = new ResourceNotFoundException("Resource not found");
        ResponseEntity<MessageDTO> response = handler.handleResourceNotFoundException(ex);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody(), "Response body should not be null");
        MessageDTO body = response.getBody();
        assertEquals(HttpStatus.NOT_FOUND.value(), body.getCode());
        assertEquals("Resource not found", body.getMessage());
    }

    @Test
    void handleConversion_withResourceBadRequestException_returnsBadRequest() {
        ResourceBadRequestException ex = new ResourceBadRequestException("Bad request");
        ResponseEntity<MessageDTO> response = handler.handleConversion(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody(), "Response body should not be null");
        MessageDTO body = response.getBody();
        assertEquals(HttpStatus.BAD_REQUEST.value(), body.getCode());
        assertEquals("Bad request", body.getMessage());
    }

    // Nuevo test: verificar que el log no lanza excepción y el método soporta null
    @Test
    void handleException_withNullMessage_returnsInternalServerError() {
        Exception ex = new Exception((String) null);
        ResponseEntity<MessageDTO> response = handler.handleException(ex);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody(), "Response body should not be null");
        MessageDTO body = response.getBody();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), body.getCode());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), body.getMessage());
    }
}