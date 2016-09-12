package com.ipartek.formacion.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {

	private Product product;

	@Before
	public void setUp() throws Exception {
		this.product = new Product();
	}

	@Test
	public void testSetAndGetDescription() {
		final String testDescription = "aDescription";
		assertNull(this.product.getDescription());
		this.product.setDescription(testDescription);
		assertEquals(testDescription, this.product.getDescription());
	}

	@Test
	public void testSetAndGetPrice() {
		final double testPrice = 100.00;
		assertEquals(0, 0, 0);
		this.product.setPrice(testPrice);
		assertEquals(testPrice, this.product.getPrice(), 0);
	}

}
