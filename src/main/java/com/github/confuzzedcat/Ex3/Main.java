package com.github.confuzzedcat.Ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        Predicate<Integer> thirds = x -> x % 3 == 0;

        for (int i : a){
            if(thirds.test(i)){
                System.out.println(i);
            }
        }
        List<Employee> employeeList = new ArrayList<>(List.of(new Employee("John"), new Employee("Jane"), new Employee("Jack"), new Employee("Joe"), new Employee("Jill")));


        Consumer<List<Employee>> printEmployees = (employees) -> {
            for (Employee e:employees) {
                System.out.println(e);
            }
        };


        printEmployees.accept(employeeList);


    }
}
