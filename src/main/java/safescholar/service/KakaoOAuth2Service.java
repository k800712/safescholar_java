package safescholar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import safescholar.dto.KakaoUserInfo;
import safescholar.model.User;
import safescholar.repository.UserRepository;

@Service
public class KakaoOAuth2Service extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String kakaoClientId;

    @Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
    private String kakaoClientSecret;

    @Autowired
    public KakaoOAuth2Service(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauth2User = super.loadUser(userRequest);

        KakaoUserInfo kakaoUserInfo = new KakaoUserInfo(oauth2User.getAttributes());

        User user = userRepository.findByKakaoId(kakaoUserInfo.getId())
                .orElseGet(() -> createKakaoUser(kakaoUserInfo));

        // Here you would typically return a custom OAuth2User implementation
        return oauth2User;
    }

    private User createKakaoUser(KakaoUserInfo kakaoUserInfo) {
        User user = new User();
        user.setKakaoId(kakaoUserInfo.getId());
        user.setUsername(kakaoUserInfo.getNickname());
        user.setEmail(kakaoUserInfo.getEmail());
        // Set a random password or handle it differently
        return userRepository.save(user);
    }


    public String getKakaoClientId() {
        return kakaoClientId;
    }

    public String getKakaoClientSecret() {
        return kakaoClientSecret;
    }

    public String getKakaoAuthorizationUri() {
        return "https://kauth.kakao.com/oauth/authorize";
    }

    public String getKakaoTokenUri() {
        return "https://kauth.kakao.com/oauth/token";
    }

    public String getKakaoUserInfoUri() {
        return "https://kapi.kakao.com/v2/user/me";
    }

    public String[] getKakaoScopes() {
        return new String[]{"profile_nickname", "account_email"};
    }
}
