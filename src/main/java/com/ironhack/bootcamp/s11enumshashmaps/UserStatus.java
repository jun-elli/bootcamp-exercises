package com.ironhack.bootcamp.s11enumshashmaps;

import java.util.Arrays;
import java.util.List;

public enum UserStatus {
    ONLINE ( "online", 1) {
        @Override
        public List<UserStatus> group() {
            return Arrays.asList(ONLINE, OFFLINE);
        }

        public List<UserStatus> inactiveStatuses() {
            return Arrays.asList(DEACTIVATED, BLOCKED, DISABLED );
        }
    },
    OFFLINE ( "offline", 2),
    DEACTIVATED ("deactivated", 3),
    BLOCKED ("blocked", 4),
    DISABLED ("disabled", 5);

    private String alias;
    private int code;


    UserStatus(String alias, int code) {
        this.alias = alias;
        this.code = code;
    }

    public String getAlias() {
        return this.alias;
    }

    public List<UserStatus> group() {
        return Arrays.asList( ONLINE, OFFLINE, DEACTIVATED, BLOCKED, DISABLED );
    }

    public static List<UserStatus> getActiveStatuses() {
        return Arrays.asList(ONLINE, OFFLINE);
    }

    public static boolean isActive(UserStatus candidate) {
        // grupo de estados habilitados en el sistema
        return Arrays.asList(ONLINE, OFFLINE).contains(candidate);
    }

    public boolean isActive() {
        return Arrays.asList(ONLINE, OFFLINE).contains(this);
    }

    public List<UserStatus> inactiveStatuses() {
        return group();
    }
}
