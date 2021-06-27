package com.climax.customerreporting.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.climax.customerreporting.domaines.Employers;
import com.climax.customerreporting.repository.EmployerRepository;
import com.climax.customerreporting.services.EmployerService;
import com.climax.customerreporting.services.ProfessionService;

@Service
@Transactional
public class EmployerServiceImpl  implements EmployerService{
	
	@Autowired
	private ProfessionService serviceProfessional;
	@Autowired
	private EmployerRepository dao;

	@Override
	public Employers save(Employers employers) {
		
		
		employers.setProfession(serviceProfessional.save(employers.getProfession()));
		
		return  dao.save(employers);
	}

	@Override
	public Employers update(Employers employers) {
		
		return dao.saveAndFlush(employers);
	}

	@Override
	public Employers getEmployersById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Employers> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Page<Employers> getByPage(Pageable page) {
		// TODO Auto-generated method stub
		return dao.findAll(page);
	}


}
