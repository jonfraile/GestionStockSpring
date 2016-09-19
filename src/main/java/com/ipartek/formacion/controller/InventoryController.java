package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping(value = "/product/inventario", method = RequestMethod.GET)
	public ModelAndView listarInventario() {

		this.logger.info("procesando peticion");

		// atributos == modelo
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("products", this.productManager.getProducts());
		model.put("fecha", new Date().toString());

		return new ModelAndView("product/inventario", model);

	}

	/**
	 * Muestra formulario para crear nuevo producto
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/iventario/nuevo", method = RequestMethod.GET)
	public ModelAndView mostrarFormulario() {

		this.logger.trace("Mostrar formulario crear nuevo producto");

		// atributos == modelo
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("product", new Product());

		return new ModelAndView("product/form", model);

	}

	@RequestMapping(value = "/iventario/nuevo", method = RequestMethod.POST)
	public String crear(@Valid Product product, BindingResult result) {

		this.logger.trace("Creando producto");
		// Si hay errores volver pagina priceincrease.jsp
		if (result.hasErrors()) {
			this.logger.warn("Parametros no validos");
			return "product/form";
		}
		// atributos == modelo
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("product", this.productManager.insertar(product));
		this.logger.trace("producto creado");

		return "redirect:/product/inventario";
	}

	@RequestMapping(value = "/inventario/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView verDetalle(@PathVariable(value = "id") final long id) {

		this.logger.trace("Detalle producto " + id);

		final Map<String, Object> model = new HashMap<String, Object>();

		model.put("product", this.productManager.getById(id));

		return new ModelAndView("product/form", model);
	}

	@RequestMapping(value = "/inventario/eliminar/{id}", method = RequestMethod.GET)
	public void eliminar(@PathVariable(value = "id") final long id) {

		this.logger.trace("Eliminado" + id);

		final Map<String, Object> model = new HashMap<String, Object>();
		String msg = "No se ha podido eliminar";

		if (this.productManager.eliminar(id)) {
			msg = "producto " + id + " eliminado";
			this.logger.info(msg);

		} else {
			this.logger.warn(msg);
		}

		model.put("msg", msg);

		listarInventario();

	}

}
