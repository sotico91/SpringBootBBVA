package com.co.bbva.api.clients.model.mapper;

import com.co.bbva.api.clients.model.dto.ClientDTO;
import com.co.bbva.api.clients.model.entity.ClientEntity;

/**
 * Interface for mapping between ClientEntity and ClientDTO.
 *
 * <p>
 * This abstraction allows for easy mocking in tests and clean separation of mapping logic.
 * The implementation is provided by {@link MapperClientImpl} and registered as a Spring Bean.
 * </p>
 *
 * <p>
 * <b>Design Note:</b> Refactored from a concrete class to an interface to enable Mockito mocking
 * and improve testability in the project (Java 23+ compatibility).
 * </p>
 */
public interface MapperClient {
    /**
     * Maps a ClientEntity to a ClientDTO, with optional address.
     * @param clientEntity the entity to map
     * @param withAddress if true, includes the address in the DTO
     * @return mapped ClientDTO
     */
    ClientDTO toClientDTO(final ClientEntity clientEntity, final Boolean withAddress);

    /**
     * Maps a ClientEntity to a ClientDTO, always including address.
     * @param clientEntity the entity to map
     * @return mapped ClientDTO
     */
    ClientDTO entityToClientDTO(final ClientEntity clientEntity);

    /**
     * Updates a ClientEntity from a ClientDTO, preserving unchanged fields.
     * @param clientDTO the DTO with new data
     * @param clientEntity the existing entity
     * @return updated ClientEntity
     */
    ClientEntity toClientEntity(final ClientDTO clientDTO, final ClientEntity clientEntity);
}
