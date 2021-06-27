package com.climax.customerreporting.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.climax.customerreporting.domaines.Employers;

/**
 * 
 *Service employer
 *
 */
public interface EmployerService {
	
	/**
	 * function to save employers in database 
	 * @param employers
	 * @return Employers 
	 */
	Employers save(Employers employers);
	/**
	 * function to update employers in database 
	 * @param employers
	 * @return Employers
	 */
	Employers update(Employers employers);
	/**
	 * function to get Employer by id
	 * @param id
	 * @return Employers 
	 */
	Employers getEmployersById(Long id);
	/**
	 * function to get all Employer list in database 
	 * @return List of Employers 
	 */
	List<Employers>getAll();
	/**
	 * function to get Employers list by page 
	 * @param page
	 * @return Page of Employer list 
	 */
	Page<Employers>getByPage(Pageable page);

}
