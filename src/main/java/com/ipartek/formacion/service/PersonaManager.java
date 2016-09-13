package com.ipartek.formacion.service;

import java.io.Serializable;
import java.util.List;

import com.ipartek.formacion.domain.Persona;

public interface PersonaManager extends Serializable {

	/**
	 * Muestra todas las personas
	 * 
	 * @return
	 */
	public List<Persona> getAll();

}
