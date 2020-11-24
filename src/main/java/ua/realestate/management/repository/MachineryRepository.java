package ua.realestate.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.realestate.management.entity.Machinery;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineryRepository extends JpaRepository<Machinery, Integer> {
}
