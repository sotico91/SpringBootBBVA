package com.co.bbva.api.clients.service.impl;

import com.co.bbva.api.clients.exceptions.impl.ResourceNotFoundException;
import com.co.bbva.api.clients.model.dto.ClientDTO;
import com.co.bbva.api.clients.model.entity.ClientEntity;
import com.co.bbva.api.clients.model.mapper.MapperClient;
import com.co.bbva.api.clients.repository.client.IClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private IClientRepository clientRepository;

    @Mock
    private MapperClient mapperClient;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void searchClient_withValidData_returnsClientDTO() {
        ClientEntity clientEntity = new ClientEntity();
        ClientDTO clientDTO = new ClientDTO();
        when(clientRepository.findByDocumentTypeAndDocumentNumber("ID", "123456789")).thenReturn(clientEntity);
        when(mapperClient.toClientDTO(clientEntity, true)).thenReturn(clientDTO);

        ClientDTO result = clientService.searchClient("ID", "123456789", true);

        assertNotNull(result);
        assertEquals(clientDTO, result);
    }

    @Test
    void searchClient_withNonExistentClient_throwsResourceNotFoundException() {
        when(clientRepository.findByDocumentTypeAndDocumentNumber("ID", "123456789")).thenReturn(null);

        assertThrows(ResourceNotFoundException.class, () -> {
            clientService.searchClient("ID", "123456789", true);
        });
    }

    @Test
    void updateClient_withValidData_returnsUpdatedClientDTO() {
        ClientEntity clientEntity = new ClientEntity();
        ClientEntity updatedClientEntity = new ClientEntity();
        ClientDTO clientDTO = new ClientDTO();
        ClientDTO updatedClientDTO = new ClientDTO();
        when(clientRepository.findByDocumentTypeAndDocumentNumber("ID", "123456789")).thenReturn(clientEntity);
        when(mapperClient.toClientEntity(clientDTO, clientEntity)).thenReturn(updatedClientEntity);
        when(clientRepository.save(updatedClientEntity)).thenReturn(updatedClientEntity);
        when(mapperClient.entityToClientDTO(updatedClientEntity)).thenReturn(updatedClientDTO);

        ClientDTO result = clientService.updateClient("ID", "123456789", clientDTO);

        assertNotNull(result);
        assertEquals(updatedClientDTO, result);
    }

    @Test
    void updateClient_withNonExistentClient_throwsResourceNotFoundException() {
        ClientDTO clientDTO = new ClientDTO();
        when(clientRepository.findByDocumentTypeAndDocumentNumber("ID", "123456789")).thenReturn(null);

        assertThrows(ResourceNotFoundException.class, () -> {
            clientService.updateClient("ID", "123456789", clientDTO);
        });
    }

}