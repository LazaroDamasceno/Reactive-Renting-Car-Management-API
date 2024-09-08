package com.api.v1.customer.services;

import com.api.v1.customer.mappers.CustomerResponseMapper;
import com.api.v1.customer.builders.CustomerBuilder;
import com.api.v1.customer.domain.Customer;
import com.api.v1.customer.domain.CustomerRepository;
import com.api.v1.customer.dtos.CustomerRegistrationRequestDto;
import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.customer.exceptions.DuplicatedSsnException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

    private final CustomerRepository customerRepository;

    @Override
    public Mono<CustomerResponseDto> register(CustomerRegistrationRequestDto request) {
        return customerRepository
                .findAll()
                .hasElements()
                .flatMap(exists -> {
                    if (exists) return Mono.error(new DuplicatedSsnException(request.ssn()));
                    return Mono.defer(() -> {
                        Customer customer = CustomerBuilder.create().fromDto(request).build();
                        return customerRepository.save(customer);
                    }).flatMap(savedCustomer -> Mono.just(CustomerResponseMapper.map(savedCustomer)));
                });
    }

}
