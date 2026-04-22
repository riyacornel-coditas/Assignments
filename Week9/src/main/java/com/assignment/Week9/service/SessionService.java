package com.assignment.Week9.service;

import com.assignment.Week9.dto.SessionDto;
import com.assignment.Week9.entity.Conference;
import com.assignment.Week9.entity.Session;
import com.assignment.Week9.entity.User;
import com.assignment.Week9.repository.ConferenceRepository;
import com.assignment.Week9.repository.SessionRepository;
import com.assignment.Week9.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository repo;
    private final ConferenceRepository confRepo;
    private final UserRepository userRepo;

    public Session createSession(SessionDto dto) {

        Conference conf = confRepo.findById(dto.getConferenceId()).orElseThrow();
        User client = userRepo.findById(dto.getClientAdminId()).orElseThrow();

        Session session = new Session();
        session.setName(dto.getName());
        session.setConference(conf);
        session.setClientAdmin(client);

        return repo.save(session);
    }
}
