package generic.wildcard.important;

import java.util.ArrayList;

public class WildcardExample {
    static class Employee {
    }

    static class Accountant extends Employee {
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        Accountant accountant = new Accountant();
        employee = accountant; //Valid as extended class


        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Accountant> accountants = new ArrayList<>();
//        employees = accountants;     //Not possible

        ArrayList<?> employees2 = new ArrayList<>();
        ArrayList<Accountant> accountants2 = new ArrayList<>();
        employees2 = accountants2; //Valid
        ArrayList<String> stringArrayList = new ArrayList<>();
        employees2 = stringArrayList; //This is valid as well, but we don't want this

        //upper bound
        ArrayList<? extends Employee> employees3 = new ArrayList<>();
        ArrayList<Accountant> accountants3 = new ArrayList<>();
        employees3 = accountants3; //Valid as well

        //lower bound
        ArrayList<? super Employee> employees4 = new ArrayList<>();
        ArrayList<Accountant> accountants4 = new ArrayList<>();
//        employees4 = accountants4; //Not allowed Invalid
        ArrayList<Object> objects = new ArrayList<>();
        employees4 = objects;  //Valid


    }
}


