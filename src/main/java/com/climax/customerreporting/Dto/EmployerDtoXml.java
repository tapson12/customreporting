package com.climax.customerreporting.Dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.opencsv.bean.CsvBindByPosition;

@XmlRootElement(name = "employer")
public class EmployerDtoXml {
	
	
	private String nom;
	
	private String prenom;
	
	private String age;
	
	private String profession;
	
	private String salaire;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSalaire() {
		return salaire;
	}

	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}
	
	

}
