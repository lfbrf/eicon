package br.com.eicon.DTO;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClientOrderInputDTO {
	
	public ClientOrderInputDTO() {
		this(new Date(), 1);
	}
	
	public ClientOrderInputDTO(Date dateRegister, int quantity) {
		this.dateRegister = dateRegister;
		this.quantity = quantity;
	}
	
	public ClientOrderInputDTO(int numberControl, Date dateRegister, String name, int quantity, 
			BigDecimal value, int clientCode ) {
		this.numberControl= numberControl;
		this.dateRegister = dateRegister;
		this.name = name;
		this.quantity = quantity;
		this.value = value;
		this.clientCode = clientCode;
	}
	
	private int numberControl;
	
	private Date dateRegister;
	
	private String name;
	
	private int quantity;
	
	private BigDecimal value;
	
	private int clientCode;
	
	public int getNumberControl() {
		return numberControl;
	}

	@Override
	public String toString() {
		return "ClientOrderDTO [numberControl=" + numberControl + ", dateRegister=" + dateRegister + ", name=" + name
				+ ", quantity=" + quantity + ", value=" + value + ", clientCode=" + clientCode + "]";
	}

	public void setNumberControl(int numberControl) {
		this.numberControl = numberControl;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
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


}
