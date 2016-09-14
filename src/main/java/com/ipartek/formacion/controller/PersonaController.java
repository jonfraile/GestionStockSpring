package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ipartek.formacion.domain.Persona;
import com.ipartek.formacion.service.PersonaManager;

@Controller
public class PersonaController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private PersonaManager personaManager;

	@RequestMapping(value = "/personas")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.logger.info("Procesando peticion");

		// atributos == modelo
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("persons", this.personaManager.getAll());

		return new ModelAndView("personas", model);
	}

	public void setPersonaManager(PersonaManager personaManager) {
		this.personaManager = personaManager;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid Persona persona, BindingResult result) {
		// Si hay errores volver a pagina priceincrease.jsp
		if (result.hasErrors()) {
			return "insert-persona";
		}

		final String nombrePersona = persona.getNombre();
		this.logger.info("Persona insertada " + nombrePersona);

		// this.personaManager.setNombre(nombrePersona);

		return "redirect:/personas";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected Persona formBackingObject(HttpServletRequest request) throws ServletException {
		final Persona persona = new Persona();
		persona.setEdad(0);
		return persona;
	}
}
