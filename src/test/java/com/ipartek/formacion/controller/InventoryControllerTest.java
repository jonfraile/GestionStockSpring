package com.ipartek.formacion.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.service.SimpleProductManager;

public class InventoryControllerTest {

	@Test
	public void test() {

		try {
			final InventoryController controller = new InventoryController();
			controller.setProductManager(new SimpleProductManager());
			final ModelAndView mv = controller.handleRequest(null, null);

			assertEquals("Vista no valida", "inventario", mv.getViewName());
			assertNotNull(mv.getModel().get("fecha"));

		} catch (final Exception e) {
			fail("No deberia de lanzar la excepcion");
		}
	}

}
