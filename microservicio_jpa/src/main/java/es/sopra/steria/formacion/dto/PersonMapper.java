package es.sopra.steria.formacion.dto;

import java.awt.List;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import es.sopra.steria.formacion.entity.PersonEntity;

@Component
public class PersonMapper {

	public PersonDto convertToDto(PersonEntity person) {

		PersonDto dto = new PersonDto();
		dto.setName(person.getName() + " " + person.getApellidos());
		dto.setAge(LocalDate.now().getYear() - person.getYear());
		dto.setDni(person.getDni());
		return dto;

	}

	public PersonEntity convertToEntity(PersonDto personDto) {
		PersonEntity personEntity = new PersonEntity();
		String[] list = personDto.getName().split(" ");
		personEntity.setApellidos(list[1] + " " + list[2]);
		personEntity.setName(list[0]);
		personEntity.setYear(LocalDate.now().getYear() - personDto.getAge());
		personEntity.setDni(personDto.getDni());
		return personEntity;
	}
}
