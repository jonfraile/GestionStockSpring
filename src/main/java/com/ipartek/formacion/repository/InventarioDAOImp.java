package com.ipartek.formacion.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Product;
import com.ipartek.formacion.repository.mapper.ProductMapper;

@Repository("inventarioDAOImp")
public class InventarioDAOImp implements InventarioDAO {

	private static final long serialVersionUID = 1L;

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	private static final Logger logger = LoggerFactory.getLogger(InventarioDAOImp.class);

	@Override
	public void increasePrice(int percentage) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getProducts() {
		List<Product> productos = new ArrayList<Product>();

		final String SQL = "SELECT id,description,price FROM products;";
		try {
			productos = this.jdbctemplate.query(SQL, new ProductMapper());
		} catch (final EmptyResultDataAccessException e) {
			logger.warn("No existen productos " + SQL);
			productos = new ArrayList<Product>();
		} catch (final Exception e) {
			logger.error(e.getMessage());
		}

		return productos;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}
}
