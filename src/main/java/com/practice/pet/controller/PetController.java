package com.practice.pet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.pet.model.Pet;

@RestController
@RequestMapping("/pet")
public class PetController {

    @GetMapping
    public List<Pet> getAllPets() {
        // PetService を使用して全てのペットを取得するロジック
    	return getAllPets();
    }

}
