package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Product;

public class SimpleProductManager implements ProductManager {

	private static final long serialVersionUID = 1L;

	private List<Product> products;

	@Override
	public void increasePrice(int percentage) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
