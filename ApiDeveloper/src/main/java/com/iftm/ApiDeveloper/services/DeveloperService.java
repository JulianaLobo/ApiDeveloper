package com.iftm.ApiDeveloper.services;

import com.iftm.ApiDeveloper.models.Developer;
import com.iftm.ApiDeveloper.models.dtos.DeveloperDTO;
import com.iftm.ApiDeveloper.repositories.DeveloperRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository repository;

    public ResponseEntity<List<DeveloperDTO>> findAll() {
        var dbDeveloper = repository.findAll();
        if(dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();

        var developerDtos = dbDeveloper.stream().map(developer -> {
            var developerDTO = new DeveloperDTO(developer);
            return developerDTO;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(developerDtos);
    }

    public ResponseEntity<DeveloperDTO> findById(ObjectId id) {
        if(id == null)
            return ResponseEntity.badRequest().build();
        var dbDeveloper = repository.findById(id);
        if(dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DeveloperDTO( dbDeveloper.get()));
    }

    public ResponseEntity<DeveloperDTO> save(Developer developer) {
        //validar developer
        if(developer.getName().isBlank())
            return ResponseEntity.badRequest().build();
        developer.setId(ObjectId.get());
        return ResponseEntity.ok(new DeveloperDTO(repository.save(developer)));
    }

    public ResponseEntity<DeveloperDTO> update(DeveloperDTO developer) {
        // validar
        if(developer.getId() == null)
            return ResponseEntity.badRequest().build();

        var objectId = new ObjectId(developer.getId());
        var dbDeveloper = repository.findById(objectId);
        if(dbDeveloper.isEmpty())
            return ResponseEntity.notFound().build();
        // atualizar
        var dbDeveloperObj = dbDeveloper.get();
        dbDeveloperObj.setName(developer.getName());
        dbDeveloperObj.setLastName(developer.getLastName());
        dbDeveloperObj.setLevel(developer.getLevel());
        dbDeveloperObj.setSpecialization(developer.getSpecialization());

        return ResponseEntity.ok(new DeveloperDTO(repository.save(dbDeveloperObj)));
    }

    public ResponseEntity<?> delete(ObjectId id) {
        if(id == null)
            return ResponseEntity.badRequest().build();

        repository.deleteById(id);

        var dbDeveloper = repository.findById(id);
        if(dbDeveloper.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        return ResponseEntity.ok().build();
    }
}
