package xulep.co.frutologiaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xulep.co.frutologiaapi.DTOs.frut.CreateFrutDTO;
import xulep.co.frutologiaapi.DTOs.frut.UpdateFrutDTO;
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
        frut.setFamily(data.getFamily());
        frut.setOrder(data.getOrder());
        frut.setGenus(data.getGenus());

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
    public Frut update(Long id, UpdateFrutDTO data){
        Frut frut = repository.findById(id).get();

        if(data.getName() != null){
            frut.setName(data.getName());
        }

        if(data.getFamily() != null){
            frut.setFamily(data.getFamily());
        }

        if(data.getOrder() != null){
            frut.setOrder(data.getOrder());
        }
        if(data.getGenus() != null){
            frut.setGenus(data.getGenus());
        }
//        if(data.getCalories() != null && !Objects.equals(data.getCalories(), frut.getCalories())){
//            frut.setCalories(data.getCalories());
//        }



        repository.save(frut);
        return frut;
    }

    //DELETE
    public void delete(Long id){
        repository.deleteById(id);
    }

}
