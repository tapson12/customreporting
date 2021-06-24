package com.climax.customerreporting.domaines;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "employers")
public class Employers implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeEmployer;
	private String nom;
	private String prenom;
	private int age ;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Profession profession;

	public Long getCodeEmployer() {
		return codeEmployer;
	}

	public void setCodeEmployer(Long codeEmployer) {
		this.codeEmployer = codeEmployer;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	
	
	
	

}
