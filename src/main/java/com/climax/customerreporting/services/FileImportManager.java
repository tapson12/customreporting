package com.climax.customerreporting.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import com.opencsv.exceptions.CsvValidationException;

public interface FileImportManager {
	
	public String getFileExentision(File file);
	
	public String readAndStoreCsvFile(File file) throws FileNotFoundException, IOException, CsvValidationException;
	public String readAndStoreTxtFile(File file) throws FileNotFoundException, IOException;
	public String readAndStoreXmlFile(File file);
	public String readAndStoreJson(File file) throws ParseException, org.json.simple.parser.ParseException;
	

}
