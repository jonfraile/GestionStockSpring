package com.ipartek.formacion.repository;

import java.io.Serializable;
import java.util.List;

import com.ipartek.formacion.domain.Product;

public interface InventarioDAO extends Serializable, DAOSetter {

	void increasePrice(int percentage);

	List<Product> getProducts();

}