package com.grand.ch06;

import java.util.ArrayList;
/*
* java.util.function包中有一个Predicate接口
* ArrayList中removeIf方法，他的参数就是一个Predicate。这个接口专门用来传递lambda表达式
* */
public class ArrayMoveNullTest {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>(3);
        employees.add(new Employee("Harry",35000));
        employees.removeIf(e -> e == null);
        System.out.println(employees.size());
        for (Employee e: employees) {
            System.out.printf("name:%s,salary:%hd",e.getName(),e.getSalary());
        }
    }
}
