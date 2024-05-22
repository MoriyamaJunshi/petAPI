package com.practice.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.pet.model.Pet;
import com.practice.pet.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {
	
	@Autowired
	private PetService petService;

    @GetMapping
    public List<Pet> getAllPets() {
        // PetService を使用して全てのペットを取得
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
    public Pet getPetById(@PathVariable Long petId) {
  	return petService.getPetById(petId);
    }
}
