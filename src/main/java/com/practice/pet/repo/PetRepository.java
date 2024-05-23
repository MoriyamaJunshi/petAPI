package com.practice.pet.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.practice.pet.model.Pet;

@Repository
public interface PetRepository {
	List<Pet> findAll();
	Optional<Pet> findById(Long pet);
	Pet save(Pet pet);
	List<Pet> findByStatus(String status);
	List<Pet> findByTags(String[] status);
	void deleteById(Long id);
}
