package com.climax.customerreporting.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.climax.customerreporting.domaines.Employers;

public interface EmployerService {
	
	
	Employers save(Employers employers);
	Employers update(Employers employers);
	Employers getEmployersById(Long id);
	List<Employers>getAll();
	Page<Employers>getByPage(Pageable page);

}
