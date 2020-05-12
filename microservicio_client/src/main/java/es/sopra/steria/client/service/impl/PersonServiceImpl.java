package es.sopra.steria.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sopra.steria.client.dto.ProfileDto;
import es.sopra.steria.client.service.ClientService;
import es.sopra.steria.client.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private ClientService clientService;
	

	@Override
	public ProfileDto getPersonById(String id) throws Exception {
		return clientService.getProfile(id);

	}

}
