package es.sopra.steria.formacion.web.rest;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import es.sopra.steria.formacion.dto.PersonDto;
import es.sopra.steria.formacion.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/person")
public class PersonController {

  @Autowired
  private PersonService personService;
 
    @PostMapping
    @Transactional
	public ResponseEntity<Void> createPerson(@RequestBody PersonDto personDto) {

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/"+ personService.createPerson(personDto).getDni())
                .build()
                .toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

    @GetMapping(path="/{personId}")
	public ResponseEntity<PersonDto> getPerson(@PathVariable String personId) throws Exception {
        return new ResponseEntity<>(personService.getPersonById(personId), HttpStatus.OK);
	}
	

	@GetMapping
	public ResponseEntity<Collection<PersonDto>> getAllPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);

	}

	@PutMapping("/{personId}")
	public ResponseEntity<Void> updatePerson(@RequestBody PersonDto personDto, @PathVariable String personId) throws Exception {
        
		personService.updatePerson(personDto, personId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{personId}")
	public ResponseEntity<Void> deletePerson(@PathVariable String personId) throws Exception {
		personService.deletePerson(personId);
    	return new ResponseEntity<>(HttpStatus.OK);
	}
}
