package com.company;

public class Accountant {
    public static void paySalary(Employee e){
        if (e != null){
            System.out.println("Salary  =  " + e.getSalary() + " for:");
            System.out.println(e.toString());
        }
        else{
            System.out.println("Empty employee");
        }
    }
    public static void payPremium(Employee e){
        if(e != null){
            Integer s;
            switch(e.getRole()){
                case EXECUTIVE:
                    s = 10000;
                    break;
                case MANAGER:
                    s = 4000;
                    break;
                default:
                    s = 1000;
            }
            System.out.println("Premium  =  " + s + " for:");
            System.out.println(e.toString());
        }
        else{
            System.out.println("Empty employee");
        }
    }
}
