package com.assignment.Week9.service;

import com.assignment.Week9.entity.Attendance;
import com.assignment.Week9.repository.AttendanceRepository;
import com.assignment.Week9.repository.SessionRepository;
import com.assignment.Week9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository repo;
    private final UserRepository userRepo;
    private final SessionRepository sessionRepo;

    public String markAttendance(String qrData) {

        String[] parts = qrData.split(":");

        Long candidateId = Long.parseLong(parts[0]);
        Long sessionId = Long.parseLong(parts[1]);

        Attendance a = new Attendance();
        a.setCandidate(userRepo.findById(candidateId).orElseThrow());
        a.setSession(sessionRepo.findById(sessionId).orElseThrow());
        a.setPresent(true);

        repo.save(a);

        return "Attendance Marked";
    }
}
