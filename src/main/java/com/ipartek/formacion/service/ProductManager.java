package com.ipartek.formacion.service;

import java.io.Serializable;
import java.util.List;

import com.ipartek.formacion.domain.Product;

public interface ProductManager extends Serializable {

	public void increasePrice(int percentage);

	public List<Product> getProducts();
}
