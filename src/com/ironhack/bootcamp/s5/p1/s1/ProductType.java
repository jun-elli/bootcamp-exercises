package com.ironhack.bootcamp.s5.p1.s1;

import java.util.Arrays;
import java.util.List;

public enum ProductType {
    PRINTED_BOOK{
        @Override
        public boolean isDigital() {
            return false;
        }
    },
    PDF,
    KINDLE,
    EPUB,
    COMBO;

    private String name;


    public static boolean needsShipping(ProductType type) {
        return Arrays.asList(PRINTED_BOOK, COMBO).contains(type);
    }

    public static List getDigitalTypes() {
        return Arrays.asList(PDF, KINDLE, EPUB);
    }

    public boolean isDigital() {
        return ProductType.getDigitalTypes().contains(this);
    }

}
