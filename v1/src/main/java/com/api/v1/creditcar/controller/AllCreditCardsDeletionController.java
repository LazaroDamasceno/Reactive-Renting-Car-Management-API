package com.api.v1.creditcar.controller;

import com.api.v1.creditcar.services.AllCreditCardsDeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/credit-cars")
public class AllCreditCardsDeletionController {

    @Autowired
    private AllCreditCardsDeletionService service;

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAll() {
        return service.deleteAll();
    }

    @DeleteMapping("{cardNumber}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteByCardNumber(@PathVariable String cardNumber) {
        return service.deleteByCardNumber(cardNumber);
    }
}
