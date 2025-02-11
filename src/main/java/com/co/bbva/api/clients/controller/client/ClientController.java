package com.co.bbva.api.clients.controller.client;

import com.co.bbva.api.clients.model.dto.ClientDTO;
import com.co.bbva.api.clients.model.generalMessage.MessageBadRequestDTO;
import com.co.bbva.api.clients.model.generalMessage.MessageClientNotFoundDTO;
import com.co.bbva.api.clients.model.generalMessage.MessageInternalErrorDTO;
import com.co.bbva.api.clients.service.impl.ClientServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ClientController {

    private final ClientServiceImpl clientService;

    @Operation(summary = "Search client")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "client found",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ClientDTO.class))}),
    @ApiResponse(responseCode = "400", description = "Bad request",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MessageBadRequestDTO.class))}),
    @ApiResponse(responseCode = "404", description = "Client not found",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MessageClientNotFoundDTO.class))}),
    @ApiResponse(responseCode = "500", description = "Internal server error",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MessageInternalErrorDTO.class))})
    })
    @GetMapping("/clients/{documentType}/{documentNumber}")
    public ResponseEntity<ClientDTO> searchClient(
            @PathVariable final String documentType,
            @PathVariable final String documentNumber,
            @RequestParam(required = false) Boolean withAddress) {
        ClientDTO  clientDTO = clientService.searchClient(documentType, documentNumber, withAddress);
        return ResponseEntity.ok().body(clientDTO);
    }


    @Operation(summary = "Update client Information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "client updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessageBadRequestDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Client not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessageClientNotFoundDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessageInternalErrorDTO.class))})
    })
    @PutMapping ("/clients/{documentType}/{documentNumber}")
    public ResponseEntity<ClientDTO> updateClient(
            @PathVariable final String documentType,
            @PathVariable final String documentNumber,
            @RequestBody ClientDTO clientDTO) {
        ClientDTO client = clientService.updateClient(documentType, documentNumber, clientDTO);
        return ResponseEntity.ok().body(client);
    }
}
