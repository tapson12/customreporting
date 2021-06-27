package com.climax.customerreporting.Dto;

import com.opencsv.bean.CsvBindByPosition;

public class EmployerDto {
	@CsvBindByPosition(position = 0)
	private String nom;
	@CsvBindByPosition(position = 1)
	private String prenom;
	@CsvBindByPosition(position = 2)
	private String age;
	@CsvBindByPosition(position = 3)
	private String profession;
	@CsvBindByPosition(position = 4)
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
