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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.domain.Product;
import com.ipartek.formacion.service.ProductManager;

@Controller
public class InventoryController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ProductManager productManager;

	/**
	 * Mostrar listado de todos los productos del inventario
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView "inventario.jsp", model:{ArrayList &lt;Product&gt;
	 *         "product",String "fecha"}
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/inventario", method = RequestMethod.GET)
	public ModelAndView listarInventario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.logger.info("procesando peticion");

		// atributos == modelo
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("products", this.productManager.getProducts());
		model.put("fecha", new Date().toString());

		return new ModelAndView("inventario", model);

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("producto") @Validated Product producto, BindingResult bindingResult,
			Model model) {
		String destino = "";

		if (bindingResult.hasErrors()) {
			this.logger.info("Producto con errores");
			destino = "inventario";
		} else {
			this.logger.info("Producto correcto");
			destino = "inventario";
		}
		return destino;
	}

}
