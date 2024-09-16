package com.api.v2.rent.rent

import com.api.v2.car.domain.Car
import com.api.v2.customer.domain.Customer
import com.api.v2.payment.domain.Payment
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigInteger
import java.util.*

@Document(collection = "v2_rents")
data class Rent(
    @Id val id: UUID,
    val orderNumber: BigInteger,
    val customer: Customer,
    val car: Car,
    val payment: Payment,
    val rentedAt: String
)