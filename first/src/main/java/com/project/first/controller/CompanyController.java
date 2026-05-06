package com.project.first.controller;

import com.project.first.entity.Company;
import com.project.first.requestdto.CompanyDto;
import com.project.first.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/add")
    public String addCompany(@RequestBody CompanyDto companyDto)
    {
        companyService.addCompany(companyDto);
        return "Company added successfully";
    }

    @PostMapping("/remove/{id}")
    public String removeCompany(@PathVariable Long id)
    {
        companyService.removeCompany(id);
        return "Company has been removed from the services";
    }

    @GetMapping("/get/all")
    public CompanyDto getAll()
    {
        return companyService.getAll();
    }

    @GetMapping("/get/by/id/{id}")
    public Company get(@PathVariable Long id)
    {
        return companyService.get(id);
    }


}
