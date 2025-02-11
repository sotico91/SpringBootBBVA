package com.co.bbva.api.clients.service.impl;

import com.co.bbva.api.clients.constants.ClientConstants;
import com.co.bbva.api.clients.exceptions.impl.ResourceNotFoundException;
import com.co.bbva.api.clients.model.dto.ClientDTO;
import com.co.bbva.api.clients.model.entity.ClientEntity;
import com.co.bbva.api.clients.model.mapper.MapperClient;
import com.co.bbva.api.clients.repository.client.IClientRepository;
import com.co.bbva.api.clients.service.IClientService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private static final Logger logger = LogManager.getLogger(ClientServiceImpl.class);

    private final IClientRepository clientRepository;
    private final MapperClient mapperClient;

    @Override
    public ClientDTO searchClient(final String documentType, final String documentNumber, final Boolean withAddress) {

        logger.info("Start searchClient method {},{}",documentType, documentNumber);

        ClientEntity clientEntity = clientRepository.findByDocumentTypeAndDocumentNumber(documentType, documentNumber);
        if (clientEntity == null) {
            throw new ResourceNotFoundException(ClientConstants.CLIENT_NOT_FOUND.getMessage());
        }
        logger.info("End searchClient method");

        return mapperClient.toClientDTO(clientEntity,withAddress);
    }

    @Override
    public ClientDTO updateClient(final String documentType, final String documentNumber, final ClientDTO clientDTO) {

        logger.info("Start updateClient method {},{}",documentType, documentNumber);

        ClientEntity clientEntity = clientRepository.findByDocumentTypeAndDocumentNumber(documentType, documentNumber);
        if (clientEntity == null) {
            throw new ResourceNotFoundException(ClientConstants.CLIENT_NOT_FOUND.getMessage());
        }
        
        ClientEntity clientEntityOut = clientRepository.save(mapperClient.toClientEntity(clientDTO, clientEntity));

        logger.info("End updateClient method");
        return mapperClient.entityToClientDTO(clientEntityOut);
    }
}
