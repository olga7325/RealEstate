package ua.realestate.management.service;

import ua.realestate.management.entity.Builder;
import ua.realestate.management.exception.ErrorMessage;
import ua.realestate.management.exception.exceptions.NotDeletedException;
import ua.realestate.management.repository.BuilderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuilderService {

    private final BuilderRepository builderRepository;
    public BuilderService(BuilderRepository builderRepository) {
        this.builderRepository = builderRepository;
    }

    public Builder create (Builder builder){
        return builderRepository.save(builder);
    }

    public Builder findById(Integer id){
        return builderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Builder with id " + id + "does not exist"));
    }

    public Builder findByEmail(String email){
        return builderRepository.findByEmail(email);
    }

    public List<Builder> findAll(){
        return (List<Builder>) builderRepository.findAll();
    }

    public Builder update(Builder builder){
        Builder updatedBuilder = builderRepository.findByEmail(builder.getEmail());
        updatedBuilder.setFirstName(builder.getFirstName());
        updatedBuilder.setLastName(builder.getLastName());
        updatedBuilder.setEmail(builder.getEmail());
        updatedBuilder.setBuilderSpecialties(builder.getBuilderSpecialties());
        return builderRepository.save(updatedBuilder);
    }

    public Integer delete(Integer id){
        if(!builderRepository.findById(id).isPresent()){
            throw new NotDeletedException(ErrorMessage.BUILDER_NOT_DELETED);
        }
        builderRepository.deleteById(id);
        return id;
    }
}
