package ua.realestate.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.realestate.management.entity.BuilderEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface BuilderRepository extends JpaRepository<BuilderEntity, Integer> {
    BuilderEntity findByEmail(String email);

}
