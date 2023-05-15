package WONshotApp.WONshot.repository;

import WONshotApp.WONshot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsUserById(String id);
    List<User> findByEmail(String email);
}