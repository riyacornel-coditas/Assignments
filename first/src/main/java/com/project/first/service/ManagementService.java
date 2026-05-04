package com.project.first.service;

import com.project.first.entity.Management;
import com.project.first.repository.ManagementRepository;
import com.project.first.requestdto.ManagementDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagementService {

    private final ManagementRepository managementRepository;

    public void createManagement(ManagementDto managementDto)
    {
        Management m = new Management();
        m.setName(managementDto.getName());
        m.setPassword(managementDto.getPassword());
        managementRepository.save(m);
    }


}
