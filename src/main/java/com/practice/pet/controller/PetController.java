package com.practice.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.pet.exception.PetNotFoundException;
import com.practice.pet.model.Pet;
import com.practice.pet.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {
	
	@Autowired
	private PetService petService;

    @GetMapping
    public List<Pet> getAllPets() {
    	return getAllPets();
    }
    
    @PostMapping
    public void addPet(@RequestBody Pet pet) {
    	petService.addPet(pet);
    }
    
    @PutMapping
    public void update(@RequestBody Pet pet) {
    	petService.updatePet(pet);
    }
    
    @GetMapping("/findByStatus")
    public ResponseEntity<List<Pet>> findByStatus(@RequestParam("status") String status) {
        return ResponseEntity.ok(petService.findByStatus(status));
    }

    @GetMapping("/findByTags")
    public ResponseEntity<List<Pet>> findByTags(@RequestParam("tags") String tags) {
        return ResponseEntity.ok(petService.findByTags(tags));
    }
    
    @GetMapping("/{petId}")
    public Pet getPetById(@PathVariable("petId") Long petId) {
    	//メソッド orElseThrow(() -> {}) は型 Pet で未定義です
  	    return petService.getPetById(petId).orElseThrow(() -> new PetNotFoundException(petId));
    }
    
    @PostMapping("/{petId}")
    public ResponseEntity<Pet> addPetById(@PathVariable Long petId, @RequestBody Pet pet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.addPetById(petId, pet));
    }
    
    @DeleteMapping("/{petId}")
    public void deletePetById(@PathVariable("petId") Long petId) {
    	petService.deletePetById(petId);
    }


}
