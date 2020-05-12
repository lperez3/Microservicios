package es.sopra.steria.formacion.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.sopra.steria.formacion.service.FormacionService;

@RestController
public class FormacionController {
	
	@Autowired
	private FormacionService formacionService;
	
	@GetMapping("/formacion/hello/{name}")
	public String hello(@PathVariable(name="name") String name) {
		return formacionService.getName(name);
	}

}
