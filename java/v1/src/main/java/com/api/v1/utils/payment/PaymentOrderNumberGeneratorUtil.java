package com.api.v1.utils.payment;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class PaymentOrderNumberGeneratorUtil {

    public static BigInteger generate() {
        int year = ZonedDateTime.now().getYear();
        String format = "%04d0000".formatted(year);
        BigInteger number = new BigInteger(format);
        number = number.add(BigInteger.ONE);
        return number;
    }

}
