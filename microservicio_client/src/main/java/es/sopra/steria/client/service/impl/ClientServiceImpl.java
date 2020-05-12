package es.sopra.steria.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.sopra.steria.client.domain.PersonDto;
import es.sopra.steria.client.domain.SkillDto;
import es.sopra.steria.client.dto.ProfileDto;
import es.sopra.steria.client.dto.ProfileMapper;
import es.sopra.steria.client.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	
	private final static String URI_SKILLS="http://localhost:8080/skills/";
	private final static String URI_DATA_PERSON="http://localhost:8088/persons/";
	
	@Autowired
	private ProfileMapper profileMapper;

	
	private RestTemplate restTemplate=new RestTemplate();

	@Override
	public PersonDto getPersonById(String id) throws Exception {
		return restTemplate.getForObject(URI_DATA_PERSON+id, PersonDto.class);
	}
	
	@Override
	public SkillDto getSkillById(String id) throws Exception {
		return restTemplate.getForObject(URI_SKILLS+id, SkillDto.class);
	}
	
	@Override
	public ProfileDto getProfile(String id) throws Exception {
		PersonDto personDto= getPersonById(id);
		SkillDto skill = getSkillById(id);
		
		ProfileDto profile = profileMapper.convertToProfileDto(personDto,skill);
		
		return profile;
		
		
	}

}
