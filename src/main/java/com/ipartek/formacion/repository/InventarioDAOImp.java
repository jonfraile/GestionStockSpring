package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
		// TODO callableStatement

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

	@Override
	public Product getById(long id) {
		Product p = null;
		// TODO CAMBIAR POR preparedStatement o callableStatement
		final String SQL = "SELECT id,description,price FROM products where id =" + id;
		try {
			p = this.jdbctemplate.queryForObject(SQL, new ProductMapper());
		} catch (final EmptyResultDataAccessException e) {
			logger.warn("No existe producto con id= " + id);
			p = null;
		} catch (final Exception e) {
			logger.error(e.getMessage());
			p = null;
		}

		return p;
	}

	@Override
	public boolean eliminar(long id) {
		boolean resul = false;
		// TODO CAMBIAR POR preparedStatement o callableStatement
		final String SQL = "DELETE FROM `products` WHERE  `id`=" + id;

		if (1 == this.jdbctemplate.update(SQL)) {
			resul = true;
		}

		return resul;
	}

	@Override
	public boolean insertar(final Product p) {
		boolean resul = false;
		int affectedRows = 0;

		final KeyHolder keyHolder = new GeneratedKeyHolder();
		final String SQL = "INSERT INTO `products` (`description`, `price`) VALUES (? , ? )";
		affectedRows = this.jdbctemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				final PreparedStatement ps = conn.prepareStatement(SQL);
				ps.setString(1, p.getDescription());
				ps.setDouble(2, p.getPrice());
				return ps;
			}
		}, keyHolder);

		// p.setId(keyHolder.getKey().longValue());

		if (affectedRows != 0) {
			resul = true;
		}

		return resul;
	}

	@Override
	public boolean modificar(Product p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}
}
