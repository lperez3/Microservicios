package es.sopra.steria.client.domain;

public class Person {

  private String dni;
  private String name;
  private String apellidos;
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
