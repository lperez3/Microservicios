package es.sopra.steria.formacion.dto;

public class PersonDto {

  private String name;
  private Integer age;
  private String dni;

  public PersonDto(String name, Integer age,String dni) {
    this.name = name;
    this.age = age;
    this.dni=dni;
  }

  public PersonDto() {
}



public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
  
  public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}


}
