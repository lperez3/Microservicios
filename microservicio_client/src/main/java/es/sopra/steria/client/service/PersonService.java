package es.sopra.steria.client.service;

import es.sopra.steria.client.dto.ProfileDto;

public interface PersonService {

	ProfileDto getPersonById(String id) throws Exception;

}
