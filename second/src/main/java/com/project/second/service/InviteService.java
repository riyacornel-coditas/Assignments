package com.project.second.service;

import com.project.second.entity.Invitation;
import com.project.second.exception.InvalidInvitationException;
import com.project.second.exception.InvitationSendException;
import com.project.second.repository.InvitationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InviteService {
    private final InvitationRepository invitationRepo;

    private final JavaMailSender mailSender;

    public String sendInvite(String email, String restaurantName) {
        if (email == null) {
            throw new InvalidInvitationException("Email cannot be empty");
        }

        if (!email.contains("@")) {
            throw new InvalidInvitationException("Invalid email format");
        }

        if (restaurantName == null) {
            throw new InvalidInvitationException("Restaurant name is required");
        }

        try {
            String token = UUID.randomUUID().toString();

            Invitation invitation = new Invitation();

            invitation.setEmail(email);
            invitation.setRestaurant_name(restaurantName);
            invitation.setToken(token);
            invitation.setAccepted(false);
            invitation.setCreated_at(LocalDateTime.now());

            invitationRepo.save(invitation);

            String link = "http://localhost:8080/owner/register?token=" + token;

            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(email);

            message.setSubject("Restaurant Invitation");

            message.setText("Click below link to register:\n" + link);

            mailSender.send(message);

            return "Invitation sent successfully";
        }
        catch(MailException e)
        {
            throw new InvitationSendException("failed to send the invitation email");
        }
        catch(Exception e)
        {
            throw new InvitationSendException("failed to process the invitation");
        }
    }
}