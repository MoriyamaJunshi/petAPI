package com.practice.pet.exception;

public class PetNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public PetNotFoundException(Long petId) {
		super("ペットId:" + petId + "は見つかりません。");
	}
}
