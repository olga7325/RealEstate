package dev.yaremchuk.realestate.repository;

import dev.yaremchuk.realestate.entity.Machinery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineryRepository extends CrudRepository<Machinery, Integer> {
}
