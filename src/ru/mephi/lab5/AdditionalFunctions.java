package ru.mephi.lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AdditionalFunctions {

    // max
    public static Employee maxPremium(ArrayList<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparing(e -> e.getSalary() * e.getRole().getPremiumPercent()))
                .orElse(null);
    }

    // min
    public static Employee minSalary(ArrayList<Employee> employees) {
        return employees.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    // map
    public static List<String> toNamesMap(ArrayList<Employee> employees) {
        return employees.stream()
                .map(e -> e.getFullName() + ", " + e.getRole().toString() + ", salary = " + e.getSalary())
                .collect(Collectors.toList());
    }

    // findFirst
    public static Employee firstDevelopment(ArrayList<Employee> employees) {
        return employees
                .stream()
                .filter(e -> Objects.equals(e.getDept(), "development"))
                .findFirst()
                .orElse(null);
    }

    // sum
    public static int sumSalary(ArrayList<Employee> employees) {
        return employees
                .stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    // average
    public static int averageAge(ArrayList<Employee> employees) {
        return (int) employees
                .stream()
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0);
    }

    /*
     peek + lazy
     peek, map, filter - конвейерные операции
     у стримa может быть сколько угодно вызовов конвейерных вызовов и в конце один терминальный,
     при этом все конвейерные методы выполняются лениво и пока не будет вызван терминальный метод,
     никаких действий на самом деле не происходит
     для каждого элемента выполняется peek1, потом сразу для него же filter.
     Если не прошел filter - следующий элемент, если прошел - peek2 и return
    */
    public static Employee peek(ArrayList<Employee> employees) {
        return employees.stream()
                .peek(e -> System.out.println("peek1: " + e.getFullName() + ", " + e.getDept()))
                .filter(e -> Objects.equals(e.getDept(), "management"))
                .peek(e -> System.out.println("peek2: " + e.getFullName() + ", " + e.getDept()))
                .findAny()
                .orElse(null);
    }

    public static void main(String[] args) {

        ArrayList<Employee> employees = Employee.createShortList();

        System.out.println("\nAverage age of employees = " + averageAge(employees)
                + "\nFirst employee from development department - " + firstDevelopment(employees).getFullName()
                + "\nSum monthly salary = " + sumSalary(employees)
                + "\nEmployee with max premium - " + maxPremium(employees).getFullName()
                + "\nEmployee with min salary - " + minSalary(employees).getFullName()
        );

        System.out.println("\nAll employees names, roles and salaries:");
        toNamesMap(employees).forEach(System.out::println);

        System.out.println("\nFind any from management department: (lazy streams demonstration)");
        peek(employees);

    }

}
