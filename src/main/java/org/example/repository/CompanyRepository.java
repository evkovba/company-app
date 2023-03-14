package org.example.repository;

import org.example.DbConnection;
import org.example.entity.Company;
import org.hibernate.Session;

public class CompanyRepository {

    public void insert(Company company) {
        Session session = DbConnection.getSession();
        session.getTransaction().begin();
        session.persist(company);
        session.getTransaction().commit();
        session.close();
    }

    public Company findByName(String companyName) {
        Session session = DbConnection.getSession();
        Company company = session.createQuery("select c from Company c where c.name=:companyName", Company.class).setParameter("companyName", companyName).uniqueResult();
        session.close();
        return company;
    }
}
