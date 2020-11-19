package dev.yaremchuk.realestate.repository;

import dev.yaremchuk.realestate.entity.Building;
import dev.yaremchuk.realestate.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Optional <User> findById(Integer id);

}
