package com.co.bbva.api.clients.constants;


import lombok.Getter;

@Getter
public enum ClientConstants {

    CLIENT_NOT_FOUND("Client not found"),
    CLIENT_ALREADY_EXISTS("Client already exists"),
    CLIENT_CREATED("Client created successfully"),
    CLIENT_UPDATED("Client updated successfully"),
    CLIENT_DELETED("Client deleted successfully"),
    CLIENT_BAD_REQUEST("Bad request"),
    CLIENT_INTERNAL_SERVER_ERROR("Internal server error");

    private final String message;

    ClientConstants(String message) {
        this.message = message;
    }

}
