package com.climax.customerreporting.ServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.climax.customerreporting.services.EmployerService;
import com.climax.customerreporting.services.FileImportManager;
import com.climax.customerreporting.services.ProfessionService;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;


import  com.climax.customerreporting.Dto.EmployerDto;
import com.climax.customerreporting.domaines.Employers;
import com.climax.customerreporting.domaines.Profession;

/**
 * 
 * Implementation of FileImportManager
 *
 */

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
	public String readAndStoreTxtFile(File file) throws IOException {
		
		BufferedReader reader =new BufferedReader(new FileReader(file));
		
		String ligne="";
		while ((ligne=reader.readLine())!=null) {
			
			String[] content=ligne.split(" ");
			
			
			Profession profession=new Profession();
			Employers employer=new Employers();
			
			profession.setLibelleProfession(content[3]);
			profession.setSalaireProfession(Long.valueOf(content[4]));
			employer.setNom(content[0]);
			employer.setPrenom(content[1]);
			employer.setAge(Integer.valueOf(content[2]));
			
			 profession.setCodeProfession(Long.valueOf(1));
			
			
			  if (professionService.save(profession)!=null) {
			  profession.setCodeProfession(professionService.save(profession).
			  getCodeProfession()); employer.setProfession(profession);
			  
			  employerService.save(employer);
			  
			  }else {
				  profession.setCodeProfession(professionService.save(profession).
			  getCodeProfession()); employer.setProfession(profession);
			  
			  employerService.save(employer);
			  
			  }
			
			
		}
	
		return null;
	}

	@Override
	public String readAndStoreXmlFile(File file) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder=factory.newDocumentBuilder();
		
		org.w3c.dom.Document document =builder.parse(file);
		
		document.getDocumentElement().normalize();
		
		org.w3c.dom.Element elements =document.getDocumentElement();
		
		org.w3c.dom.NodeList listenode=document.getElementsByTagName("employe");
		
		
		for (int i=0; i<listenode.getLength();i++) {
			
			Node node=listenode.item(i);
			
			if (node.getNodeType()==Node.ELEMENT_NODE) {
				
				org.w3c.dom.Element el=(org.w3c.dom.Element) node;
				
				
				Profession profession=new Profession();
				Employers employer=new Employers();
				
				profession.setLibelleProfession(el.getElementsByTagName("profession").item(0).getTextContent());
				profession.setSalaireProfession(Long.valueOf(el.getElementsByTagName("profession").item(0).getTextContent()));
				employer.setNom(el.getElementsByTagName("nom").item(0).getTextContent());
				employer.setPrenom(el.getElementsByTagName("prenom").item(0).getTextContent());
				employer.setAge(Integer.valueOf(el.getElementsByTagName("age").item(0).getTextContent()));
				
				  profession.setCodeProfession(Long.valueOf(1));
				
				
				
				  if (professionService.save(profession)!=null) {
				  profession.setCodeProfession(professionService.save(profession).
				  getCodeProfession()); employer.setProfession(profession);
				  
				  employerService.save(employer);
				  
				  }else { profession.setCodeProfession(professionService.save(profession).
				  getCodeProfession()); employer.setProfession(profession);
				  
				  employerService.save(employer);
				  
				  }
				
				
				
				
		
			
		}
		
		}
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
