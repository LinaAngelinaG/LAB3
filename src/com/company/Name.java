package com.company;

public interface Name {
    static String fullname(Employee str){
        String s = "";
        s = s + str.getRole() + " " + str.getGivenName() + " " + str.getSurName() + "\n";
        return s;
    }
}
