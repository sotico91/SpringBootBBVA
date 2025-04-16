package com.co.bbva.api.clients.model.mapper;

import com.co.bbva.api.clients.model.dto.ClientDTO;
import com.co.bbva.api.clients.model.entity.ClientEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit tests for MapperClient.
 */
class MapperClientTest {

    private final MapperClient mapperClient = new MapperClientImpl();

    @Test
    void toClientDTO_withAddress_returnsClientDTOWithAddress() {
        ClientEntity clientEntity = ClientEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .phone("+1234567890")
                .address("123 Main St")
                .city("New York")
                .email("john.doe@example.com")
                .build();

        ClientDTO clientDTO = mapperClient.toClientDTO(clientEntity, true);

        assertNotNull(clientDTO);
        assertEquals("John", clientDTO.getFirstName());
        assertEquals("Doe", clientDTO.getLastName());
        assertEquals("+1234567890", clientDTO.getPhone());
        assertEquals("123 Main St", clientDTO.getAddress());
        assertEquals("New York", clientDTO.getCity());
        assertEquals("john.doe@example.com", clientDTO.getEmail());
    }

    @Test
    void toClientDTO_withoutAddress_returnsClientDTOWithoutAddress() {
        ClientEntity clientEntity = ClientEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .phone("+1234567890")
                .address("123 Main St")
                .city("New York")
                .email("john.doe@example.com")
                .build();

        ClientDTO clientDTO = mapperClient.toClientDTO(clientEntity, false);

        assertNotNull(clientDTO);
        assertEquals("John", clientDTO.getFirstName());
        assertEquals("Doe", clientDTO.getLastName());
        assertEquals("+1234567890", clientDTO.getPhone());
        assertEquals("", clientDTO.getAddress());
        assertEquals("New York", clientDTO.getCity());
        assertEquals("john.doe@example.com", clientDTO.getEmail());
    }

    @Test
    void entityToClientDTO_withValidEntity_returnsClientDTO() {
        ClientEntity clientEntity = ClientEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .phone("+1234567890")
                .address("123 Main St")
                .city("New York")
                .email("john.doe@example.com")
                .build();

        ClientDTO clientDTO = mapperClient.entityToClientDTO(clientEntity);

        assertNotNull(clientDTO);
        assertEquals("John", clientDTO.getFirstName());
        assertEquals("Doe", clientDTO.getLastName());
        assertEquals("+1234567890", clientDTO.getPhone());
        assertEquals("123 Main St", clientDTO.getAddress());
        assertEquals("New York", clientDTO.getCity());
        assertEquals("john.doe@example.com", clientDTO.getEmail());
    }

    @Test
    void toClientEntity_withValidDTOAndEntity_returnsUpdatedClientEntity() {
        ClientDTO clientDTO = ClientDTO.builder()
                .firstName("Jane")
                .lastName("Smith")
                .phone("+0987654321")
                .address("456 Elm St")
                .city("Los Angeles")
                .email("jane.smith@example.com")
                .build();

        ClientEntity clientEntity = ClientEntity.builder()
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

        ClientEntity updatedClientEntity = mapperClient.toClientEntity(clientDTO, clientEntity);

        assertNotNull(updatedClientEntity);
        assertEquals(1L, updatedClientEntity.getId());
        assertEquals("ID", updatedClientEntity.getDocumentType());
        assertEquals("123456789", updatedClientEntity.getDocumentNumber());
        assertEquals("Jane", updatedClientEntity.getFirstName());
        assertEquals("Smith", updatedClientEntity.getLastName());
        assertEquals("+0987654321", updatedClientEntity.getPhone());
        assertEquals("456 Elm St", updatedClientEntity.getAddress());
        assertEquals("Los Angeles", updatedClientEntity.getCity());
        assertEquals("jane.smith@example.com", updatedClientEntity.getEmail());
    }
}