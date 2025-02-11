package com.co.bbva.api.clients.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "clients")
public class ClientEntity {

    @Id
    private Long id;
    private String documentType;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String email;

}
