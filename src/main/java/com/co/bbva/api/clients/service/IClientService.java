package com.co.bbva.api.clients.service;

import com.co.bbva.api.clients.model.dto.ClientDTO;

public interface IClientService {

    ClientDTO searchClient(String documentType, String documentNumber, Boolean withAddress);

    ClientDTO updateClient(String documentType, String documentNumber, ClientDTO clientDTO);
}
