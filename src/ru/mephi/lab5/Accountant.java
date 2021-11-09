package ru.mephi.lab5;

public class Accountant {

    public void paySalary(Employee employee) {
        System.out.println(
                "Employee " + employee.getFullName() +
                        " paid " + employee.getSalary() + " salary");
    }

    public void payPremium(Employee employee) {
        System.out.println("Employee " + employee.getFullName() + " paid "
                + employee.getSalary() * employee.getRole().getPremiumPercent() + " premium");
    }

    public void promote(Employee employee, int sum) {
        int newSalary = employee.getSalary() + sum;
        employee.setSalary(newSalary);
        System.out.println("Employee " + employee.getFullName() + " new salary is " + newSalary);
    }

}
