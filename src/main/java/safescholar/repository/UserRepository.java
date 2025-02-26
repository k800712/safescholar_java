package safescholar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import safescholar.model.User;

import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    /**
     * 카카오 사용자 정보를 기반으로 새로운 User 객체를 생성합니다.
     *
     * @param userInfo 카카오 API로부터 받은 사용자 정보
     * @return 생성된 User 객체
     */
    User createKakaoUser(Map<String, Object> userInfo);

    /**
     * 카카오 액세스 토큰을 사용하여 사용자를 등록합니다.
     *
     * @param accessToken 카카오 액세스 토큰
     * @return 등록된 User 객체
     */
    User registerKakaoUser(String accessToken);

    /**
     * 카카오 ID로 사용자를 조회합니다.
     *
     * @param kakaoId 카카오 ID
     * @return 조회된 User 객체 (Optional)
     */
    Optional<User> findByKakaoId(Long kakaoId);
}
