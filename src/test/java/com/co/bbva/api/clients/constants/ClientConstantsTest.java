package com.co.bbva.api.clients.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientConstantsTest {

    @Test
    void clientNotFoundMessage_returnsCorrectMessage() {
        assertEquals("Client not found", ClientConstants.CLIENT_NOT_FOUND.getMessage());
    }

    @Test
    void clientAlreadyExistsMessage_returnsCorrectMessage() {
        assertEquals("Client already exists", ClientConstants.CLIENT_ALREADY_EXISTS.getMessage());
    }

    @Test
    void clientCreatedMessage_returnsCorrectMessage() {
        assertEquals("Client created successfully", ClientConstants.CLIENT_CREATED.getMessage());
    }

    @Test
    void clientUpdatedMessage_returnsCorrectMessage() {
        assertEquals("Client updated successfully", ClientConstants.CLIENT_UPDATED.getMessage());
    }

    @Test
    void clientDeletedMessage_returnsCorrectMessage() {
        assertEquals("Client deleted successfully", ClientConstants.CLIENT_DELETED.getMessage());
    }

    @Test
    void clientBadRequestMessage_returnsCorrectMessage() {
        assertEquals("Bad request", ClientConstants.CLIENT_BAD_REQUEST.getMessage());
    }
}