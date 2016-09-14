package com.ipartek.formacion.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ipartek.formacion.domain.Persona;

public class SimplePersonaManagerTests {

	private SimplePersonaManager personaManager;

	private List<Persona> personas;

	private static int PERSONA_COUNT = 3;

	private static String NOMBRE_UNO = "Manolo";
	private static String NOMBRE_DOS = "Manolito";
	private static String NOMBRE_TRES = "Manoli";

	@Before
	public void setUp() throws Exception {
		this.personaManager = new SimplePersonaManager();
		this.personas = new ArrayList<Persona>();

		// Crear lista de personas personas
		Persona persona = new Persona();
		persona.setNombre(NOMBRE_UNO);
		this.personas.add(persona);

		persona = new Persona();
		persona.setNombre(NOMBRE_DOS);
		this.personas.add(persona);

		persona = new Persona();
		persona.setNombre(NOMBRE_TRES);
		this.personas.add(persona);

		this.personaManager.setPersonas(this.personas);

	}

	@Test
	public void testGetPersonasWithNoPersonas() {
		this.personaManager = new SimplePersonaManager();
		assertNull(this.personaManager.getAll());
	}

	@Test
	public void testGetAllPersonas() {
		final List<Persona> personas = this.personaManager.getAll();
		assertNotNull(personas);
		assertEquals(PERSONA_COUNT, this.personaManager.getAll().size());

		Persona persona = personas.get(0);
		assertEquals(NOMBRE_UNO, persona.getNombre());

		persona = personas.get(1);
		assertEquals(NOMBRE_DOS, persona.getNombre());

		persona = personas.get(2);
		assertEquals(NOMBRE_TRES, persona.getNombre());

	}

}
