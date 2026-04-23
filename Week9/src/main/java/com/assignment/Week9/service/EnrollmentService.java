package com.assignment.Week9.service;

import com.assignment.Week9.dto.EnrollmentDto;
import com.assignment.Week9.entity.Conference;
import com.assignment.Week9.entity.Enrollment;
import com.assignment.Week9.entity.User;
import com.assignment.Week9.repository.ConferenceRepository;
import com.assignment.Week9.repository.EnrollmentRepository;
import com.assignment.Week9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository repo;
    private final UserRepository userRepo;
    private final ConferenceRepository confRepo;

    public void enroll(EnrollmentDto dto) {

        User candidate = userRepo.findById(dto.getCandidateId()).orElseThrow();
        Conference conf = confRepo.findById(dto.getConferenceId()).orElseThrow();

        Enrollment enrollment = new Enrollment();
        enrollment.setCandidate(candidate);
        enrollment.setConference(conf);

        repo.save(enrollment);
    }
}
