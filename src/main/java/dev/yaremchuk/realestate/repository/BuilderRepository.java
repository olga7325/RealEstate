package dev.yaremchuk.realestate.repository;

import dev.yaremchuk.realestate.entity.Builder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuilderRepository extends CrudRepository<Builder, Integer> {
}
