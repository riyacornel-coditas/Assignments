package com.assignment.Week9.service;

import com.assignment.Week9.dto.ConferenceDto;
import com.assignment.Week9.entity.Conference;
import com.assignment.Week9.entity.User;
import com.assignment.Week9.repository.ConferenceRepository;
import com.assignment.Week9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConferenceService {
    private final ConferenceRepository repo;
    private final UserRepository userRepo;

    public Conference createConference(ConferenceDto dto) {
        User admin = userRepo.findById(dto.getAdminId()).orElseThrow();

        Conference conf = new Conference();
        conf.setTitle(dto.getTitle());
        conf.setType(dto.getType());
        conf.setAdmin(admin);

        return repo.save(conf);
    }
}
