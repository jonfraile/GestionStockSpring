package com.ipartek.formacion.controller;

import java.io.IOException;
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
}
