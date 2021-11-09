package ru.mephi.lab5;

public enum Role {
    STAFF("Staff", 0.1),
    MANAGER("Manager", 0.2),
    EXECUTIVE("Executive", 0.3);

    private final String role;
    private final double premiumPercent;

    Role(String _role, double _percent) {
        role = _role;
        premiumPercent = _percent;
    }

    public String getRole() {
        return role;
    }

    public double getPremiumPercent() {
        return premiumPercent;
    }
}
