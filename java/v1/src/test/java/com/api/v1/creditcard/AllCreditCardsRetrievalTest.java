package com.api.v1.creditcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AllCreditCardsRetrievalTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testIfCreditCardIsNotEmpty() {
        webTestClient
                .get()
                .uri("api/v1/credit-cards")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

}
