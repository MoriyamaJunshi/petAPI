package com.practice.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.pet.model.Pet;
import com.practice.pet.repo.PetRepository;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	public List<Pet> getAllPets(){
		return petRepository.findAll();
	}
	
    public Pet getPetById(Long petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found with id " + petId));
    }
    
    public void addPet(Pet pet) {
    	petRepository.save(pet);
    }
    
    public void updatePet(Pet pet) {
    	petRepository.save(pet);
    }
    
    public List<Pet> findByStatus(String status){
    	return petRepository.findByStatus(status);
    }
}
