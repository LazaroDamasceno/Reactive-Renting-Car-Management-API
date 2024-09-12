package com.api.v2.car

import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CarRegistrationServiceImpl: CarRegistrationService {

    @Autowired
    private lateinit var carRepository: CarRepository

    override suspend fun register(requestDto: @Valid CarRegistrationRequestDto) {
        return withContext(Dispatchers.IO) {
            if (checkTheExistenceOfDuplicatedVin(requestDto.vin)) {
                throw DuplicatedVinException(requestDto.vin)
            }
            val newCar = CarBuilder.create().fromDto(requestDto).build()
            val savedCar = carRepository.save(newCar)
            CarResponseMapper.mapToDto(savedCar)
        }
    }

    private suspend fun checkTheExistenceOfDuplicatedVin(vin: String): Boolean {
        return carRepository.findAll().filter { e -> e.vin == vin }.firstOrNull() != null
    }

}