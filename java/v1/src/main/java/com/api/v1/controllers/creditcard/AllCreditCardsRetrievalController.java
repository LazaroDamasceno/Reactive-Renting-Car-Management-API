package com.api.v1.controllers.creditcard;

import com.api.v1.dtos.creditcard.CreditCardResponseDto;
import com.api.v1.services.creditcard.AllCreditCardsRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/credit-cards")
public class AllCreditCardsRetrievalController {

    @Autowired
    private AllCreditCardsRetrievalService service;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<CreditCardResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("{cardNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CreditCardResponseDto> findByCardNumber(@PathVariable String cardNumber) {
        return service.findByCardNumber(cardNumber);
    }

}
