package ua.realestate.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.realestate.management.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    User findByName(String name);

}
