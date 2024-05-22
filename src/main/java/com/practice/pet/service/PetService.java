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
    
    public void addPet(Pet pet) {
    	petRepository.save(pet);
    }
    
    public void updatePet(Pet pet) {
    	petRepository.save(pet);
    }
    
    public List<Pet> findByStatus(String status){
    	return petRepository.findByStatus(status);
    }
    
    public List<Pet> findByTags(String tags){
    	String[] tagArray = tags.split(",\\s*");
    	return petRepository.findByTags(tagArray);
    }
    
    public Pet getPetById(Long petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found with id " + petId));
    }
    
    public Pet addPetById(Long petId, Pet pet) {
        if (petRepository.findById(petId).isPresent()) {
            throw new RuntimeException("PetId: " + petId + "は既に存在します。");
        }
        pet.setId(petId);
        return petRepository.save(pet);
    }
    
    public void deletePetById(Long petId) {
        petRepository.deleteById(petId);
    }
}
