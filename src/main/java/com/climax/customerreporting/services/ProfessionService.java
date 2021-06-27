package com.climax.customerreporting.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.climax.customerreporting.domaines.Profession;

/**
 * 
 * service Profession
 *
 */
public interface ProfessionService {
	
	/**
	 * function to save profession in database 
	 * @param Profession
	 * @return Profession 
	 */
	Profession save(Profession profession);
	/**
	 * function to update Profession in database 
	 * @param Profession
	 * @return Profession
	 */
	Profession update(Profession profession);
	
	/**
	 * function to get Profession by id
	 * @param id
	 * @return Profession 
	 */
	Profession getProfessionById(Long id);
	
	/**
	 * function to get all Profession list in database 
	 * @return List of Profession 
	 */
	List<Profession>getAll();
	
	/**
	 * function to get Profession list by page 
	 * @param page
	 * @return Page of Profession list 
	 */
	Page<Profession>getByPage(Pageable page);
	/**
	 * function to check if profession only exist in database 
	 * @param professional
	 * @return boolean
	 */
	boolean professionalExist(String professional);
	
	
	

}
