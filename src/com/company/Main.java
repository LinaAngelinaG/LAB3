package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    //почему работает без implements Name??

    static void display(Supplier<Object> arg) {
        System.out.println(arg.get());
    }

    public static void main(String[] args) throws Exception {
        List<Employee> list_employees = Employee.createShortList();
        System.out.println("\n FOR WOMEN :: \n\n\n");
        list_employees.stream()
                .filter(e -> e.getGender().equals(Gender.FEMALE))
                .forEach(e -> Accountant.payPremium(e));

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
                .filter(e -> e.getRole().equals(Role.MANAGER))
                .forEach(e -> Accountant.paySalary(e));

        System.out.println("\n FOR STAFF :: \n\n\n");
        list_employees.stream()
                .filter(e -> e.getRole().equals(Role.STAFF))
                .forEach(e -> Accountant.payPremium(e));

        //Consumer Lambda Expression

        Consumer<Employee> consumer1 = x -> Accountant.paySalary(x);
        Consumer<Employee> consumer2 = x -> Accountant.payPremium(x);

        System.out.println("\n CONSUMER1 :: \n");
        consumer1.accept(list_employees.get(0));

        System.out.println("\n CONSUMER2 ::");
        consumer2.accept(list_employees.get(0));

        //Function Lambda Expression
        //Function<Employee,String> fullname = (e, )

        System.out.println("\n For the 1st employee :: \n");
        System.out.println(Name.fullname(list_employees.get(0)) + "\n");

        //Supplier Lambda Expression
        System.out.println("\n For the 1st employee supplier:: \n");
        display(() -> list_employees.get(0).toString());

        //BiPredicate Lambda Expression
        Employee e = list_employees.get(0);
        BiPredicate<Employee, Integer> bi = (x, y) -> x.getAge() > y;
        System.out.println("\n\nITS AGE IS " + e.getAge() + "  BiPredicate showed that  " + e.getAge() + " > 30 is  " + bi.test(e, 30));

        System.out.println("\n MAX  MIN ::");
        System.out.println("\n MAX_AGE_MALE_STAFF :: \n");
        System.out.println(Name.fullname(list_employees.stream()
                .filter(em -> em.getRole().equals(Role.STAFF))
                .filter(em -> em.getGender().equals(Gender.MALE))
                .max((e1, e2) -> e1.getAge().compareTo(e2.getAge())).get()));
        System.out.println("\n MIN_AGE_FEMALE_MANAGER :: \n");
        e = list_employees.stream()
                .filter(em -> em.getRole().equals(Role.MANAGER))
                .filter(em -> em.getGender().equals(Gender.FEMALE))
                .min((e1, e2) -> e1.getAge().compareTo(e2.getAge())).get();
        System.out.println(Name.fullname(e) + " " + e.getAge());
        System.out.println("\n MAX_ALPHABET_FROM_STATISTICS :: ");
        System.out.println(Name.fullname(list_employees.stream()
                .filter(em -> em.getDept().equals("Statistics"))
                .max((e1, e2) -> e1.getSurName().compareTo(e2.getSurName())).get()));
        System.out.println("\n MIN_ALPHABET_FROM_STATISTICS :: ");
        System.out.println(Name.fullname(list_employees.stream()
                .filter(em -> em.getDept().equals("Statistics"))
                .min((e1, e2) -> e1.getSurName().compareTo(e2.getSurName())).get()));
        System.out.println(" AVERAGE SUM::");
        System.out.println(" AVERAGE_FEMALE_SALARY :: ");
        System.out.println(list_employees.stream()
                .filter(em -> em.getGender().equals(Gender.FEMALE))
                .mapToInt(em -> em.getSalary())
                .average());
        System.out.println(" AVERAGE_MALE_SALARY :: ");
        System.out.println(list_employees.stream()
                .filter(em -> em.getGender().equals(Gender.MALE))
                .mapToInt(em -> em.getSalary())
                .average());
        System.out.println(" MANAGERS_YOUNG_VALUE :: ");
        System.out.println(list_employees.stream()
                .filter(em -> em.getAge() < 30)
                .mapToInt(em -> (1))
                .sum());
        System.out.println(" COUNT_PEOPLE_FROM_STATISTICS :: ");
        System.out.println(list_employees.stream()
                .filter(em -> em.getDept().equals("Statistics"))
                .mapToInt(em -> (1))
                .sum());
        System.out.println("\n FINDFIRST_FOR_STAFF :: ");
        System.out.println(Name.fullname(list_employees.stream()
                .filter(em -> em.getRole().equals(Role.STAFF))
                .findFirst().get()));
        System.out.println("\n MAP PEEK :: ");
        System.out.println("\n ROLE_AND_AGE_FOR_EACH_EMPLOYEE :: ");
        list_employees.stream()
                .filter(em -> em.getRole().equals(Role.MANAGER))
                .map(em -> (em.getAge() + " y.o. " + Name.fullname(em)))
                .forEach(em -> System.out.println(em));
        System.out.println("\n ALL_DEPTS :: ");
        list_employees.stream()
                .map(em -> em.getDept())
                .distinct()
                .forEach(em -> System.out.println(em));
        System.out.println("\n EXECUTIVE_FOR_EACH_DEPT :: ");
        list_employees.stream()
                .filter(em -> em.getRole().equals(Role.EXECUTIVE))
                .peek(em -> System.out.println(em.getDept() + "::"))
                .forEach(em -> System.out.println(em.getSurName() + " " + em.getGivenName() + "\n"));

    }
}