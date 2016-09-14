package com.ipartek.formacion.service.validation;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PriceIncrease {

	protected final Log logger = LogFactory.getLog(getClass());

	@Min(0)
	@Max(50)
	private int percentage;

	@AssertTrue(message = "Debe de validar")
	private boolean confirmar;

	public boolean isConfirmar() {
		return this.confirmar;
	}

	public void setConfirmar(boolean confirmar) {
		this.confirmar = confirmar;
		this.logger.info("Validado " + confirmar);
	}

	public int getPercentage() {
		return this.percentage;
	}

	public void setPercentage(int porcentaje) {
		this.percentage = porcentaje;
		this.logger.info("Percentage set to " + porcentaje);
	}
}