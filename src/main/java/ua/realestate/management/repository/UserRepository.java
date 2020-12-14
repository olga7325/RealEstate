package ua.realestate.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.realestate.management.entity.UserEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);

    UserEntity findByName(String name);

}
