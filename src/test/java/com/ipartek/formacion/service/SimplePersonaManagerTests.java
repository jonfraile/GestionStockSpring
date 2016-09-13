package com.ipartek.formacion.service;

import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ipartek.formacion.domain.Persona;

public class SimplePersonaManagerTests {

	private SimplePersonaManager personaManager;

	private List<Persona> personas;

	private static String NOMBRE_UNO = "Manolo";
	private static String NOMBRE_DOS = "Manolito";

	@Before
	public void setUp() throws Exception {
		this.personaManager = new SimplePersonaManager();
		this.personas = new ArrayList<Persona>();

		// stub up a list of personas
		Persona persona = new Persona();
		persona.setNombre(NOMBRE_UNO);
		this.personas.add(persona);

		persona = new Persona();
		persona.setNombre(NOMBRE_DOS);
		this.personas.add(persona);

		this.personaManager.setPersonas(this.personas);

	}

	@Test
	public void testGetPersonasWithNoPersonass() {
		this.personaManager = new SimplePersonaManager();
		assertNull(this.personaManager.getAll());
	}

}
