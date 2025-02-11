package com.co.bbva.api.clients.model.generalMessage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MessageInternalErrorDTOTest {

    @Test
    void messageInternalErrorDTO_withValidData_returnsCorrectValues() {
        MessageInternalErrorDTO dto = new MessageInternalErrorDTO();
        dto.setCode(500);
        dto.setMessage("Internal Server Error");

        assertEquals(500, dto.getCode());
        assertEquals("Internal Server Error", dto.getMessage());
    }

    @Test
    void messageInternalErrorDTO_withDefaultConstructor_returnsDefaultValues() {
        MessageInternalErrorDTO dto = new MessageInternalErrorDTO();

        assertEquals(0, dto.getCode());
        assertNull(dto.getMessage());
    }

    @Test
    void messageInternalErrorDTO_withNullMessage_returnsNullMessage() {
        MessageInternalErrorDTO dto = new MessageInternalErrorDTO();
        dto.setMessage(null);

        assertNull(dto.getMessage());
    }

}