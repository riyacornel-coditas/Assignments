package com.assignment.Week5.service;

import com.assignment.Week5.dto.AddStaffDto;
import com.assignment.Week5.dto.StaffDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface StaffService {

    String getStaffName();

    List<StaffDto> getAllStaff();

    StaffDto getStaffById(Integer id);

    StaffDto createNewStaff(AddStaffDto addStaffDto);

    List<StaffDto> getBySalaryHigherThan(Integer id);

    List<StaffDto> getByExperienceBetween(Integer start, Integer end);

    StaffDto getMaxSalary();



    StaffDto updatePartialStaff(Integer id, Map<String, Object> updates);

    List<StaffDto> getListTrainer();

    List<StaffDto> getListNotTrainer();
}
