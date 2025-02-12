package com.co.bbva.api.clients.service.impl;

import com.co.bbva.api.clients.constants.ClientConstants;
import com.co.bbva.api.clients.exceptions.impl.ResourceInternalServerException;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private static final Logger logger = LogManager.getLogger(ClientServiceImpl.class);

    private final IClientRepository clientRepository;
    private final MapperClient mapperClient;

    private static final String EMAIL_PATTERN ="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

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

        if (clientDTO.getEmail() != null && !isValidEmail(clientDTO.getEmail())) {
            throw new ResourceInternalServerException(ClientConstants.CLIENT_INTERNAL_SERVER_ERROR.getMessage());
        }

        ClientEntity clientEntityOut = clientRepository.save(mapperClient.toClientEntity(clientDTO, clientEntity));

        logger.info("End updateClient method");
        return mapperClient.entityToClientDTO(clientEntityOut);
    }

    public static boolean isValidEmail(String email) {

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
