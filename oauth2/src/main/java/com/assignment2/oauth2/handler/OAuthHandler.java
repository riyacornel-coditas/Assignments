package com.assignment2.oauth2.handler;

import com.assignment2.oauth2.entity.RefreshToken;
import com.assignment2.oauth2.entity.User;
import com.assignment2.oauth2.repository.UserRepository;
import com.assignment2.oauth2.service.RefreshTokenService;
import com.assignment2.oauth2.utility.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuthHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final RefreshTokenService refreshTokenService;

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException
    {
        OAuth2User user = (OAuth2User) authentication.getPrincipal();

        String email = user.getAttribute("email");
        String name = user.getAttribute("name");

        User dbUser = userRepository.findByEmail(email)
                .orElseGet(()->{
                    User u = new User();
                    u.setEmail(email);
                    u.setName(name);
                    return userRepository.save(u);
                });

        String accessToken = jwtUtil.generateToken(dbUser.getId());
        RefreshToken refreshToken = refreshTokenService.createToken(dbUser.getId());

        response.setContentType("application/json");

        String json = String.format("""
                {
                "accessToken":"%s",
                "refreshToken":"%s",
                "tokenType":"Bearer",
                "expiresIn":900
                }""" , accessToken, refreshToken.getToken()
        );

        response.getWriter().write(json);


    }
}
