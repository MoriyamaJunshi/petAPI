package com.practice.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
