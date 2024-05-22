package com.practice.pet.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.practice.pet.model.Pet;

@Repository
public interface PetRepository {
	List<Pet> findAll();
	Pet findById(Long id);
	void save(Pet pet);
	List<Pet> findByStatus(String status);
	List<Pet> findByTags(String[] status);
}
