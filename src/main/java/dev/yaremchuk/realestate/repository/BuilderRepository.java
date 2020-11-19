package dev.yaremchuk.realestate.repository;

import dev.yaremchuk.realestate.entity.Builder;
import dev.yaremchuk.realestate.entity.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuilderRepository extends CrudRepository<Builder, Integer> {
}
