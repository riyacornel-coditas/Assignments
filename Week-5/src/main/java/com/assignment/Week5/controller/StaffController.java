package com.assignment.Week5.controller;

import com.assignment.Week5.dto.AddStaffDto;
import com.assignment.Week5.dto.StaffDto;
import com.assignment.Week5.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @GetMapping
    public List<StaffDto> getAllStaff()
    {
         return staffService.getAllStaff();

    }

    @GetMapping("/{id}")
    public StaffDto getStaffById(@PathVariable Integer id)
    {
        return staffService.getStaffById(id);
    }

    @PostMapping
    public ResponseEntity<StaffDto> createNewStaff(@RequestBody AddStaffDto addStaffDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(staffService.createNewStaff(addStaffDto));
    }

    @GetMapping("/salary/{salary}")
    public List<StaffDto> getBySalaryHigherThan(@PathVariable Integer salary)
    {
        return staffService.getBySalaryHigherThan(salary);
    }

    @GetMapping("/experience")
    public List<StaffDto> getByExperienceBetween(@RequestParam Integer start, @RequestParam Integer end)
    {
        return staffService.getByExperienceBetween(start, end);
    }

    @GetMapping("/maxsalary")
    public StaffDto getMaxSalary()
    {
        return staffService.getMaxSalary();
    }

    @PatchMapping("/{id}")
    public StaffDto updatePartialStaff(@PathVariable Integer id,
                                           @RequestBody Map<String,Object> updates)
    {
        return ResponseEntity.ok(staffService.updatePartialStaff(id,updates)).getBody();
    }

    @GetMapping("/staffname")
    public String getStaffName()
    {
        return staffService.getStaffName();
    }

    @GetMapping("/trainer")
    public List<StaffDto> getListTrainer()
    {
        return staffService.getListTrainer();
    }

    @GetMapping("/nottrainer")
    public List<StaffDto> getListNotTrainer()
    {
        return staffService.getListNotTrainer();
    }



}
