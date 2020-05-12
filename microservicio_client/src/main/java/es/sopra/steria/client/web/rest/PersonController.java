package es.sopra.steria.client.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.sopra.steria.client.dto.ProfileDto;
import es.sopra.steria.client.service.PersonService;

@RestController
@RequestMapping(path="/persons")
public class PersonController {

  @Autowired
  private PersonService personService;

    @GetMapping(path="/{personId}")
	public ResponseEntity<ProfileDto> getPersonById(@PathVariable String personId) throws Exception {
        return new ResponseEntity<>(personService.getPersonById(personId), HttpStatus.OK);
	}
	
}
