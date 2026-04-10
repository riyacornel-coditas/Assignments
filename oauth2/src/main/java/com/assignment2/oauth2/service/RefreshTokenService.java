package com.assignment2.oauth2.service;

import com.assignment2.oauth2.entity.RefreshToken;
import com.assignment2.oauth2.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.refreshDuration}")
    private Long refreshDuration;

    public RefreshToken createToken(Long userId)
    {
        RefreshToken token = new RefreshToken();
        token.setUserId(userId);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(Instant.now().plusMillis(refreshDuration));

        return refreshTokenRepository.save(token);

    }

    public RefreshToken verify(String token)
    {
        RefreshToken rt = refreshTokenRepository.findByToken(token)
                .orElseThrow(()-> new RuntimeException("Invalid token"));

        if(rt.getExpiryDate().isBefore(Instant.now()))
        {
            refreshTokenRepository.delete(rt);
            throw new RuntimeException("Token expired");
        }

        return rt;
    }

    public void delete(String token)
    {
        refreshTokenRepository.deleteByToken(token);
    }

}
