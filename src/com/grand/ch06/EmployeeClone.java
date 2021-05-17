package com.grand.ch06;

import java.util.Date;
import java.util.GregorianCalendar;

public class EmployeeClone implements Cloneable {
    private String name;
    private double salary;
    private Date hireDay;

    public EmployeeClone(String name,double salary){
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }

    public EmployeeClone clone() throws CloneNotSupportedException{
        // call Object.clone()
        EmployeeClone cloned = (EmployeeClone) super.clone();
        cloned.hireDay = (Date)hireDay.clone();
        return cloned;
    }

    /*
    * Set the hire day to a given date
    * @param year the year of the hire day
    * @param month the month of the hire day
    * @param day the day of hire day
    * */
    public void setHireDay(int year, int month, int day){
        Date newHireDay = new GregorianCalendar(year,month-1,day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary+=raise;
    }

    public String toString(){
        return "Empluyee[name="+name+", salary="+salary+", hireDay="+hireDay+"]";
    }
}
