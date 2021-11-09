package ru.mephi.lab5;

import java.util.Locale;

public enum Role {
    STAFF(0.1),
    MANAGER(0.2),
    EXECUTIVE(0.3);

    private final double premiumPercent;

    Role(double _percent) {
        premiumPercent = _percent;
    }

    public double getPremiumPercent() {
        return premiumPercent;
    }

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }
}
