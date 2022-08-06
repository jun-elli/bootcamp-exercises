package com.ironhack.bootcamp.s11enumshashmaps;

import java.util.Arrays;
import java.util.List;

public enum Hold {
    NONE,
    FRAUD,
    DELINQUENCY,
    LOST_STOLEN,
    LITIGATION_HOLD,
    FREERIDING;

    public boolean isOnHold() {
        return getIllegitHoldingStates().contains(this);
    }

    public static List<Hold>  getIllegitHoldingStates() {
        return Arrays.asList(FRAUD, DELINQUENCY, LOST_STOLEN, LITIGATION_HOLD, FREERIDING);
    }
}