package es.sopra.steria.client.domain;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

	public PersonDto convertToDto(Person person) {

		PersonDto dto = new PersonDto();
		dto.setName(person.getName() + " " + person.getApellidos());
		dto.setAge(LocalDate.now().getYear() - person.getYear());
		dto.setDni(person.getDni());
		return dto;

	}

	public Person convertToEntity(PersonDto personDto) {
		Person personEntity = new Person();
		String[] list = personDto.getName().split(" ");
		personEntity.setApellidos(list[1] + " " + list[2]);
		personEntity.setName(list[0]);
		personEntity.setYear(LocalDate.now().getYear() - personDto.getAge());
		personEntity.setDni(personDto.getDni());
		return personEntity;
	}
}
