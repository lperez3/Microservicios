package es.sopra.steria.mongo.web.rest;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.sopra.steria.mongo.dto.SkillDto;
import es.sopra.steria.mongo.service.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
    @PostMapping
    @Transactional
	public ResponseEntity<Void> createSkill(@RequestBody SkillDto skillDto) {

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/"+ skillService.createSkill(skillDto).getDni())
                .build()
                .toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

    @GetMapping(path="/{id}")
	public ResponseEntity<SkillDto> getSkillById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(skillService.getSkillById(id), HttpStatus.OK);
	}
	

	@GetMapping
	public ResponseEntity<Collection<SkillDto>> getAllSkills() {
        return new ResponseEntity<>(skillService.getAllSkills(), HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateSkill(@RequestBody SkillDto skillDto, @PathVariable String id) throws Exception {
        
		skillService.updateSkill(skillDto, id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSkill(@PathVariable String id) throws Exception {
		skillService.deleteSkill(id);
    	return new ResponseEntity<>(HttpStatus.OK);
	}

}
