package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Persona;

public class SimplePersonaManager implements PersonaManager {

	private static final long serialVersionUID = 1L;

	private List<Persona> personas;

	@Override
	public List<Persona> getAll() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}
