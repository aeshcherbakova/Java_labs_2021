package ru.mephi.lab5;

public class Accountant {

    public void paySalary(Employee employee) {
        double salary = employee.getRole().getSalary();
        String log = "Employee " + employee.getFullName() + " paid " + salary + " salary";
        System.out.println(log);
    }

    public void payPremium(Employee employee) {
        ROLE role = employee.getRole();
        double premium = role.getSalary() * role.getPremiumPercent();
        String log = "Employee " + employee.getFullName() + " paid " + premium + " premium";
        System.out.println(log);
    }

}
