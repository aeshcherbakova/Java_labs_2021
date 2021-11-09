package ru.mephi.lab5;

public class Accountant {

    public void paySalary(Employee employee) {
        System.out.println(
                "Employee " + employee.getFullName() +
                        " paid " + employee.getRole().getSalary() + " salary");
    }

    public void payPremium(Employee employee) {
        Role role = employee.getRole();
        double premium = role.getSalary() * role.getPremiumPercent();
        System.out.println("Employee " + employee.getFullName() + " paid " + premium + " premium");
    }

}
