package com.ipartek.formacion.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ipartek.formacion.domain.Persona;
import com.ipartek.formacion.domain.Product;

public class SimplePersonaManagerTests {

	private SimplePersonaManager personaManager;

	private List<Persona> personas;

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
	public void testGetPersonasWithNoProducts() {
		this.personaManager = new SimplePersonaManager();
		assertNull(this.personaManager.getAll());
	}

	@Test
	public void testGetProducts() {
		final List<Product> products = this.productManager.getProducts();
		assertNotNull(products);
		assertEquals(PRODUCT_COUNT, this.productManager.getProducts().size());

		Product product = products.get(0);
		assertEquals(CHAIR_DESCRIPTION, product.getDescription());
		assertEquals(CHAIR_PRICE, product.getPrice());

		product = products.get(1);
		assertEquals(TABLE_DESCRIPTION, product.getDescription());
		assertEquals(TABLE_PRICE, product.getPrice());
	}

	@Test
	public void testIncreasePriceWithNullListOfProducts() {
		try {
			this.productManager = new SimpleProductManager();
			this.productManager.increasePrice(POSITIVE_PRICE_INCREASE);
		} catch (final NullPointerException ex) {
			fail("Products list is null.");
		}
	}

	@Test
	public void testIncreasePriceWithEmptyListOfProducts() {
		try {
			this.productManager = new SimpleProductManager();
			this.productManager.setProducts(new ArrayList<Product>());
			this.productManager.increasePrice(POSITIVE_PRICE_INCREASE);
		} catch (final Exception ex) {
			fail("Products list is empty.");
		}
	}

	@Test
	public void testIncreasePriceWithPositivePercentage() {
		this.productManager.increasePrice(POSITIVE_PRICE_INCREASE);
		final double expectedChairPriceWithIncrease = 22.55;
		final double expectedTablePriceWithIncrease = 165.11;

		final List<Product> products = this.productManager.getProducts();
		Product product = products.get(0);
		assertEquals(expectedChairPriceWithIncrease, product.getPrice(), 0);

		product = products.get(1);
		assertEquals(expectedTablePriceWithIncrease, product.getPrice(), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIncreasePriceWithIllegalArgumentNegative() {
		this.productManager.increasePrice(NEGATIVE_PRICE_INCREASE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIncreasePriceWithIllegalArgumentOver() {
		this.productManager.increasePrice(OVER_PRICE_INCREASE);
	}
}
