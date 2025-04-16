package com.co.bbva.api.clients.exceptions;

import com.co.bbva.api.clients.exceptions.impl.ResourceBadRequestException;
import com.co.bbva.api.clients.exceptions.impl.ResourceNotFoundException;
import com.co.bbva.api.clients.model.generalMessage.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<MessageDTO> handleException(Exception ex) {
        logger.error("Unhandled exception: {}", ex.getMessage(), ex);
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        messageDTO.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageDTO);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<MessageDTO> handleResourceNotFoundException(ResourceNotFoundException ex) {
        logger.warn("Resource not found: {}", ex.getMessage());
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCode(HttpStatus.NOT_FOUND.value());
        messageDTO.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDTO);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<MessageDTO> handleConversion(ResourceBadRequestException ex) {
        logger.info("Bad request: {}", ex.getMessage());
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setCode(HttpStatus.BAD_REQUEST.value());
        messageDTO.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageDTO);
    }
}
