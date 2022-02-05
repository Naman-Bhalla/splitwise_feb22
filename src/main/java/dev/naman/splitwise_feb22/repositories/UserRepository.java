package dev.naman.splitwise_feb22.repositories;

import dev.naman.splitwise_feb22.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> findById(Long id);
// select * from users where name == ""
//    order by name asc;

}
