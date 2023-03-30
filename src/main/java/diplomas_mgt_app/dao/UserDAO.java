package diplomas_mgt_app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import diplomas_mgt_app.model.User;

public interface UserDAO extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
