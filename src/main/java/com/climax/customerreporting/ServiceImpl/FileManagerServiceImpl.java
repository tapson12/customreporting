package com.climax.customerreporting.ServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climax.customerreporting.services.EmployerService;
import com.climax.customerreporting.services.FileImportManager;
import com.climax.customerreporting.services.ProfessionService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import  com.climax.customerreporting.Dto.EmployerDto;
import com.climax.customerreporting.domaines.Employers;
import com.climax.customerreporting.domaines.Profession;

@Service
@Transactional
public class FileManagerServiceImpl implements FileImportManager {

	
	@Autowired
	EmployerService employerService;
	
	@Autowired
	ProfessionService professionService;
	
	@Override
	public String getFileExentision(File file) {
		// TODO Auto-generated method stub
		return FilenameUtils.getExtension(file.getAbsolutePath());
	}

	@Override
	public String readAndStoreCsvFile(File file) throws FileNotFoundException, IOException, CsvValidationException {

		List<EmployerDto> employers = new CsvToBeanBuilder(new FileReader(file))
                .withType(EmployerDto.class)
                .build()
                .parse();
		
		
		employers.forEach(item->{
			
			Profession profession=new Profession();
			Employers employer=new Employers();
			
			profession.setLibelleProfession(item.getProfession());
			profession.setSalaireProfession(Long.valueOf(item.getSalaire()));
			employer.setNom(item.getNom());
			employer.setPrenom(item.getPrenom());
			employer.setAge(Integer.valueOf(item.getAge()));
			
			profession.setCodeProfession(Long.valueOf(1));
			
			  if (professionService.save(profession)!=null) {
			  profession.setCodeProfession(professionService.save(profession).
			  getCodeProfession()); employer.setProfession(profession);
			  
			  employerService.save(employer);
			  
			  }else { profession.setCodeProfession(professionService.save(profession).
			  getCodeProfession()); employer.setProfession(profession);
			  
			  employerService.save(employer);
			  
			  }
			 
			 
			
			 
			
		});
		
		
		 return "nombre de ligne"+employers.size();
	}

	@Override
	public String readAndStoreTxtFile(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readAndStoreXmlFile(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readAndStoreJson(File file) throws ParseException, org.json.simple.parser.ParseException {
		JSONParser parser=new JSONParser();
		
		try (FileReader reader = new FileReader("employees.json"))
        {
            
            Object obj = parser.parse(reader);
 
            JSONArray employeeList = (JSONArray) obj;
           
            
            employeeList.forEach( item -> {
            	
            	ObjectMapper objectMapper=new ObjectMapper();
            	
            	try {
					EmployerDto dto=objectMapper.readValue(item.toString(), EmployerDto.class);
					
					Profession profession=new Profession();
					Employers employer=new Employers();
					
					profession.setLibelleProfession(dto.getProfession());
					profession.setSalaireProfession(Long.valueOf(dto.getSalaire()));
					employer.setNom(dto.getNom());
					employer.setPrenom(dto.getPrenom());
					employer.setAge(Integer.valueOf(dto.getAge()));
					
					profession.setCodeProfession(Long.valueOf(1));
					
					  if (professionService.save(profession)!=null) {
					  profession.setCodeProfession(professionService.save(profession).
					  getCodeProfession()); employer.setProfession(profession);
					  
					  employerService.save(employer);
					
				}
            	}catch (Exception e) {
					// TODO: handle exception
				}
            } );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}

}
