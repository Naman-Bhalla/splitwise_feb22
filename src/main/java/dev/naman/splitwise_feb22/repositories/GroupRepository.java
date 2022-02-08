package dev.naman.splitwise_feb22.repositories;

import dev.naman.splitwise_feb22.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Override
    Optional<Group> findById(Long id);
}

// find if the user belongs to the group