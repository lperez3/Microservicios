package es.sopra.steria.client.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.sopra.steria.client.domain.Person;
import es.sopra.steria.client.domain.PersonDto;
import es.sopra.steria.client.domain.PersonMapper;
import es.sopra.steria.client.domain.SkillDto;

@Component
public class ProfileMapper {

	@Autowired
	private PersonMapper personMapper;
	
	public ProfileDto convertToProfileDto(PersonDto personDto, SkillDto skill) {
		
		ProfileDto profile = new ProfileDto();
		profile.setAge(personDto.getAge());
		profile.setDni(personDto.getDni());
		
		Person person = personMapper.convertToEntity(personDto);
		profile.setApellidos(person.getApellidos());
		profile.setBirthyear(person.getYear());
		profile.setNombre(person.getName());
		profile.setSkills(skill.getSkills());
		return profile;
		
	}
}
