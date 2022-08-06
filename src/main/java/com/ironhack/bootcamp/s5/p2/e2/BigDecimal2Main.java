package com.ironhack.bootcamp.s5.p2.e2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Using the BigDecimal documentation and create two big decimals.
 * Perform add, subtract, divide, multiply,
 * and modulus operations between them and print the results after each operation.
 *
 * As a challenge, determine how to perform the following operation (2.3 * x + 1.5) / (x - 0.8).
 */
public class BigDecimal2Main {
    public static void main(String[] args) {
        BigDecimal x = new BigDecimal(.7);
        System.out.println(operate(x));
    }

    public static BigDecimal operate(BigDecimal x) {
        float test1 = 1.2f + 2.3f;
        BigDecimal dosPuntoTres = new BigDecimal(2.3);
        BigDecimal unoPuntoCinco = new BigDecimal(1.5);
        BigDecimal primeraMultiplicacion = dosPuntoTres.multiply(x);
        BigDecimal primeraSuma = primeraMultiplicacion.add(unoPuntoCinco);

        BigDecimal ceroPuntoOcho = new BigDecimal(0.8);
        BigDecimal segundaParte = x.subtract(ceroPuntoOcho);

        return primeraSuma.divide(segundaParte,5, RoundingMode.HALF_EVEN).setScale(5, RoundingMode.HALF_EVEN);
//        return primeraSuma.divide(segundaParte, 5, RoundingMode.HALF_EVEN);
    }
}
