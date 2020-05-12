package es.sopra.steria.formacion.service;

import java.util.List;

import es.sopra.steria.formacion.dto.PersonDto;

public interface PersonService {

	PersonDto getPersonById(String id) throws Exception;

	List<PersonDto> getAllPersons();

	void updatePerson(PersonDto personDto, String personId) throws Exception;

	void deletePerson(String personId) throws Exception;

	PersonDto createPerson(PersonDto personDto);
}
