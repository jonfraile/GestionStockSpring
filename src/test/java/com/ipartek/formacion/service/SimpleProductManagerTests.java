package com.ipartek.formacion.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ipartek.formacion.domain.Product;

public class SimpleProductManagerTests {

	private SimpleProductManager productManager;

	private List<Product> products;

	private static int PRODUCT_COUNT = 2;

	private static Double CHAIR_PRICE = new Double(20.50);
	private static String CHAIR_DESCRIPTION = "Chair";

	private static String TABLE_DESCRIPTION = "Table";
	private static Double TABLE_PRICE = new Double(150.10);

	@Before
	public void setUp() throws Exception {
		this.productManager = new SimpleProductManager();
		this.products = new ArrayList<Product>();

		// stub up a list of products
		Product product = new Product();
		product.setDescription(CHAIR_DESCRIPTION);
		product.setPrice(CHAIR_PRICE);
		this.products.add(product);

		product = new Product();
		product.setDescription(TABLE_DESCRIPTION);
		product.setPrice(TABLE_PRICE);
		this.products.add(product);

		this.productManager.setProducts(this.products);

	}

	@Test
	public void testGetProductsWithNoProducts() {
		this.productManager = new SimpleProductManager();
		assertNull(this.productManager.getProducts());
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

}
