package ua.realestate.management.service;

import ua.realestate.management.entity.Builder;
import ua.realestate.management.repository.BuilderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BuilderServices {

    private BuilderRepository builderRepository;

    public Builder create (Builder builder){
        return builderRepository.save(builder);
    }

    public List<Builder> findAll(){
        return (List<Builder>) builderRepository.findAll();
    }

    public Optional<Builder> findById(Integer id){
        return builderRepository.findById(id);
    }
    public Integer delete(Integer id){
        builderRepository.deleteById(id);
        return id;
    }
}
