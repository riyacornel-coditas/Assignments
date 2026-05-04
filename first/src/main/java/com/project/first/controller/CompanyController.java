package com.project.first.controller;

import com.project.first.requestdto.CompanyDto;
import com.project.first.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
