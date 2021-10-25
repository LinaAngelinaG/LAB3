package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

	interface MyInterface {
		// абстрактный метод
		String fullname(Employee e);
	}

	static void display(Supplier<Object> arg) {
		System.out.println(arg.get());
	}

    public static void main(String[] args) throws Exception {
	    List<Employee> list_employees = Employee.createShortList();
	    System.out.println("\n FOR WOMEN :: \n\n\n");
	    list_employees.stream()
                .filter(e -> e.getGender().equals(Employee.Gender.FEMALE))
                .forEach(e-> Accountant.payPremium(e));

		System.out.println("\n FOR CONSULTING :: \n\n\n");
	    list_employees.stream()
                .filter(e -> e.getDept().equals("Consulting"))
                .forEach(e -> Accountant.paySalary(e));

		System.out.println("\n FOR STATISTICS WITH AGE > 30 :: \n\n\n");
	    list_employees.stream()
                .filter(e -> e.getDept().equals("Statistics"))
                .filter(e -> e.getAge() > 30)
                .forEach(e -> Accountant.payPremium(e));

		System.out.println("\n FOR MANAGERS :: \n\n\n");
	    list_employees.stream()
                .filter(e -> e.getRole().equals(Employee.Role.MANAGER))
                .forEach(e -> Accountant.paySalary(e));

		System.out.println("\n FOR STAFF :: \n\n\n");
        list_employees.stream()
                .filter(e -> e.getRole().equals(Employee.Role.STAFF))
                .forEach(e -> Accountant.payPremium(e));

        //Consumer Lambda Expression

		Consumer<Employee> consumer1 = x -> Accountant.paySalary(x);
		Consumer<Employee> consumer2 = x -> Accountant.payPremium(x);

		System.out.println("\n CONSUMER1 :: \n");
		consumer1.accept(list_employees.get(0));

		System.out.println("\n CONSUMER2 ::");
		consumer2.accept(list_employees.get(0));

		//Function Lambda Expression
		MyInterface name = (str) -> {
			String s = "";
			s = s + str.getRole() +  " " + str.getGivenName() +  " " + str.getSurName()  + "\n";
			return s;
		};

		System.out.println("\n For the 1st employee :: \n");
		System.out.println(name.fullname(list_employees.get(0)) + "\n");

		//Supplier Lambda Expression
		System.out.println("\n For the 1st employee supplier:: \n");

		display(() -> list_employees.get(0).toString());

		//BiPredicate Lambda Expression
		Employee e = list_employees.get(0);
		BiPredicate<Employee, Integer> bi = (x, y) -> x.getAge() > y;
		System.out.println("\n\nITS AGE IS " + e.getAge() + "  BiPredicate showed that  "+ e.getAge() + " > 30 is  " + bi.test(e, 30));
	}
}