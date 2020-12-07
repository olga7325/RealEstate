package ua.realestate.management.db.service;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import ua.realestate.management.entity.BuilderEntity;
import ua.realestate.management.exception.ErrorMessage;
import ua.realestate.management.exception.exceptions.NotDeletedException;
import ua.realestate.management.repository.BuilderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuilderService {

    private final BuilderRepository builderRepository;

    @Autowired
    public BuilderService(BuilderRepository builderRepository) {
        this.builderRepository = builderRepository;
    }

    public BuilderEntity create (BuilderEntity builderEntity){
        return builderRepository.save(builderEntity);
    }

    @Cacheable(value = "builderCache", key = "#id")
    public BuilderEntity findById(Integer id){
        return builderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Builder with id " + id + "does not exist"));
    }

    public BuilderEntity findByEmail(String email){
        return builderRepository.findByEmail(email);
    }

    public List<BuilderEntity> findAll(){
        return (List<BuilderEntity>) builderRepository.findAll();
    }

    public BuilderEntity update(BuilderEntity builderEntity){
        BuilderEntity updatedBuilderEntity = builderRepository.findByEmail(builderEntity.getEmail());
        updatedBuilderEntity.setFirstName(builderEntity.getFirstName());
        updatedBuilderEntity.setLastName(builderEntity.getLastName());
        updatedBuilderEntity.setEmail(builderEntity.getEmail());
        updatedBuilderEntity.setBuilderSpecialties(builderEntity.getBuilderSpecialties());
        return builderRepository.save(updatedBuilderEntity);
    }

    public Integer delete(Integer id){
        if(!builderRepository.findById(id).isPresent()){
            throw new NotDeletedException(ErrorMessage.BUILDER_NOT_DELETED);
        }
        builderRepository.deleteById(id);
        return id;
    }
}
