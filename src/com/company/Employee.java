package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Employee {
    private String givenName;  /**/
    private String surName;   /**/
    private Integer age;
    private final Gender gender;
    private Role role;
    private String dept;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private Integer code;

    protected enum Gender {MALE, FEMALE};
    protected enum Role {STAFF, MANAGER, EXECUTIVE};

    public static class EmployeeBuilder {
        private String givenName;    /**/
        private String surName;     /**/
        private Integer age;
        private Gender gender;
        private Role role;
        private String dept;
        private String eMail;
        private String phone;
        private String address;
        private String city;
        private String state;
        private Integer code;

        public EmployeeBuilder(){ //neccessary or not?
            super();
        }
        public EmployeeBuilder givenName(String name){
            this.givenName = name;
            return this;
        }
        public EmployeeBuilder surName(String name){
            this.surName = name;
            return this;
        }
        public EmployeeBuilder age(Integer age){
            this.age = age;
            return this;
        }
        public EmployeeBuilder gender(Gender name){
            this.gender = name;
            return this;
        }
        public EmployeeBuilder role(Role name){
            this.role = name;
            return this;
        }
        public EmployeeBuilder dept(String name){
            this.dept = name;
            return this;
        }
        public EmployeeBuilder eMail(String name){
            this.eMail = name;
            return this;
        }
        public EmployeeBuilder phone(String name){
            this.phone = name;
            return this;
        }
        public EmployeeBuilder address(String name){
            this.address = name;
            return this;
        }
        public EmployeeBuilder city(String name){
            this.city = name;
            return this;
        }
        public EmployeeBuilder state(String name){
            this.state = name;
            return this;
        }
        public EmployeeBuilder code(Integer i){
            this.code = i;
            return this;
        }
        public Employee build() throws Exception{
            if(validEmpl()){
                return new Employee(this);
            }
            System.out.println("There's not enough parametrs to create an Employee");
            return null;
        }
        private boolean validEmpl(){
            return (givenName != null && surName!= null && age > 0 && gender != null && role != null && dept != null && address != null && city != null && code > 0 && phone != null && eMail != null && state != null);
        }
    }
    public Employee(EmployeeBuilder builder) throws Exception {
        if(builder == null){
            throw new Exception("Impossible to build without a builder!");
        }
        
        givenName = builder.givenName;
        surName = builder.surName;
        age = builder.age;
        gender = builder.gender;
        role = builder.role;
        dept = builder.dept;
        eMail = builder.eMail;
        phone = builder.phone;
        address = builder.address;
        city = builder.city;
        state = builder.state;
        code = builder.code;
    }

    public String getGivenName() {
        return givenName;
    }
    public Integer getAge() {
        return age;
    }
    public Role getRole() {
        return role;
    }
    public String geteMail() {
        return eMail;
    }
    public String getDept() {
        return dept;
    }
    public String getPhone() {
        return phone;
    }
    public String getCity() {
        return city;
    }
    public String getAddress() {
        return address;
    }
    public Integer getCode() {
        return code;
    }
    public String getState() {
        return state;
    }
    public Gender getGender() {
        return gender;
    }
    public String getSurName() {
        return surName;
    }

    public String toString(){
        StringBuffer b = new StringBuffer();
        b.append("Employee:: givenName = ").append(givenName).append(", surname = ").append(surName);
        b.append(", age = ").append(age).append(", gender = ").append(gender);
        b.append(", role = ").append(role).append(", dept = ").append(dept);
        b.append(", email = ").append(eMail).append(", phone = ").append(phone);
        b.append(", address = ").append(address).append(", city = ").append(city);
        b.append(", state = ").append(state).append(", code = ").append(code);
        return b.toString();
    }

    static List<Employee> createShortList() throws Exception {
        List<Employee> list = new ArrayList<>();
        list.add(
                new Employee.EmployeeBuilder()
                        .givenName("Anna")
                        .surName("Gurec")
                        .gender(Gender.FEMALE)
                        .role(Role.MANAGER)
                        .dept("Consulting")
                        .state("Missury")
                        .city("Frntlin")
                        .address("Rfghah 12")
                        .eMail("4567FFF@mail.ru")
                        .age(23)
                        .code(13)
                        .phone("2361245")
                        .build()
        );
        list.add(
                new Employee.EmployeeBuilder()
                        .givenName("Mark")
                        .surName("Fermes")
                        .gender(Gender.MALE)
                        .role(Role.STAFF)
                        .dept("Buisness_intelligence")
                        .state("Vuas")
                        .city("Fock")
                        .address("Dorket 122")
                        .eMail("MArkF@mail.ru")
                        .age(43)
                        .code(17)
                        .phone("9991245")
                        .build()
        );
        list.add(
                new Employee.EmployeeBuilder()
                        .givenName("Liss")
                        .surName("Kores")
                        .gender(Gender.FEMALE)
                        .role(Role.EXECUTIVE)
                        .dept("Statistics")
                        .state("Missury")
                        .city("Frntlin")
                        .address("Erockeds 12")
                        .eMail("LISSFer@mail.ru")
                        .age(26)
                        .code(13)
                        .phone("23456124")
                        .build()
        );
        list.add(
                new Employee.EmployeeBuilder()
                        .givenName("Merced")
                        .surName("Dock")
                        .gender(Gender.FEMALE)
                        .role(Role.STAFF)
                        .dept("Buisness_intelligence")
                        .state("Dosce")
                        .city("Fraen")
                        .address("Fghahn 12")
                        .eMail("Mercy@mail.ru")
                        .age(31)
                        .code(21)
                        .phone("894578")
                        .build()
        );
        list.add(
                new Employee.EmployeeBuilder()
                        .givenName("Pavel")
                        .surName("Grruc")
                        .gender(Gender.MALE)
                        .role(Role.EXECUTIVE)
                        .dept("Consulting")
                        .state("Missury")
                        .city("Frntlin")
                        .address("Ehjcdbs 12")
                        .eMail("4F4545FF@mail.ru")
                        .age(25)
                        .code(13)
                        .phone("7811245")
                        .build()
        );
        list.add(
                new Employee.EmployeeBuilder()
                        .givenName("Mellisa")
                        .surName("Duec")
                        .gender(Gender.FEMALE)
                        .role(Role.EXECUTIVE)
                        .dept("Consulting")
                        .state("Misssip")
                        .city("Douper")
                        .address("Tiggerr 32")
                        .eMail("mellisad@mail.ru")
                        .age(25)
                        .code(15)
                        .phone("65486456")
                        .build()
        );
        list.add(
                new Employee.EmployeeBuilder()
                        .givenName("Tim")
                        .surName("Tocker")
                        .gender(Gender.MALE)
                        .role(Role.MANAGER)
                        .dept("Statistics")
                        .state("Missury")
                        .city("Wrotl")
                        .address("Heighter 12")
                        .eMail("ttim@mail.ru")
                        .age(34)
                        .code(13)
                        .phone("2345111")
                        .build()
        );
        list.add(
                new Employee.EmployeeBuilder()
                        .givenName("Anna")
                        .surName("Gerck")
                        .gender(Gender.FEMALE)
                        .role(Role.STAFF)
                        .dept("Consulting")
                        .state("Missury")
                        .city("Frntlin")
                        .address("Fortrait 12")
                        .eMail("annann@mail.ru")
                        .age(21)
                        .code(13)
                        .phone("2366665")
                        .build()
        );
        return list;
    }
}