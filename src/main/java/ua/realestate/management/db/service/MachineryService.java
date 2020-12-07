package ua.realestate.management.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import ua.realestate.management.entity.MachineryEntity;
import ua.realestate.management.exception.ErrorMessage;
import ua.realestate.management.exception.exceptions.NotDeletedException;
import ua.realestate.management.repository.MachineryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineryService {

    private final MachineryRepository machineryRepository;

    @Autowired
    public MachineryService(MachineryRepository machineryRepository){
        this.machineryRepository = machineryRepository;
    }

    public MachineryEntity create (MachineryEntity machineryEntity){ return machineryRepository.save(machineryEntity); }

    public MachineryEntity findOne(Integer id){
        return machineryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Machine  with id " + id + "does not exist")));
    }

    public List<MachineryEntity> findAll(){
        return (List<MachineryEntity>) machineryRepository.findAll();
    }

    public MachineryEntity update(MachineryEntity machine){
        MachineryEntity updatedMachine = findOne(machine.getId());
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
