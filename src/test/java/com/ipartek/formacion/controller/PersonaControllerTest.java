package com.ipartek.formacion.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.service.SimplePersonaManager;

public class PersonaControllerTest {

	@Test
	public void test() {
		try {
			final PersonaController controller = new PersonaController();
			controller.setPersonaManager(new SimplePersonaManager());
			final ModelAndView mv = controller.handleRequest(null, null);

			assertEquals("Vista no valida", "personas", mv.getView());
			assertNotNull(mv.getModel().get("personas"));

		} catch (final Exception e) {
			fail("No deberia de lanzar la excepcion");
		}
	}
}