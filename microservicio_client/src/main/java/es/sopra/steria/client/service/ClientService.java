package es.sopra.steria.client.service;

import es.sopra.steria.client.domain.PersonDto;
import es.sopra.steria.client.domain.SkillDto;
import es.sopra.steria.client.dto.ProfileDto;

public interface ClientService {

	PersonDto getPersonById(String id) throws Exception;

	SkillDto getSkillById(String id) throws Exception;

	ProfileDto getProfile(String id) throws Exception;

}
