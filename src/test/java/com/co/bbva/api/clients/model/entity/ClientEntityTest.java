package com.co.bbva.api.clients.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


class ClientEntityTest {

    @Test
    void clientEntity_withValidData_createsObjectSuccessfully() {
        ClientEntity client = ClientEntity.builder()
                .id(1L)
                .documentType("ID")
                .documentNumber("123456789")
                .firstName("John")
                .lastName("Doe")
                .phone("+1234567890")
                .address("123 Main St")
                .city("New York")
                .email("john.doe@example.com")
                .build();
        assertNotNull(client);
        assertEquals(1L, client.getId());
        assertEquals("ID", client.getDocumentType());
        assertEquals("123456789", client.getDocumentNumber());
        assertEquals("John", client.getFirstName());
        assertEquals("Doe", client.getLastName());
        assertEquals("+1234567890", client.getPhone());
        assertEquals("123 Main St", client.getAddress());
        assertEquals("New York", client.getCity());
        assertEquals("john.doe@example.com", client.getEmail());
    }

    @Test
    void clientEntity_withNullValues_createsObjectSuccessfully() {
        ClientEntity client = ClientEntity.builder()
                .id(null)
                .documentType(null)
                .documentNumber(null)
                .firstName(null)
                .lastName(null)
                .phone(null)
                .address(null)
                .city(null)
                .email(null)
                .build();
        assertNotNull(client);
        assertNull(client.getId());
        assertNull(client.getDocumentType());
        assertNull(client.getDocumentNumber());
        assertNull(client.getFirstName());
        assertNull(client.getLastName());
        assertNull(client.getPhone());
        assertNull(client.getAddress());
        assertNull(client.getCity());
        assertNull(client.getEmail());
    }

    @Test
    void clientEntity_withEmptyStrings_createsObjectSuccessfully() {
        ClientEntity client = ClientEntity.builder()
                .id(1L)
                .documentType("")
                .documentNumber("")
                .firstName("")
                .lastName("")
                .phone("")
                .address("")
                .city("")
                .email("")
                .build();
        assertNotNull(client);
        assertEquals(1L, client.getId());
        assertEquals("", client.getDocumentType());
        assertEquals("", client.getDocumentNumber());
        assertEquals("", client.getFirstName());
        assertEquals("", client.getLastName());
        assertEquals("", client.getPhone());
        assertEquals("", client.getAddress());
        assertEquals("", client.getCity());
        assertEquals("", client.getEmail());
    }

}