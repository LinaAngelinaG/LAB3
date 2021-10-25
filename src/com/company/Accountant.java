package com.company;

public class Accountant {
    public static void paySalary(Employee e){
        Integer sum;
        if(e.getRole() == Employee.Role.EXECUTIVE){
            sum = 30000;
        }
        else if(e.getRole() == Employee.Role.MANAGER){
            sum = 20000;
        }
        else{
            sum = 10000;
        }
        System.out.println("Salary  =  " + sum + " for:");
        System.out.println(e.toString());
    }
    public static void payPremium(Employee e){
        Integer sum;
        if(e.getRole() == Employee.Role.EXECUTIVE){
            sum = 10000;
        }
        else if(e.getRole() == Employee.Role.MANAGER){
            sum = 4000;
        }
        else{
            sum = 1000;
        }
        System.out.println("Premium  =  " + sum + " for:");
        System.out.println(e.toString());
    }
}
