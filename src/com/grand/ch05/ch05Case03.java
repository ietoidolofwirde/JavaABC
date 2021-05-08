package com.grand.ch05;

import java.time.LocalDate;

/*
* Java 核心技术卷一 Object所有类的超类
*
*
* */
class Employee3{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee3(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public LocalDate getHireDay(){
        return hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary+=raise;
    }

    public boolean equals(Object otherObject){
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(this.getClass() != otherObject.getClass()) return false;
        Employee3 other = (Employee3) otherObject;
        return name.equals(other.name) && salary == other.salary && hireDay.equals(other.hireDay);
    }

    /*
    * 相等测试与继承
    * 如果隐式参数和显式参数不属于同一个类
    * Java语言规范要求equals具有下面的特性
    * 自反性：任何非空引用 X x.equals(x) 应该返回false;
    * 对称性： 对于任何引用 x 和 y 当且仅当 x.equals(y) 返回true，y.equals(x) 也返回true
    * 传递性：
    * 一致性：
    * equals 完美建议
    * 1. 显示参数命名为otherObject,稍后需要将它转换为一个叫做other的变量
    * 2. 检测this与otherObject是否引用同一对象
    * 3. 检测otherObject是否为null
    * 4. 比较this与otherObject是否属于同一个类。如果equals的语义在每个类中有所改变就使用getClass来检测，
    * 如果所有的子类都拥有同一的语义就是用instanceOf来检测
    * 5. 将otherObject转换为相应类型变量
    * 6. 现在开始对所有需要比较的域进行比较，使用 == 比较基本数据类型
    * */
}
public class ch05Case03 {
    public static void main(String[] args) {
        System.out.println("main  method");
        Employee3 e = new Employee3("Grand",900000,2015,7,5);
        Employee3 other = new Employee3("Grand",900000,2015,7,5);
        System.out.println(e.equals(other));
    }
}
