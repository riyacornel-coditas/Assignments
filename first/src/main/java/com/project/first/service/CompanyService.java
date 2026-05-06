package com.project.first.service;

import com.project.first.entity.Company;
import com.project.first.entity.Course;
import com.project.first.enums.CompanyStatus;
import com.project.first.repository.CompanyRepository;
import com.project.first.requestdto.CompanyDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Transactional
    public void addCompany(List<CompanyDto> companyDtos)
    {
        List<Company> companies = new ArrayList<>();

        for(CompanyDto c : companyDtos)
        {
            Company company = new Company();
            company.setName(c.getName());
            company.setType(c.getType());
            company.setCompanyStatus(CompanyStatus.ACTIVE);

            companies.add(company);

        }
        companyRepository.saveAll(companies);

//        Company c = new Company();
//        c.setName(companyDto.getName());
//        c.setType(companyDto.getType());
//        c.setCompanyStatus(CompanyStatus.ACTIVE);
//        companyRepository.save(c);
    }

    public void removeCompany(Long id) {

        Company c = companyRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Company not found"));

        c.setCompanyStatus(CompanyStatus.INACTIVE);
        companyRepository.save(c);
    }


    public List<CompanyDto> getAll() {
    List<Company> companies = companyRepository.findAll();

    List<CompanyDto> dtos = new ArrayList<>();

    for(Company c: companies) {
        CompanyDto dto = new CompanyDto();
        dto.setName(c.getName());
        dto.setType(c.getType());

        dtos.add(dto);
    }
    return dtos;
    }


    public Company get(Long id) {
        Company c = companyRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Company not found"));

        return c;
    }
}
