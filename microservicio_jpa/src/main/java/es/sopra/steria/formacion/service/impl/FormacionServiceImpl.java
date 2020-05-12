package es.sopra.steria.formacion.service.impl;

import org.springframework.stereotype.Service;

import es.sopra.steria.formacion.service.FormacionService;

@Service
public class FormacionServiceImpl implements FormacionService{

	@Override
	public String getName(String name) {
		return "Hello World " + name;
	}

}
