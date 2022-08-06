package com.ironhack.bootcamp.s5.p2.s2;

import java.math.BigDecimal;

public interface Transactional {
    BigDecimal increaseAmount(BigDecimal addAmount);

    BigDecimal decreaseAmount(BigDecimal addAmount);

    String toString();
}
