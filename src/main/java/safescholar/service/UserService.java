package safescholar.service;

import safescholar.model.User;
import safescholar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final String KAKAO_USER_INFO_URI = "https://kapi.kakao.com/v2/user/me";

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User registerKakaoUser(String accessToken) {
        // 카카오 API를 통해 사용자 정보 가져오기
        Map<String, Object> userInfo = getKakaoUserInfo(accessToken);

        // 카카오 ID를 이용해 사용자 조회 또는 생성
        Long kakaoId = (Long) userInfo.get("id");
        User user = userRepository.findByKakaoId(kakaoId)
                .orElseGet(() -> createKakaoUser(userInfo));

        return userRepository.save(user);
    }

    private Map<String, Object> getKakaoUserInfo(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                KAKAO_USER_INFO_URI,
                HttpMethod.GET,
                entity,
                Map.class
        );

        return response.getBody();
    }

    private User createKakaoUser(Map<String, Object> userInfo) {
        User user = new User();
        user.setKakaoId((Long) userInfo.get("id"));

        Map<String, Object> properties = (Map<String, Object>) userInfo.get("properties");
        Map<String, Object> kakaoAccount = (Map<String, Object>) userInfo.get("kakao_account");

        user.setUsername((String) properties.get("nickname"));
        user.setEmail((String) kakaoAccount.get("email"));
        // 필요한 추가 정보 설정

        return user;
    }

    // 기존의 registerUser 메소드는 유지
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
