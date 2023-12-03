package xulep.co.frutologiaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xulep.co.frutologiaapi.DTOs.frutDetails.CreateFrutDetailsDTO;
import xulep.co.frutologiaapi.DTOs.frutDetails.UpdateFrutDetailsDTO;
import xulep.co.frutologiaapi.entity.FrutDetails;
import xulep.co.frutologiaapi.repository.FrutDetailsRepository;

import java.util.List;

@Service
public class FrutDetailsService {

    @Autowired
    private FrutDetailsRepository repository;

    //CREATE
    public FrutDetails create(CreateFrutDetailsDTO data){
        FrutDetails frutD = new FrutDetails();
        frutD.setCalories(data.getCalories());
        frutD.setFat(data.getFat());
        frutD.setSugar(data.getSugar());
        frutD.setCarbohydrates(data.getCarbohydrates());
        frutD.setProtein(data.getProtein());

        repository.save(frutD);
        return frutD;
    }

    //READ
    public List<FrutDetails> findAll(){
        return repository.findAll();
    }

    public FrutDetails findOne(Long id){
        FrutDetails frutD = repository.findById(id).get();
        return frutD;
    }

    //UPDATE
    public FrutDetails update(Long id, UpdateFrutDetailsDTO data){
        FrutDetails frutD = repository.findById(id).get();


        if(data.getCalories() != null){
            frutD.setCalories(data.getCalories());
        }

        if(data.getFat() != null){
            frutD.setFat(data.getFat());
        }
        if(data.getSugar() != null){
            frutD.setSugar(data.getSugar());
        }
        if(data.getCarbohydrates() != null){
            frutD.setCarbohydrates(data.getCarbohydrates());
        }
        if(data.getProtein() != null){
            frutD.setProtein(data.getProtein());
        }

        repository.save(frutD);
        return frutD;
    }

    //DELETE
    public void delete(Long id){
        repository.deleteById(id);
    }

}
