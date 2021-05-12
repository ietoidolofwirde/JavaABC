package com.grand.ch05;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLOutput;
import java.util.Scanner;

/*
 * 反射分析类功能介绍
 * java.lang.reflect中有三个类，Field/Method和Constructor分别用于描述类的域，方法和构造器
 * 三个类中都有getName方法，用来返回项目名称
 * Filed类有一个getType方法，Method类还有一个报告返回类型的方法。
 * 这三个类还有一个叫getModifiers方法，它将返回一个整型值，用不同的位开关描述public static这样修饰符使用状况
 *
 * Class类中的getFields.getMethods和getConstructors方法将分别返回类提供的public域/方法和构造器数组，
 * 其中包括超类中的公有成员
 * Class类的getDeclareFields、getDeclareMethods和getDeclareConstructors方法将分别返回类声明中的全部域、方法和构造器
 * 其中包括私有和受保护成员，但不包括超类
 * */
public class ReflectionTest {

    public static void main(String[] args) {
        String name;
        if(args.length > 0) name=args[0];
        else{
          Scanner in  = new Scanner(System.in) ;
            System.out.println("Enter class name (java.util.Date)");
            name = in.next();
        }

        try {
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if(modifiers.length() > 0){
                System.out.print("modifies" + " ");
                System.out.println("class " + name);
                if(supercl != null && supercl !=Object.class) System.out.print("extends " + supercl.getName());
                System.out.println("\n{\n");
                printConstructors(cl);
                System.out.println();
                printMethods(cl);
                System.out.println();
                printFields(cl);
                System.out.println("}");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    /*
    * Prints all constructors of class
    * @param cl a class
    * */
    public static void printConstructors(Class cl){
        Constructor[] constructors = cl.getConstructors();
        for(Constructor c : constructors){
            String name = c.getName();
            System.out.print("  ");
            String modifies = Modifier.toString(c.getModifiers());
            if(modifies.length() > 0){
                System.out.print(modifies + " ");
            }
            System.out.print(name + "(");
            Class[] paramTypes = c.getParameterTypes();
            for(int j=0; j<paramTypes.length; j++){
                if(j>0) System.out.print(",");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /*
    * Prints all methods of a class
    * @param cl a class
    * */
    public static void printMethods(Class cl){
        Method[] methods = cl.getMethods();
        for(Method m: methods){
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print(" ");
//          Print modifies, return type and method name
            String modifies = Modifier.toString(m.getModifiers());
            if(modifies.length() > 0) System.out.print(modifies + " ");
            System.out.print(retType.getName()+" "+ name + "(");
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if(j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /*
    * Prints all fields of a class
    * @param cl a class
    * */
    public static void printFields(Class cl){
        Field[] fields = cl.getFields();
        for(Field f: fields){
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifies = Modifier.toString(f.getModifiers());
            if(modifies.length() > 0) System.out.print(modifies + " ");
            System.out.println(type.getName()+ " " + name);
        }
    }
}
