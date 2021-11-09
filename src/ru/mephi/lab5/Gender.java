package ru.mephi.lab5;

import java.util.Locale;

public enum Gender {
    MALE,
    FEMALE;

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
