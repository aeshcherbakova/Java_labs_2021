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

    /* TODO: testing functions:
    1. pay premium to all female employees
    2. pay salary to all employees from certain dept
    3. pay premium to all employees older 30 years from certain dept
    4. pay salary to all managers
    5. pay premium to all staff
     */

}
