package dev.yaremchuk.realestate.service;

import dev.yaremchuk.realestate.entity.Builder;
import dev.yaremchuk.realestate.repository.BuilderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BuilderServices {

    private BuilderRepository builderRepository;

    public void save(Builder builder){
        builderRepository.save(builder);
    }

    public Optional<Builder> findById(Integer id){
        return builderRepository.findById(id);
    }
}
