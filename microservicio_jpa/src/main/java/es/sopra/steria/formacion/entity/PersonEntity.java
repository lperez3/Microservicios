package es.sopra.steria.formacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "person")
public class PersonEntity {

  @Id
  @Column(name = "dni")
  private String dni;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "apellidos")
  private String apellidos;

  @Column(name = "year")
  private Integer year;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public Integer getYear() {
	return year;
}

public void setYear(Integer year) {
	this.year = year;
}


}
