package safescholar.dto;

import java.util.Map;

public class KakaoUserInfo {
    private Long id;
    private String nickname;
    private String email;

    public KakaoUserInfo(Map<String, Object> attributes) {
        this.id = (Long) attributes.get("id");
        Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        this.nickname = (String) properties.get("nickname");
        this.email = (String) kakaoAccount.get("email");
    }



    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }
}
