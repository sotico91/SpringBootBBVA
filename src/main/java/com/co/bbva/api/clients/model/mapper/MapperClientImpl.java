package com.co.bbva.api.clients.model.mapper;

import com.co.bbva.api.clients.model.dto.ClientDTO;
import com.co.bbva.api.clients.model.entity.ClientEntity;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link MapperClient} for mapping between ClientEntity and ClientDTO.
 *
 * <p>
 * Registered as a Spring Bean. Contains the actual mapping logic for the application.
 * </p>
 */
@Component
public class MapperClientImpl implements MapperClient {
    /**
     * {@inheritDoc}
     */
    @Override
    public ClientDTO toClientDTO(final ClientEntity clientEntity, final Boolean withAddress) {
        return ClientDTO.builder()
                .firstName(clientEntity.getFirstName())
                .lastName(clientEntity.getLastName())
                .phone(clientEntity.getPhone())
                .address(withAddress != null && withAddress.equals(Boolean.TRUE) ? clientEntity.getAddress() : "")
                .city(clientEntity.getCity())
                .email(clientEntity.getEmail())
                .build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClientDTO entityToClientDTO(final ClientEntity clientEntity) {
        return ClientDTO.builder()
                .firstName(clientEntity.getFirstName())
                .lastName(clientEntity.getLastName())
                .phone(clientEntity.getPhone())
                .address(clientEntity.getAddress())
                .city(clientEntity.getCity())
                .email(clientEntity.getEmail())
                .build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClientEntity toClientEntity(final ClientDTO clientDTO, final ClientEntity clientEntity) {
        return ClientEntity.builder()
                .firstName(clientDTO.getFirstName() != null ? clientDTO.getFirstName() : clientEntity.getFirstName())
                .lastName(clientDTO.getLastName() != null ? clientDTO.getLastName() : clientEntity.getLastName())
                .phone(clientDTO.getPhone() != null ? clientDTO.getPhone() : clientEntity.getPhone())
                .address(clientDTO.getAddress() != null ? clientDTO.getAddress() : clientEntity.getAddress())
                .city(clientDTO.getCity() != null ? clientDTO.getCity() : clientEntity.getCity())
                .email(clientDTO.getEmail() != null ? clientDTO.getEmail() : clientEntity.getEmail())
                .documentType(clientEntity.getDocumentType())
                .documentNumber(clientEntity.getDocumentNumber())
                .id(clientEntity.getId())
                .build();
    }
}
