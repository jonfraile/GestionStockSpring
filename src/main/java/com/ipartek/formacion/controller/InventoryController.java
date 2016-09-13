package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.service.ProductManager;

@Controller
public class InventoryController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ProductManager productManager;

	@RequestMapping(value = "/inventario")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.logger.info("Procesando peticion");

		// atributos == modelo
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("products", this.productManager.getProducts());
		model.put("fecha", new Date().toString());

		return new ModelAndView("inventario", model);
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

}