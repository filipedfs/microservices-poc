package com.filipefonseca.product.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyTest {
    @Test
    public void testMoneyValues() {
        BigDecimal value1 = new BigDecimal("0.01");
        BigDecimal value2 = new BigDecimal("0.01");
        Assertions.assertEquals(new BigDecimal("0.02"), value1.add(value2));
        Assertions.assertEquals(new BigDecimal("0.02"), (new BigDecimal("0.1")).multiply(new BigDecimal("0.2")));

        value1 = new BigDecimal("0.001");
        value2 = new BigDecimal("0.001");
        Assertions.assertEquals(new BigDecimal("0.00"), value1.add(value2).setScale(2, RoundingMode.HALF_EVEN));
    }
}
