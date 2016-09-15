package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipartek.formacion.domain.Product;
import com.ipartek.formacion.repository.ProductDao;

@Component
public class SimpleProductManager implements ProductManager {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getProducts() {
		return this.productDao.getProductList();
	}

	@Override
	public void increasePrice(int percentage) {
		final List<Product> products = this.productDao.getProductList();
		if (products != null) {
			for (final Product product : products) {
				final double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
				product.setPrice(newPrice);
				this.productDao.saveProduct(product);
			}
		}
	}

}
