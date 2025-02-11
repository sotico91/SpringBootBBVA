package com.co.bbva.api.clients.repository.client;

import com.co.bbva.api.clients.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository  extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);
}
