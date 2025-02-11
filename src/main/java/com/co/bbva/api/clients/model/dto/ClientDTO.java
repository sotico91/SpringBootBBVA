package com.co.bbva.api.clients.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientDTO {

    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String email;

}
