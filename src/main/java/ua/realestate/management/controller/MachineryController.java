package ua.realestate.management.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.realestate.management.db.service.MachineryService;
import ua.realestate.management.dto.MachineryDTO;
import ua.realestate.management.entity.MachineryEntity;
import ua.realestate.management.mapper.MachineryMapper;
import ua.realestate.management.repository.MachineryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Controller
@CrossOrigin
@RequestMapping("/machinery")
public class MachineryController {

    @Autowired
    private MachineryRepository machineryRepository;

    private MachineryService machineryService;
    private MachineryMapper mapper;

    @ApiOperation(value = "Create new machine")
    @PostMapping
    public MachineryDTO create(@RequestBody MachineryDTO dto){
        MachineryEntity machineryEntity = mapper.toEntity(dto);
        MachineryEntity machineryCreated = machineryService.create(machineryEntity);
        return mapper.toDto(machineryCreated);
    }

    @ApiOperation(value = "List of all machines")
    @GetMapping
    public List<MachineryDTO> findAll(){
        List<MachineryEntity> allMachinery = machineryService.findAll();
        return allMachinery.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @ApiOperation(value = "Update machine")
    @PutMapping
    public MachineryDTO update(@RequestBody MachineryDTO dto){
        MachineryEntity machineryEntity = mapper.toEntity(dto);
        MachineryEntity machineUpdated = machineryService.update(machineryEntity);
        return mapper.toDto(machineUpdated);
    }

    @ApiOperation(value = "Delete machibe by id")
    @DeleteMapping
    public void delete(@RequestBody Integer id){
        machineryService.delete(id);
    }

//    @GetMapping
//    public String machinery(Map<String, Object> model){
//        Iterable<MachineryEntity> machinery = machineryRepository.findAll();
//
//        model.put("machinery", machinery);
//
//        return "machinery";
//    }
}
