package ru.mephi.lab5;

public enum Role {
    STAFF("Staff", 50000, 0.1),
    MANAGER("Manager", 60000, 0.2),
    EXECUTIVE("Executive", 70000, 0.3);

    private final String role;
    private final double salary;
    private final double premiumPercent;

    Role(String _role, double _salary, double _percent) {
        role = _role;
        salary = _salary;
        premiumPercent = _percent;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public double getPremiumPercent() {
        return premiumPercent;
    }
}
