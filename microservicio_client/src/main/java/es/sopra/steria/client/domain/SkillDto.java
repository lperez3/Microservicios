package es.sopra.steria.client.domain;

import java.util.List;

import org.springframework.stereotype.Component;

public class SkillDto {

	
	private String dni;
	private List<String> skills;
	
	
	
	public SkillDto() {
	}
	
	public SkillDto(String dni, List<String> skills) {
		this.dni = dni;
		this.skills = skills;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	
	
}
