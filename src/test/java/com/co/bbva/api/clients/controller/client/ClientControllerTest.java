package com.co.bbva.api.clients.controller.client;

import com.co.bbva.api.clients.exceptions.impl.ResourceNotFoundException;
import com.co.bbva.api.clients.model.dto.ClientDTO;
import com.co.bbva.api.clients.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class ClientControllerTest {

    @Mock
    private ClientServiceImpl clientService;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void searchClient_withValidParams_returnsClientDTO() {
        String documentType = "C";
        String documentNumber = "123456789";
        Boolean withAddress = true;

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFirstName("John");
        clientDTO.setLastName("Doe");
        clientDTO.setEmail("jdoe@mailservicemail.com");
        clientDTO.setPhone("+12345678");

        when(clientService.searchClient(documentType, documentNumber, withAddress)).thenReturn(clientDTO);

        ResponseEntity<ClientDTO> response = clientController.searchClient(documentType, documentNumber, withAddress);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(clientDTO, response.getBody());
    }

    @Test
    void searchClient_withNoAdditionalParams_returnsClientDTO() {
        String documentType = "C";
        String documentNumber = "123456789";
        Boolean withAddress = true;

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFirstName("John");
        clientDTO.setLastName("Doe");
        clientDTO.setEmail("jdoe@mailservicemail.com");
        clientDTO.setPhone("+12345678");

        when(clientService.searchClient(documentType, documentNumber, withAddress)).thenReturn(clientDTO);

        ResponseEntity<ClientDTO> response = clientController.searchClient(documentType, documentNumber, withAddress);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(clientDTO, response.getBody());
    }

    @Test
    void searchClient_withInvalidDocumentType_returnsNotFound() {
        String documentType = "X";
        String documentNumber = "123456789";
        Boolean withAddress = true;

        when(clientService.searchClient(documentType, documentNumber, withAddress)).thenThrow(new ResourceNotFoundException("Client not found"));

        assertThrows(ResourceNotFoundException.class, () -> {
            clientController.searchClient(documentType, documentNumber, withAddress);
        });
    }

    @Test
    void searchClient_withNullWithAddress_returnsClientDTO() {
        String documentType = "C";
        String documentNumber = "123456789";
        Boolean withAddress = null;

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFirstName("John");
        clientDTO.setLastName("Doe");

        when(clientService.searchClient(documentType, documentNumber, withAddress)).thenReturn(clientDTO);

        ResponseEntity<ClientDTO> response = clientController.searchClient(documentType, documentNumber, withAddress);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(clientDTO, response.getBody());
    }

    @Test
    void updateClient_withValidParams_returnsUpdatedClientDTO() {
        String documentType = "C";
        String documentNumber = "123456789";
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFirstName("Jane");
        clientDTO.setLastName("Doe");
        clientDTO.setEmail("janedoe@mail.com");
        clientDTO.setPhone("+987654321");

        when(clientService.updateClient(documentType, documentNumber, clientDTO)).thenReturn(clientDTO);

        ResponseEntity<ClientDTO> response = clientController.updateClient(documentType, documentNumber, clientDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(clientDTO, response.getBody());
    }

    @Test
    void updateClient_withInvalidDocumentType_returnsNotFound() {
        String documentType = "X";
        String documentNumber = "123456789";
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFirstName("Jane");
        clientDTO.setLastName("Doe");

        when(clientService.updateClient(documentType, documentNumber, clientDTO)).thenThrow(new ResourceNotFoundException("Client not found"));

        assertThrows(ResourceNotFoundException.class, () -> {
            clientController.updateClient(documentType, documentNumber, clientDTO);
        });
    }
}