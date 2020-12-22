package ua.realestate.management.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.realestate.management.db.service.BuilderService;
import ua.realestate.management.dto.BuilderDTO;
import ua.realestate.management.entity.BuilderEntity;
import ua.realestate.management.mapper.BuilderMapper;
import ua.realestate.management.repository.BuilderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Controller
@CrossOrigin
@RequestMapping("/builders")
public class BuilderController {

    @Autowired
    private BuilderRepository builderRepository;

    private BuilderService builderService;
    private BuilderMapper mapper;

    @ApiOperation(value = "Create new builder ")
    @PostMapping
    public BuilderDTO create(@RequestBody BuilderDTO dto){
        BuilderEntity builderEntity = mapper.toEntity(dto);
        BuilderEntity builderCreated = builderService.create(builderEntity);
        return mapper.toDto(builderCreated);
    }

    @ApiOperation(value = "List of all builders ")
    @GetMapping
    public List<BuilderDTO> findAll(){
        List<BuilderEntity> allBuilders = builderService.findAll();
        return allBuilders.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @ApiOperation(value = "Update builder ")
    @PutMapping
    public BuilderDTO update(@RequestBody BuilderDTO dto){
        BuilderEntity builderEntity = mapper.toEntity(dto);
        BuilderEntity builderUpdated = builderService.update(builderEntity);
        return mapper.toDto(builderUpdated);
    }

    @ApiOperation(value = "Delete builder by id ")
    @DeleteMapping
    public void delete(@RequestBody Integer id){
        builderService.delete(id);
    }
//    @GetMapping
//    public String builders(Map<String, Object> model){
//        Iterable<BuilderEntity> builders = builderRepository.findAll();
//
//        model.put("builders", builders);
//
//        return "builder";
//    }
}
