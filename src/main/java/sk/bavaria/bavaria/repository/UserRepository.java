package sk.bavaria.bavaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.bavaria.bavaria.model.User;

/**
 * Created by martin.cuchran on 12/14/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
