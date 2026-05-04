package com.project.first.service;

import com.project.first.entity.Company;
import com.project.first.repository.CompanyRepository;
import com.project.first.requestdto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public void addCompany(CompanyDto companyDto)
    {
        Company c = new Company();
        c.setName(companyDto.getName());
        c.setType(companyDto.getType());
        companyRepository.save(c);
    }
}
