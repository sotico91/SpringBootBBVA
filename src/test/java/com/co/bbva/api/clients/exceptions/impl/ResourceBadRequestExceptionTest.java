package com.co.bbva.api.clients.exceptions.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceBadRequestExceptionTest {

    @Test
    void resourceBadRequestException_withMessage_returnsCorrectMessage() {
        String message = "Bad request error";
        ResourceBadRequestException exception = new ResourceBadRequestException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void resourceBadRequestException_withNullMessage_returnsNullMessage() {
        ResourceBadRequestException exception = new ResourceBadRequestException(null);
        assertNull(exception.getMessage());
    }

}