package br.com.eicon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table()
public class ClientOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public ClientOrder() {}
	
	
	@NotBlank
	@Column(unique = true)
	private int numberControl;
	
	@NotBlank
	private Date dateRegister;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private int quantity;
	
	@NotBlank
	private BigDecimal value;
	
	@NotBlank
	private BigDecimal totalValue;
	
	@NotBlank
	private int clientCode;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;
	
	
	public int getNumberControl() {
		return numberControl;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
