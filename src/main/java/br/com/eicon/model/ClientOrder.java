package br.com.eicon.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.eicon.dto.ClientOrderInputDto;
import br.com.eicon.util.Util;


@Entity
public class ClientOrder implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@SuppressWarnings("rawtypes")
	public ClientOrder(Map map) {
		this.totalValue = (BigDecimal) map.get("total_value");
		this.quantity = (int) map.get("quantity");
		this.name = (String) map.get("name");
		this.value = (BigDecimal) map.get("value");
		this.dateRegister =  (String) map.get("date_register");
		this.clientCode = (int) map.get("client_code");
		this.numberControl = (@NotBlank int) map.get("number_control");
		this.id = Util.convertToLong(map.get("order_id"));
	}
	
	public ClientOrder() {}
	
	public ClientOrder(int numberControl, String dateRegister, String name, int quantity, BigDecimal value, int clientCode) {
		this.numberControl = numberControl;
		this.dateRegister = dateRegister;
		this.name = name;
		this.quantity = quantity;
		this.value = value;
		this.clientCode = clientCode;
	}


	
	public ClientOrder(ClientOrderInputDto clientOrderInputDto) {
		this.numberControl = clientOrderInputDto.getNumberControl();
		this.dateRegister = clientOrderInputDto.getDateRegister();
		this.name = clientOrderInputDto.getName();
		this.quantity = clientOrderInputDto.getQuantity();
		this.value = clientOrderInputDto.getValue();
		this.clientCode = clientOrderInputDto.getClientCode();
		this.totalValue = clientOrderInputDto.getTotalValue();
	}


	@NotBlank
	@Column(unique = true)
	private int numberControl;
	
	@NotBlank
	private String dateRegister = new Date().toString();
	
	@NotBlank
	private String name;
	
	@NotBlank
	private int quantity = 1;
	
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

	@ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="group_id", updatable = false)
    private ClientOrderGroup clientOrderGroup;

	public ClientOrderGroup getClientOrderGroup() {
		return clientOrderGroup;
	}

	public void setClientOrderGroup(ClientOrderGroup clientOrderGroup) {
		this.clientOrderGroup = clientOrderGroup;
	}

	public int getNumberControl() {
		return numberControl;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return "ClientOrder [numberControl=" + numberControl + ", dateRegister=" + dateRegister + ", name=" + name
				+ ", quantity=" + quantity + ", value=" + value + ", totalValue=" + totalValue + ", clientCode="
				+ clientCode + ", id=" + id + ", clientOrderGroup=" + clientOrderGroup + "]";
	}
	
}
