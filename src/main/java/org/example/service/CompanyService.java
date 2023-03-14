package org.example.service;

import org.example.dto.CompanyDto;
import org.example.entity.Company;
import org.example.repository.CompanyRepository;

public class CompanyService {

    private static final CompanyRepository companyRepository = new CompanyRepository();

    public void addCompany(String companyName) {
        if (companyName != null && companyName.length() > 2) {
            Company company = new Company();
            company.setName(companyName);
            companyRepository.insert(company);
        } else {
            throw new IllegalArgumentException("Company name can not be empty or length can not be less than 3");
        }
    }

    public CompanyDto getByName(String companyName) {
        if (companyName != null && companyName.length() > 2) {
            Company company = companyRepository.findByName(companyName);
            if (company != null) {
                CompanyDto companyDto = new CompanyDto(company.getId(), company.getName());
                return companyDto;
            } else {
                throw new IllegalArgumentException("Company with name " + companyName + " not exists");
            }

        } else {
            throw new IllegalArgumentException("Company name can not be empty or length can not be less than 3");
        }
    }
}
