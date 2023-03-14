package org.example;

import java.util.Scanner;

import org.example.dto.CompanyDto;
import org.example.entity.Employee;
import org.example.service.CompanyService;
import org.hibernate.Session;

public class Main {
    private static final CompanyService companyService = new CompanyService();

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Session session = DbConnection.getSession();
        session.get(Employee.class, 1L);
        session.close();

        Scanner in = new Scanner(System.in);
        while (true) {

            System.out.println("Select operation");
            System.out.println("1 - Add company");
            System.out.println("2 - Find company by name");

            int decision = in.nextInt();
            switch (decision) {
                case 0 -> {
                    DbConnection.closeSessionFactory();
                    System.exit(0);
                }
                case 1 -> {
                    try {
                        System.out.println("Type company name");
                        in.nextLine();
                        String companyName = in.nextLine();
                        companyService.addCompany(companyName);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Type company name");
                    in.nextLine();
                    String companyName = in.nextLine();
                    try {
                        CompanyDto companyDto = companyService.getByName(companyName);
                        System.out.println(companyDto.toString());
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }

    }
}