package com.api.v2.payment;

import com.api.v2.creditcard.CreditCard;
import com.api.v2.rent.Rent;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.ZonedDateTime

@Document(collection = "v1_payments")
data class Payment(
    val creditCard: CreditCard,
    val paidAt: String,
    val rent: Rent
) {

    constructor(
        creditCard: CreditCard,
        rent: Rent
    ): this (
        creditCard,
        ZonedDateTime.now().toString(),
        rent
    )

}
