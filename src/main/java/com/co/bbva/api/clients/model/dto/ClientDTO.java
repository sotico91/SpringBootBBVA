package com.co.bbva.api.clients.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    @Schema(description = "First name of the client", example = "John")
    private String firstName;

    @Schema(description = "Last name of the client", example = "Doe")
    private String lastName;

    @Size(min = 10, max = 15, message = "Phone number should be between 10 and 15 characters")
    @Schema(description = "Phone number of the client", example = "+1234567890")
    private String phone;

    @Schema(description = "Address of the client", example = "123 Main St")
    private String address;

    @Schema(description = "City of the client", example = "New York")
    private String city;

    @Email(message = "Email should be valid")
    @Schema(description = "Email of the client", example = "john.doe@example.com")
    private String email;

}
