package com.practice.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    @GetMapping("/{petId}")
      public Pet getPetById(@PathVariable Long petId) {
    	return petService.getPetById;
    }
    
    @PostMapping
    public void addPet(@RequestBody Pet pet) {
    	petService.addPet(pet);
    }
    
    @PutMapping("/{petId}")
    public void updatePet(@RequestBody Pet pet,
    		@PathVariable) {
    	petService.updatePet()
    }
    
    @GetMapping("/findByStatus")
    public List<Pet> findByStatus(@RequestParam String status) {
        // PetService を使用してステータスに基づいてペットを検索するロジック
    }

    @GetMapping("/findByTags")
    public List<Pet> findByTags(@RequestParam List<String> tags) {
        // PetService を使用してタグに基づいてペットを検索するロジック
    }
    
    @DeleteMapping("/{petId}")
    public void deletePet(@PathVariable Long petId) {
        // PetService を使用して特定の ID のペットを削除するロジック
    }
}
