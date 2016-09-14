package com.ipartek.formacion.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HomeControllerTest {

	// TODO REQUEST MOCK
	@Test
	public void testHome() {
		final HomeController hc = new HomeController();
		assertEquals("No retorna el String de la vista 'home.jsp' ", "home", hc.home(null, null));
	}

}
