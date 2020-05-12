package es.sopra.steria.client.dto;

import java.util.List;

public class ProfileDto {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private Integer age;
	private Integer birthyear;
	private List<String> skills;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer integer) {
		this.age = integer;
	}
	public Integer getBirthyear() {
		return birthyear;
	}
	public void setBirthyear(Integer birthyear) {
		this.birthyear = birthyear;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	
}
