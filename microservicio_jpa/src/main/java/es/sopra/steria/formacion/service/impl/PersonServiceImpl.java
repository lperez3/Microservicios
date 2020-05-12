package es.sopra.steria.formacion.service.impl;

import es.sopra.steria.formacion.dao.PersonRepository;
import es.sopra.steria.formacion.dto.PersonDto;
import es.sopra.steria.formacion.dto.PersonMapper;
import es.sopra.steria.formacion.entity.PersonEntity;
import es.sopra.steria.formacion.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.omg.SendingContext.RunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonMapper personMapper;

	@Override
	public PersonDto getPersonById(String id) throws Exception {
		return personRepository.findById(id)
				.map(personMapper::convertToDto)
				.orElseThrow(Exception::new);

	}

	@Override
	public List<PersonDto> getAllPersons() {
		List<PersonEntity> entities = personRepository.findAll();
		return entities.stream()
				.map(personMapper::convertToDto)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void updatePerson(PersonDto personDto, String personId) throws Exception {
		if (!(personDto.getDni().equalsIgnoreCase(personId))) {
			System.out.println(!(personDto.getDni().equalsIgnoreCase(personId)));
			throw new Exception();
		}
		personRepository.save(personMapper.convertToEntity(personDto));
	}

	@Override
	public void deletePerson(String personId) throws Exception {
		personRepository.findById(personId).orElseThrow(Exception::new);
		personRepository.deleteById(personId);

	}

	@Override
	public PersonDto createPerson(PersonDto personDto) {
		
		personRepository.findById(personDto.getDni()).ifPresent((a) -> {throw new RuntimeException("Error creando Person");});
		return personMapper.convertToDto(personRepository.save(personMapper.convertToEntity(personDto)));
		
	}
}
