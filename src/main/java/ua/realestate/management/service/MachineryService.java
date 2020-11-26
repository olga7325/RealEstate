package ua.realestate.management.service;

import ua.realestate.management.entity.Machinery;
import ua.realestate.management.exception.ErrorMessage;
import ua.realestate.management.exception.exceptions.NotDeletedException;
import ua.realestate.management.repository.MachineryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineryService {

    private final MachineryRepository machineryRepository;
    public MachineryService(MachineryRepository machineryRepository){
        this.machineryRepository = machineryRepository;
    }

    public Machinery create (Machinery machinery){
        return machineryRepository.save(machinery);
    }

    public Machinery findOne(Integer id){
        return machineryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Machine  with id " + id + "does not exist")));
    }

    public List<Machinery> findAll(){
        return (List<Machinery>) machineryRepository.findAll();
    }

    public Machinery update(Machinery machine){
        Machinery updatedMachine = findOne(machine.getId());
        updatedMachine.setProducer(machine.getProducer());
        updatedMachine.setType(machine.getType());
        updatedMachine.setReleaseDate(machine.getReleaseDate());
        return machineryRepository.save(updatedMachine);
    }

    public Integer delete(Integer id){
        if(!machineryRepository.findById(id).isPresent()){
            throw new NotDeletedException(ErrorMessage.MACHINE_NOT_DELETED);
        }
        machineryRepository.deleteById(id);
        return id;
    }
}
