package com.ipartek.formacion.domain;

import java.io.Serializable;

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [nombre=" + this.nombre + "]";
	}

}
