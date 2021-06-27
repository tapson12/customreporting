package com.climax.customerreporting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climax.customerreporting.domaines.Profession;

/**
 * 
 * Repository Profession 
 *
 */
public interface ProfessionRepository extends JpaRepository<Profession, Long> {
	
	public List<Profession> findByLibelleProfession(String profession);

}
