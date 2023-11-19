package xulep.co.frutologiaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xulep.co.frutologiaapi.DTOs.Frut.CreateFrutDTO;
import xulep.co.frutologiaapi.DTOs.Frut.UpdateFrutDTO;
import xulep.co.frutologiaapi.entity.Frut;
import xulep.co.frutologiaapi.repository.FrutRepository;

import java.util.List;

@Service
public class FrutService {

    @Autowired
    private FrutRepository repository;

    //CREATE
    public Frut create(CreateFrutDTO data){
        Frut frut = new Frut();
        frut.setName(data.getName());

        repository.save(frut);
        return frut;
    }

    //READ
    public List<Frut> findAll(){
        return repository.findAll();
    }

    public Frut findOne(Long id){
        Frut frut = repository.findById(id).get();
        return frut;
    }

    //UPDATE
    public Frut update(UpdateFrutDTO data){
        var frut = repository.getReferenceById(data.getId());

        if(data.getName() != null){
            frut.setName(data.getName());
        }
        return frut;
    }

    //DELETE
    public void delete(Long id){
        repository.deleteById(id);
    }

}
