package dev.yaremchuk.realestate.service;

import dev.yaremchuk.realestate.entity.Builder;
import dev.yaremchuk.realestate.entity.Machinery;
import dev.yaremchuk.realestate.repository.MachineryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MachineryService {

    private MachineryRepository machineryRepository;

    public Machinery create (Machinery machinery){
        return machineryRepository.save(machinery);
    }

    public List<Machinery> findAll(){
        return (List<Machinery>) machineryRepository.findAll();
    }

    public Optional<Machinery> findById(Integer id){
        return machineryRepository.findById(id);
    }

    public Integer delete(Integer id){
        machineryRepository.deleteById(id);
        return id;
    }
}
