package com.grand.ch05;

/*
* Java核心技术卷一 第五章 继承层次
* 抽象类
* 抽象类除了抽象方法以外还可以包含具体数据和具体方法
* 抽象方法充当着占位的角色，它们的具体实现在子类中。扩展抽象类可以有两种选择：
* 一种是在抽象类中定义部分抽象方法或不定义抽象方法，这样就必须将子类也标记为抽象类
* 另一种是定义全部抽象方法，这样一来，子类就不是抽象的了。
* 一个类中含有抽象方法就必须声明为抽象类
* 抽象类不可能被实例化
* */

import java.time.LocalDate;

abstract class Person{
    public abstract String getDescription();
    private String name;
    public Person(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}

class Employee1 extends Person{
    private double salary;
    private LocalDate hirday;

    public Employee1(String name, double salary, int year, int month, int day){
        super(name);
        this.salary = salary;
        this.hirday = LocalDate.of(year,month,day);
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f",salary);
    }

    public double getSalary(){
        return this.salary;
    }

    public LocalDate getHirday(){
        return this.hirday;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

class Student extends Person{

    private String major;
    public Student(String name, String major){
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in" + major;
    }
}



public class ch05Case02 {
    /*
    * 其实可以省略Person超类中的抽象方法，而仅在Employee和Student子类中定义getDescription方法？但是如果这样的话
    * 就不能通过变量P调用getDescription方法了。编译器只允许调用在类中声明的方法
    *
    * 归纳 Java用于控制可见性的4个修饰符
    * 仅对本类可见————private
    * 对所有类可见————public
    * 对本包和所有子类可见——protected
    * 对本包可见————默认 不需要修饰符
    * */
    public static void main(String[] args) {
        System.out.println("main method");
        Person[] peoples = new Person[2];
        peoples[0] = new Employee1("Harry",50000,1992,8,28);
        peoples[1] = new Student("Maria","computer science");
        for (Person p:peoples
             ) {
            System.out.println(p.getName()+", "+p.getDescription());
        }
    }
}
