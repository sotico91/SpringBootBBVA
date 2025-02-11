package com.co.bbva.api.clients.model.generalMessage;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Message client not found")
public class MessageClientNotFoundDTO {

    @Schema(description = "The status code of the message", example = "404")
    private int code;

    @Schema(description = "The detailed message", example = "Client not found")
    private String message;
}
