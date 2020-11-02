package br.com.eicon.dto;

import java.math.BigDecimal;
import java.util.Date;


public class ClientOrderInputDto {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	public ClientOrderInputDto() {
		this(new Date().toString(), 1);
	}
	 
	public ClientOrderInputDto(boolean valid, String message) {
		this.valid = valid;
		this.message = message;
	}
	
	public ClientOrderInputDto(String dateRegister, int quantity) {
		this.dateRegister = dateRegister;
		this.quantity = quantity;
	}
	
	public ClientOrderInputDto(int numberControl, String dateRegister, String name, int quantity, 
			BigDecimal value, int clientCode, BigDecimal totalValue ) {
		this.numberControl= numberControl;
		this.dateRegister = dateRegister;
		this.name = name;
		this.quantity = quantity;
		this.value = value;
		this.clientCode = clientCode;
		this.totalValue = totalValue;
	}

	private boolean valid;
	
	private String message;
	
	private int numberControl;
	
	private String dateRegister;
	
	private String name;
	
	private int quantity;
	
	private BigDecimal value;

	private BigDecimal totalValue;
	
	private int clientCode;
	
	public int getNumberControl() {
		return numberControl;
	}


	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setNumberControl(int numberControl) {
		this.numberControl = numberControl;
	}

	public String getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(String dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public int getClientCode() {
		return clientCode;
	}

	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}
	
	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return "ClientOrderDTO [numberControl=" + numberControl + ", dateRegister=" + dateRegister + ", name=" + name
				+ ", quantity=" + quantity + ", value=" + value + ", clientCode=" + clientCode + "]";
	}
}
