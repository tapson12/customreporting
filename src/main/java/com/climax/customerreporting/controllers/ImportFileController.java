package com.climax.customerreporting.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.climax.customerreporting.ServiceImpl.FileManagerServiceImpl;

@Controller
public class ImportFileController {
	
	@Autowired
	FileManagerServiceImpl filenmae;

	@GetMapping("/")
	private String importer(Model model) {
	
		return "index";
		
	}

	@GetMapping("/stat")
	private String statistiques(Model model) {
	
		return "statistique";
		
	}
	
	@GetMapping("/import")
	private String findName(Model model) {
		
		model.addAttribute("filename", "salutt");
		
		try {
			filenmae.readAndStoreXmlFile(new File("C:\\employee.xml").getAbsoluteFile());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/index";
		
	}
	
	@GetMapping("/export")
	public String exportJson()
	{
		JSONArray listemployer=new JSONArray();
		JSONObject employer1 =new JSONObject();
		employer1.put("nom", "ima");
		employer1.put("prenom", "flore");
		employer1.put("age", "26");
		employer1.put("profession", "elevage");
		employer1.put("salaire", "5");
		
		JSONObject employer2 =new JSONObject();
		employer2.put("nom", "ouedraogo");
		employer2.put("prenom", "salif");
		employer2.put("age", "20");
		employer2.put("profession", "mecanicien");
		employer2.put("salaire", "1");
		listemployer.add(employer1);
		listemployer.add(employer2);
		   try (FileWriter file = new FileWriter("employees.json")) {
	            //We can write any JSONArray or JSONObject instance to the file
	            file.write((listemployer.toJSONString()));
	            file.flush();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		return "";
		
	}

}
