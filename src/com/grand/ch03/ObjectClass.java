package com.grand.ch03;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

/*
* 总结在类之后
* 1 一定要保证数据私有
* 2 一定要对数据初始化
* 3 不要再类中使用过多的基本类型
* 4 不是所有的域都需要独立的域访问器和域更改器
* 5 将职责过多的类进行分解
* */

class Employ{
    private String name;
    private double salary;
    private LocalDate hireDay;
    public Employ(String name,double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }
    public void getName(){
        System.out.println(this.name);
    }
    public void getSalary(){
        System.out.println(this.salary);
    }
    public void setSalary(double x){
        if(x > 0){
            this.salary += x;
        }
    }
    public boolean raiseSalary(double x){
        try{
            this.setSalary(x);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}

class Employee{
    /*
    * 静态方法相当于没有this的隐式参数，静态方法不能调用实例方法和属性，但是静态方法可以调用static修饰的属性和方法
    * */
    private static int nextId = 1;
    private String name;
    private double salary;
    private int id;
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        this.id = 0;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public int getId(){
        return id;
    }

    public void setId(){
        id = nextId;
        nextId++;
    }

    public static int getNextId(){
        return nextId;
    }
}

class Employee2{
    /*
    * 语法要点
    * 重载构造器
    * 用this()调用另一个构造器
    * 无参对象构造器
    * 对象初始化块
    * 静态初始化块
    * 实例域初始化块
    * */
    private static int nextId;
    private int id;
    private String name = "";
    private double salary;

    // static initialization block
    // 静态代码块在类加载的init，类的类构造器会收集所有的static块和字段并执行，static块只执行一次，由JVM保证其执行一次。
    static{
        System.out.println("print the static initialization block");
        Random generator = new Random();
        nextId = generator.nextInt(100);
    }
    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    public Employee2(String name,double salary){
        this.name = name;
        this.salary = salary;
    }

    public Employee2(double salary){
        this.salary = salary;
    }

    public Employee2(){

    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public int getId(){
        return id;
    }

}

class Employee22{
    /*
    * 与上一个类进行对比，声明中复制可以是常量，变量，函数
    * */
    private static int nextId;
    private int id = assignId();
    private String name;
    private double salary;

    // static initialization block
    // 静态代码块在类加载的init，类的类构造器会收集所有的static块和字段并执行，static块只执行一次，由JVM保证其执行一次。
    static{
        System.out.println("print the static initialization block");
        Random generator = new Random();
        nextId = generator.nextInt(100);
    }

    private static int assignId(){
        int r = nextId;
        nextId ++;
        return r;
    }

    public Employee22(String name,double salary){
        this.name = name;
        this.salary = salary;
    }


    public double getSalary(){
        return salary;
    }

    public int getId(){
        return id;
    }

}

public class ObjectClass {
    public static void printThisMonth(){
        // 打印月份日历
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);
        System.out.println(date);
        DayOfWeek weekDay = date.getDayOfWeek();
        System.out.println(weekDay.toString());
        int value = weekDay.getValue();
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i =1; i < value ; i++) {
            System.out.print("    ");
        }
        while(date.getMonthValue() == month){
            System.out.printf("%3d",date.getDayOfMonth());
            if(date.getDayOfMonth() == today){
                System.out.print("*");
            }else{
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1 ){
                System.out.println();
            }
        }
        if(date.getDayOfWeek().getValue() != 1){
            System.out.println();
        }
    }

    public static void DateBaseKnowledge(){
        Date date = new Date();
        System.out.println(date.toString());
        // 本地时间表示法
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        System.out.printf("%d-%d-%d",year,month,day);
        LocalDate plusDate = localDate.plusDays(188);
        System.out.println();
        // 增加时间天 月  年
        System.out.println(plusDate.toString());
    }

    public static void EmployFunc(){
        Employ[] staff = new Employ[3];
        staff[0] = new Employ("Cracker",7500,1992,8,1);
        staff[1] = new Employ("Hankos", 8500, 1992,10,20);
        staff[2] = new Employ("Jorge",9500, 1992,6,6);
        for (Employ e:staff) {
            e.raiseSalary(500);
        }
        for (Employ e:staff) {
            e.getName();
            e.getSalary();
            System.out.println("==============");
        }
    }

    public static void staticEmployeeFunc(){
        /*
        *  主函数调用  静态方法可以调用static修饰的属性和方法
        * */
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Ton", 4000);
        staff[1] = new Employee("Dick",6000);
        staff[2] = new Employee("Harry", 6500);
        for (Employee e:staff) {
            e.setId();
            System.out.println("name"+ e.getName() + ",id=" + e.getId()+",salary:" + e.getSalary());
        }
        int n = Employee.getNextId();
        System.out.println("Next available id=" + n);

    }

    public static void main(String[] args){
        Employee2[] staff = new Employee2[3];
        staff[0] = new Employee2("Harry",1000);
        staff[1] = new Employee2(6900);
        staff[2] = new Employee2();
        for (Employee2 e:staff) {
            System.out.println("name:"+ e.getName() + ",id=" + e.getId()+",salary:" + e.getSalary());
        }
    }
}
