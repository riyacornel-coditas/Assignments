package com.project.first.controller;

import com.project.first.entity.Company;
import com.project.first.requestdto.CompanyDto;
import com.project.first.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

//    @PostMapping("/add")
//    public String addCompany(@RequestBody List<CompanyDto> companyDtos)
//    {
//        companyService.addCompany(companyDtos);
//        return "Company added successfully";
//    }

    @DeleteMapping("/{companyId}")
    public String inactivateCompany(@PathVariable Long companyId)
    {
        companyService.inactivateCompany(companyId);
        return "Company has been removed from the services";
    }

    @GetMapping
    public List<CompanyDto> getAllCompanies()
    {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{companyId}")
    public Company getCompanyById(@PathVariable Long companyId)
    {
        return companyService.getCompanyById(companyId);
    }


}
