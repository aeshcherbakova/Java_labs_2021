package ru.mephi.lab5;

import java.util.ArrayList;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTask {

    private static final ArrayList<Employee> employees = Employee.createShortList();
    private static final Accountant accountant = new Accountant();

    // Add 5k to everyone's salary
    public static void consumerExample() {
        Consumer<Employee> addSalary = e -> accountant.promote(e, 5000);
        employees.forEach(addSalary);
    }

    // Annual payment for all employees
    public static void functionExample() {
        Function<Employee, Integer> calcAnnualPayment = e -> e.getSalary() * 12;
        employees.forEach(
                e -> System.out.println(
                        e.getFullName() + " - " + calcAnnualPayment.apply(e) + " rubbles"
                )
        );
    }

    // Create template of employee
    public static void supplierExample() {
        Supplier<Employee> defaultEmployee = () -> new Employee.EmployeeBuilder()
                .givenName("Ivan")
                .surName("Ivanov")
                .age(25)
                .salary(20000)
                .gender(Gender.MALE)
                .role(Role.STAFF)
                .dept("development")
                .email("ivanov@gmail.com")
                .phone("+71234567890")
                .build();
        employees.add(defaultEmployee.get());
        System.out.println(employees.get(employees.size() - 1).toString());
    }

    // Add 3k to employees with salary smaller then 50000
    public static void biPredicateExample() {
        BiPredicate<Employee, Integer> isSalarySmaller = (employee, val) -> employee.getSalary() < val;
        employees.stream()
                .filter(e -> isSalarySmaller.test(e, 50000))
                .forEach(e -> accountant.promote(e, 3000));
    }

    public static void main(String[] args) {
        System.out.println("Consumer Lambda Expression test:\n");
        consumerExample();

        System.out.println("\n==============\n");
        System.out.println("Function Lambda Expression tests:\n");
        functionExample();

        System.out.println("\n==============\n");
        System.out.println("Supplier Lambda Expression tests:\n");
        supplierExample();

        System.out.println("\n==============\n");
        System.out.println("BiPredicate Lambda Expression tests:\n");
        biPredicateExample();
    }

}
