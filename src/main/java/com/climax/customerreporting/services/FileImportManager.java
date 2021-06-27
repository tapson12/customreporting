package com.climax.customerreporting.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.opencsv.exceptions.CsvValidationException;

/**
 * 
 * interface to manage data import 
 *
 */
public interface FileImportManager {
	
	/**
	 * 
	 * @param file
	 * @return  String  file extension
	 */
	public String getFileExentision(File file);
	
	/**
	 * function to import csv file
	 * @param file
	 * @return String message to number of the file 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws CsvValidationException
	 */
	public String readAndStoreCsvFile(File file) throws FileNotFoundException, IOException, CsvValidationException;
	
	/**
	 * function to import txt file 
	 * @param file
	 * @return String message to number of the file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String readAndStoreTxtFile(File file) throws FileNotFoundException, IOException;
	/**
	 * function to import xml file
	 * 
	 * @param file
	 * @return String message to number of the file
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public String readAndStoreXmlFile(File file) throws ParserConfigurationException, SAXException, IOException;
	/**
	 * function to import json file 
	 * @param file
	 * @return String message to number of the file
	 * @throws ParseException
	 * @throws org.json.simple.parser.ParseException
	 */
	public String readAndStoreJson(File file) throws ParseException, org.json.simple.parser.ParseException;
	

}
