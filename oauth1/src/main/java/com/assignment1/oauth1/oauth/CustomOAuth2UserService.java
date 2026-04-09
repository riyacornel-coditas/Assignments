package com.assignment1.oauth1.oauth;

import com.assignment1.oauth1.entity.User;
import com.assignment1.oauth1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public OAuth2User loadUser(OAuth2UserRequest request)
    {
        OAuth2User oAuth2User = super.loadUser(request);

        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email = (String) attributes.get("email");

        String name = (String) attributes.get("name");

        if(email == null)
        {
            throw new RuntimeException("Email not found from OAuth2");
        }

        userRepository.findByEmail(email)
                .orElseGet(()->{
                    User newUser = User.builder()
                            .email(email)
                            .username(name)
                            .build();
                    return userRepository.save(newUser);
                        }
                        );

        return oAuth2User;
    }

}
