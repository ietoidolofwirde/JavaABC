package com.grand.ch05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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

    /*
    * hasCode方法
    * 散列码是由对象导出的一个整型值。散列码没有规律，如果x和y是两个不同对象，x.hashCode()与y.hashCode()基本上是会不同的
    * hashCode方法定义在Object类中，因此对象都会有一个默认的散列码，其值为对象的存储地址。
    *
    * 字符串s与t拥有相同的散列码，这是因为字符串的散列码是由内容导出的。字符串缓冲sb和tb有着不同的散列码，这个是因为在
    * StringBuffer中没有定义hashCode方法，它的散列码是由Object类默认输出的对象地址
    * String 和 StringBuilder的散列码
    * 对象                 散列码
    *  s                   2556
    *  sb                  20543894
    *  t                   2556
    *  tb                  32564679
    * */

    public void showHashCodeFunc(){
        String s = "OK";
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        System.out.println(s.hashCode()+" "+ sb.hashCode());
        String t = new String("OK");
        StringBuilder tb = new StringBuilder(t);
        System.out.println(t.hashCode()+" "+ tb.hashCode());
    }

    /*
    * 如果从新定义equals方法就必须重新定义hashCode方法，并合理地组合实例域的散列码，以便能够让各个不同的对象产生的散列码更加均匀
    *
    * Equals与hashCode的定义必须一致，如果x.equals(y)放回true，那么x.hashCode()就必须与y.hashCode()具有相同的值。
    * 例如 如果用定义的Employee.equals比较雇员的ID，那么hashCode就需要散列ID
    * */
    public int hashCode(){
        return 7* Objects.hashCode(name)
                + 11* Double.hashCode(salary) // 使用double.hashCode避免创建Double对象
                + 13* hireDay.hashCode();
        /*
        * 一种更加简单的方法
        * return Objects.hash(name,salary,hireDay);
        * */
    }

    /*
    * toString方法 用于返回对象值的字符串
    * 子类可以继承父类的toString()方法
    * 强烈建议对每一个类都添加一个toString方法
    * */
    public String toString(){
        return getClass().getName()
                +"[name="+name
                +",salary="+salary
                +",hireDay="+hireDay
                +"]";
    }

}


/*
* 定义一个枚举类
* size.SMALL.toString  small
* Size s = Enum.valueOf(Size.class,"SMALL") 将s设置成为Size.SMALL
* int ordinal() 返回枚举常量在enum声明中的位置
* int compareTo(E other) 如果枚举常量出现在other之前，则返回一个负值，相等返回0 否则返回正值
* */
enum Sizee{
    SMALL, MEDIUM, LARGE;
}
enum Size{
    SMALL("S"),MDIUM("M"),LARGR("L"), EXTRA_LARGE("XL");
    private String abbreviation;
    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation(){
        return abbreviation;
    }
}




public class ch05Case03 {

    public static void arrayListTest(){
        /*
        * ArrayList<> 实现泛型和自动动态扩容的技术
        * staff.size() 返回存储在数组列表中的当前元素数量（这个值将小于数组列表的容量）
        * staff.ensureCapacity(int capacity) 确保数组列表不在分配存储空间的情况下能够保存给定数量的元素
        * staff.trimToSize() 将数组的存储容量削减到当前尺寸
        * staff.add(i,object) //在那个位置添加
        * staff.remove(i) //删除那个位置的元素
        * staff.get(i) //获取该位置的元素
        * */
        ArrayList<Employee3> staff = new ArrayList<>();
        staff.add(new Employee3("Carl",75000,1987,12,15));
        staff.add(new Employee3("Harry",75000,1987,12,15));
        staff.add(new Employee3("Tony",75000,1987,12,15));
        staff.add(1,new Employee3("Grand",75000,1987,12,15));
        for(Employee3 e:staff){
            e.raiseSalary(500);
        }
        for(Employee3 e:staff){
            System.out.println(e.toString());
        }
    }

    public static void enumTestFunc(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a size:（SMALL, MEDIUM, LARGE, EXTRA_LARGE）");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class,input);
        System.out.println("size" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if(size == Size.EXTRA_LARGE){
            System.out.println("Good job");
        }
    }

    public static void reflexFunc(){
        /*
         * 反射
         * 反射机制可以用来：
         * 在运行时分析类的能力
         * 在运行时查看对象，列如编写一个toString方法供所有类使用
         * 实现通用数组操作代码
         * 利用Method对象
         *
         * class类
         * 在程序运行期间，Java运行时系统始终为所有对象维护一个称为运行时的类型标识
         * 这个信息跟踪着每个对象所属的类虚拟利用运行时类型信息选择相应的方法执行
         * 通过专门的Java类访问这些信息就是Class类 Object类中getClass就是返回Class类的一个实例
         * */
        // 第一种获得Class对象的方法
        Employee3 e = new Employee3("Grand",900000,2015,7,5);
        Class cl = e.getClass();
        System.out.println(cl.getName()+"-"+ e.getName());
        String className = "com.grand.ch05.Employee3";

        // 通过类名称字符串获得Class对象
        try {
            Class cc = Class.forName(className);
            System.out.println(cc.getName());
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        //第三种获得Class对象的方法
        Class cl2 = int.class;
        Class cl3 = double.class;
        System.out.println(cl2.getName()+"-"+cl3.getName());

        /*
        * 虚拟机为每个类型管理一个Class对象，可以利用 == 运算符实现两个类比较的操作
        * */
        if(e.getClass() == Employee3.class){
            System.out.println("利用 == 运算符进行两个类的比较");
        }
        /*
        * 利用forName与newInstance来动态创造一个实例
        * */
        String s = "com.grand.ch05.Employee3";
        try {
            Class cl4 = Class.forName(s);
            /*
            *  这个方法掉调用一个默认的构造器初始化创建一个新的对象，如果这个类没有默认构造器，就会抛出一个异常
            *  如果要调用参数构造器，不能用下面方法，而要使用Constructor类中的newInstance方法
            * */
            cl4.getConstructors();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

    }



    public static void main(String[] args) {
//        System.out.println("main  method");
//        Employee3 e = new Employee3("Grand",900000,2015,7,5);
//        Employee3 other = new Employee3("Grand",900000,2015,7,5);
//        System.out.println(e.equals(other));
//        e.showHashCodeFunc();
//        System.out.println(e.toString());
//        arrayListTest();
//        enumTestFunc();
        reflexFunc();
    }
}
