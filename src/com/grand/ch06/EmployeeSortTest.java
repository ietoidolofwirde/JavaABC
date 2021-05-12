package com.grand.ch06;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry",35000);
        staff[1] = new Employee("TOM",50000);
        staff[2] = new Employee("Tony",60000);
        Arrays.sort(staff);
        for (Employee e: staff
             ) {
            System.out.println("name " + e.getName() + ",salary=" + e.getSalary());
        }
    }
}
