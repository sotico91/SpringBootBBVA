package com.co.bbva.api.clients.model.generalMessage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MessageClientNotFoundDTOTest {

    @Test
    void messageClientNotFoundDTO_withValidData_returnsCorrectValues() {
        MessageClientNotFoundDTO dto = new MessageClientNotFoundDTO();
        dto.setCode(404);
        dto.setMessage("Client not found");

        assertEquals(404, dto.getCode());
        assertEquals("Client not found", dto.getMessage());
    }

    @Test
    void messageClientNotFoundDTO_withDefaultConstructor_returnsDefaultValues() {
        MessageClientNotFoundDTO dto = new MessageClientNotFoundDTO();

        assertEquals(0, dto.getCode());
        assertNull(dto.getMessage());
    }

    @Test
    void messageClientNotFoundDTO_withNullMessage_returnsNullMessage() {
        MessageClientNotFoundDTO dto = new MessageClientNotFoundDTO();
        dto.setMessage(null);

        assertNull(dto.getMessage());
    }
}