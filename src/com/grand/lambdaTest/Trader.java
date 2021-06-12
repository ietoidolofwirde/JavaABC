package com.grand.lambdaTest;

public class Trader {
    private String name;
    private String city;

    public Trader (String name,String city){
        this.name = name;
        this.city = city;
    }

    public String getName(){
        return this.name;
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String newCity){
        this.city = newCity;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String toString(){
        return "Trade" + this.name +  " in " + this.city;
    }
}
