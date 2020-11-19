package dev.yaremchuk.realestate.service;

import dev.yaremchuk.realestate.entity.Machinery;
import dev.yaremchuk.realestate.repository.MachineryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class MachineryService {

    private MachineryRepository machineryRepository;

    public void save(Machinery machinery){
        machineryRepository.save(machinery);
    }

    public Optional<Machinery> findById(Integer id){
        return machineryRepository.findById(id);
    }
}
