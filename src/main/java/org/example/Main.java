package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Session session = DbConnection.getSession();
        session.get(Employee.class, 1L);
        session.close();
    }
}