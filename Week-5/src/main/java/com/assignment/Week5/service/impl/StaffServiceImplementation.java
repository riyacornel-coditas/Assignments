package com.assignment.Week5.service.impl;

import com.assignment.Week5.dto.AddStaffDto;
import com.assignment.Week5.dto.StaffDto;
import com.assignment.Week5.entity.Staff;
import com.assignment.Week5.repository.StaffRepository;
import com.assignment.Week5.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StaffServiceImplementation implements StaffService {

    private final StaffRepository staffRepository;
    private final ModelMapper modelMapper;

    @Override
    public String getStaffName() {
        Staff staff = staffRepository.findMinExperience();
        return staff.getName();
    }

    @Override
    public List<StaffDto> getAllStaff()
    {
        List<Staff> staffList = staffRepository.findAll();
        List<StaffDto> staffDtoList = staffList.stream()
                .map(staff -> new StaffDto(staff.getId() ,staff.getName(), staff.getProfile(), staff.getSalary(), staff.getExperience()))
                .toList();

        return staffDtoList;
    }

    @Override
    public StaffDto getStaffById(Integer id) {
        Staff staff = staffRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Id not found"));
        return modelMapper.map(staff,StaffDto.class);
    }

    @Override
    public StaffDto createNewStaff(AddStaffDto addStaffDto) {
       Staff newstaff = modelMapper.map(addStaffDto, Staff.class);
       Staff staff = staffRepository.save(newstaff);
       return modelMapper.map(staff, StaffDto.class);
    }

    @Override
    public List<StaffDto> getBySalaryHigherThan(Integer salary) {
        List<Staff> staffList = staffRepository.findBySalaryGreaterThan(salary);
        List<StaffDto> staffDtoList = staffList.stream()
                .map(staff -> new StaffDto(staff.getId() ,staff.getName(), staff.getProfile(), staff.getSalary(), staff.getExperience()))
                .toList();

        return staffDtoList;
    }

    @Override
    public List<StaffDto> getByExperienceBetween(Integer start, Integer end) {
        List<Staff> staffList = staffRepository.findByExperienceBetween(start, end);
        List<StaffDto> staffDtoList = staffList.stream()
                .map(staff -> new StaffDto(staff.getId() ,staff.getName(), staff.getProfile(), staff.getSalary(), staff.getExperience()))
                .toList();

        return staffDtoList;
    }

    @Override
    public StaffDto getMaxSalary() {
        Staff staff = staffRepository.findMaxSalary();
        return modelMapper.map(staff, StaffDto.class);
    }

    @Override
    public StaffDto updatePartialStaff(Integer id, Map<String, Object> updates) {
        Staff staff= staffRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Staff not found by:"+id));

        updates.forEach((field, value) -> {
                    switch(field){
                        case "salary":staff.setSalary((Integer) value);
                            break;
                        default: throw new IllegalArgumentException("Student not found");
                    }
                }
        );

        Staff savedStaff= staffRepository.save(staff);
        return modelMapper.map(savedStaff, StaffDto.class);

    }

    @Override
    public List<StaffDto> getListTrainer() {
        List<Staff> staffList = staffRepository.findTrainer();
        List<StaffDto> staffDtoList = staffList.stream()
                .map(staff -> new StaffDto(staff.getId() ,staff.getName(), staff.getProfile(), staff.getSalary(), staff.getExperience()))
                .toList();

        return staffDtoList;
    }

    @Override
    public List<StaffDto> getListNotTrainer() {
        List<Staff> staffList = staffRepository.findNotTrainer();
        List<StaffDto> staffDtoList = staffList.stream()
                .map(staff -> new StaffDto(staff.getId() ,staff.getName(), staff.getProfile(), staff.getSalary(), staff.getExperience()))
                .toList();

        return staffDtoList;
    }
}
