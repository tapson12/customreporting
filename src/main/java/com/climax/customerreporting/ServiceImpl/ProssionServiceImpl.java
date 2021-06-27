package com.climax.customerreporting.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.climax.customerreporting.domaines.Profession;
import com.climax.customerreporting.repository.ProfessionRepository;
import com.climax.customerreporting.services.ProfessionService;

@Service
@Transactional
public class ProssionServiceImpl implements ProfessionService {
	
	@Autowired
	private ProfessionRepository dao;

	@Override
	public Profession save(Profession profession)  {
	
		if (professionalExist(profession.getLibelleProfession())) {
			
			return dao.findByLibelleProfession(profession.getLibelleProfession()).get(0);
			
		} else {
			
			return dao.save(profession);

		}
	
		
		
	}

	@Override
	public Profession update(Profession profession) {
		
		return dao.saveAndFlush(profession);
	}

	@Override
	public Profession getProfessionById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Profession> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<Profession> getByPage(Pageable page) {
		// TODO Auto-generated method stub
		return dao.findAll(page);
	}

	@Override
	public boolean professionalExist(String professional) {
		
	
		if (dao.findByLibelleProfession(professional).size()>0) {
			
			return true;
		}
		else
		{
			return false; 
		}
		
	}

}
