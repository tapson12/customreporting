package com.climax.customerreporting.domaines;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "profession")
public class Profession implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codeProfession;
	private String libelleProfession;
	private Long  salaireProfession;
	
	@OneToMany(mappedBy = "profession")
	private List<Employers>employers;

	public Long getCodeProfession() {
		return codeProfession;
	}

	public void setCodeProfession(Long codeProfession) {
		this.codeProfession = codeProfession;
	}

	public String getLibelleProfession() {
		return libelleProfession;
	}

	public void setLibelleProfession(String libelleProfession) {
		this.libelleProfession = libelleProfession;
	}

	public Long getSalaireProfession() {
		return salaireProfession;
	}

	public void setSalaireProfession(Long salaireProfession) {
		this.salaireProfession = salaireProfession;
	}

	public List<Employers> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Employers> employers) {
		this.employers = employers;
	}

	
	
}
