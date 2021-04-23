package com.ifmo.jjd.homework13.employee;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(20);
        // Дописать метод employeeGenerator и
        // отсортировать его по:
        // имени
        // имени и зарплате
        // имени, зарплате, возрасту и компании
        System.out.println(employees);
        Comparator<Employee> comparator1 = new Employee.NameComparator();
        TreeSet<Employee> treeSet = new TreeSet<>(comparator1);
        treeSet.addAll(employees);
        System.out.println(treeSet);
        //
        comparator1 = new Employee.NameComparator()
                .thenComparing(new Employee.SalaryComparator());
        treeSet = new TreeSet<>(comparator1);
        treeSet.addAll(employees);
        System.out.println(treeSet);
        //
        comparator1 = new Employee.NameComparator()
                .thenComparing(new Employee.SalaryComparator())
                .thenComparing(new Employee.AgeComparator())
                .thenComparing(new Employee.CompanyComparator());
        treeSet = new TreeSet<>(comparator1);
        treeSet.addAll(employees);
        System.out.println(treeSet);
    }
}