package ru.mephi.lab5;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static String menu = """
        1. pay premium to all female employees
        2. pay salary to all employees from certain dept
        3. pay premium to all employees older 30 years from certain dept
        4. pay salary to all managers
        5. pay premium to all staff
        6. print all employees
        0. exit""";


    public static void printEmployees(ArrayList<Employee> employees) {
        System.out.println("All employees:");
        for(Employee e : employees) {
            System.out.println(e.toString());
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = Employee.createShortList();
        Accountant accountant = new Accountant();
        boolean loop = true;

        while (loop) {
            System.out.println(menu);
            System.out.println("Input option:");
            int input = sc.nextInt();
            System.out.println("\n===========\n");
            switch (input) {
                case 0 -> loop = false;
                case 1 -> employees.stream().
                        filter(e -> e.getGender() == GENDER.FEMALE).
                        forEach(accountant::payPremium);
                case 2 -> employees.stream().
                        filter(e -> Objects.equals(e.getDept(), "development")).
                        forEach(accountant::paySalary);
                case 3 -> employees.stream().
                        filter(e -> e.getAge() >= 30 && Objects.equals(e.getDept(), "development")).
                        forEach(accountant::payPremium);
                case 4 -> employees.stream().
                        filter(e -> e.getRole() == ROLE.MANAGER).
                        forEach(accountant::paySalary);
                case 5 -> employees.stream().
                        filter(e -> e.getRole() == ROLE.STAFF).
                        forEach(accountant::payPremium);
                case 6 -> printEmployees(employees);
                default -> System.out.println("Incorrect option! Try again.");
            }
            System.out.println("\n===========\n");
        }
    }
}
