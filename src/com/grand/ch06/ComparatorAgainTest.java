package com.grand.ch06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * comparator 接口包含很多方便的静态方法来创建比较器，这些方法用于lambda表达式或引用
 * */
public class ComparatorAgainTest {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Tom",5000));
        employees.add(new Employee("Grand",6000));
        employees.add(new Employee("Edvin",9000));

        /*
        * 静态comparator方法键提取器，它将类型T映射为一个可比较的类型，对要对比的对象应用这个函数，然后对返回的键完成比较
        * */
        employees.sort(Comparator.comparing(Employee::getName));
        for (Employee e: employees
             ) {
            System.out.println(e.getName());
        }
        /*
        * 存在两个方法同名的时候使用第二个比较器
        * */
        employees.add(new Employee("Edvin",8000));
        employees.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        for (Employee e: employees
        ) {
            System.out.println(e.getName() + ":" + e.getSalary());
        }
    }
}
