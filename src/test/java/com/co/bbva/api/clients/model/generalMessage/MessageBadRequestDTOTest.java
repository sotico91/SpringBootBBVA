package com.co.bbva.api.clients.model.generalMessage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MessageBadRequestDTOTest {

    @Test
    void messageBadRequestDTO_withValidData_returnsCorrectValues() {
        MessageBadRequestDTO dto = new MessageBadRequestDTO();
        dto.setCode(400);
        dto.setMessage("Bad Request Op");

        assertEquals(400, dto.getCode());
        assertEquals("Bad Request Op", dto.getMessage());
    }

    @Test
    void messageBadRequestDTO_withDefaultConstructor_returnsDefaultValues() {
        MessageBadRequestDTO dto = new MessageBadRequestDTO();

        assertEquals(0, dto.getCode());
        assertNull(dto.getMessage());
    }

    @Test
    void messageBadRequestDTO_withNullMessage_returnsNullMessage() {
        MessageBadRequestDTO dto = new MessageBadRequestDTO();
        dto.setMessage(null);

        assertNull(dto.getMessage());
    }
}