package com.co.bbva.api.clients.model.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ClientDTOTest {

    @Test
    void clientDTO_withValidData_createsObjectSuccessfully() {
        ClientDTO client = ClientDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .phone("+1234567890")
                .address("123 Main St")
                .city("New York")
                .email("john.doe@example.com")
                .build();
        assertNotNull(client);
        assertEquals("John", client.getFirstName());
        assertEquals("Doe", client.getLastName());
        assertEquals("+1234567890", client.getPhone());
        assertEquals("123 Main St", client.getAddress());
        assertEquals("New York", client.getCity());
        assertEquals("john.doe@example.com", client.getEmail());
    }

    @Test
    void clientDTO_withNullValues_createsObjectSuccessfully() {
        ClientDTO client = ClientDTO.builder()
                .firstName(null)
                .lastName(null)
                .phone(null)
                .address(null)
                .city(null)
                .email(null)
                .build();
        assertNotNull(client);
        assertNull(client.getFirstName());
        assertNull(client.getLastName());
        assertNull(client.getPhone());
        assertNull(client.getAddress());
        assertNull(client.getCity());
        assertNull(client.getEmail());
    }

}