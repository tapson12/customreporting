package com.climax.customerreporting.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.climax.customerreporting.domaines.Profession;

public interface ProfessionService {
	
	Profession save(Profession profession);
	Profession update(Profession profession);
	Profession getProfessionById(Long id);
	List<Profession>getAll();
	Page<Profession>getByPage(Pageable page);
	boolean professionalExist(String professional);
	
	
	

}
