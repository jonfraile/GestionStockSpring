package com.ipartek.formacion.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class PersonaTest {

	private Persona persona;

	@Before
	public void setUp() throws Exception {
		this.persona = new Persona();
	}

	@Test
	public void testSetAndGetNombre() {
		final String testNombre = "aNombre";
		assertNull(this.persona.getNombre());
		this.persona.setNombre(testNombre);
		assertEquals(testNombre, this.persona.getNombre());
	}

}
