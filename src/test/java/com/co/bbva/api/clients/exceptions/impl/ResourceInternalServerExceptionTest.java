package com.co.bbva.api.clients.exceptions.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ResourceInternalServerExceptionTest {

    @Test
    void resourceInternalServerException_withValidMessage_returnsCorrectMessage() {
        ResourceInternalServerException exception = new ResourceInternalServerException("Internal Server Error");

        assertEquals("Internal Server Error", exception.getMessage());
    }

    @Test
    void resourceInternalServerException_withNullMessage_returnsNullMessage() {
        ResourceInternalServerException exception = new ResourceInternalServerException(null);

        assertNull(exception.getMessage());
    }

    @Test
    void resourceInternalServerException_withEmptyMessage_returnsEmptyMessage() {
        ResourceInternalServerException exception = new ResourceInternalServerException("");

        assertEquals("", exception.getMessage());
    }

}