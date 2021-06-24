package com.climax.customerreporting.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.climax.customerreporting.ServiceImpl.FileManagerServiceImpl;

@Controller
public class ImportFileController {
	
	FileManagerServiceImpl filename=new FileManagerServiceImpl();
	
	@GetMapping("/filename")
	private String findName() {
		
		return filename.getFileExentision(new File("C:\\paimentcsv.csv"));
		
	}

}
