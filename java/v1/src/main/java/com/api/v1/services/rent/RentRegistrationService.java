package com.api.v1.services.rent;

import com.api.v1.dtos.rent.RentResponseDto;
import reactor.core.publisher.Mono;

public interface RentRegistrationService {

    Mono<RentResponseDto> register(String ssn, String vin, String paymentOrderNumber, int days);

}
