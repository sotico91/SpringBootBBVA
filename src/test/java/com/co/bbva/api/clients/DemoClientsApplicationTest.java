package com.co.bbva.api.clients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DemoClientsApplicationTest {

    @Test
    void main_withValidArgs_runsApplication() {
        String[] args = {};
        assertDoesNotThrow(() -> DemoClientsApplication.main(args));
    }
}