package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Product;
import com.ipartek.formacion.repository.InventarioDAO;

@Service("productManager")
public class SimpleProductManager implements ProductManager {

	private static final long serialVersionUID = 1L;

	Product p = null;
	@Autowired
	private InventarioDAO inventarioDAOImp;

	private List<Product> products;

	@Override
	public void increasePrice(int percentage) throws IllegalArgumentException {

		this.inventarioDAOImp.increasePrice(percentage);

	}

	@Override
	public List<Product> getProducts() {
		this.products = this.inventarioDAOImp.getProducts();
		return this.products;
	}

	@Override
	public Product getById(long id) {
		return this.inventarioDAOImp.getById(id);
	}

	@Override
	public boolean eliminar(long id) {
		return this.inventarioDAOImp.eliminar(id);

	}

	@Override
	public boolean insertar(Product p) {
		return this.inventarioDAOImp.insertar(p);
	}

	@Override
	public boolean modificar(Product p) {
		return this.inventarioDAOImp.modificar(p);
	}

}