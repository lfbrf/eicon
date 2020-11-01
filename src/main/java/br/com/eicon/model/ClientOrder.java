package br.com.eicon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import br.com.eicon.Dto.ClientOrderInputDto;


@Entity
public class ClientOrder implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ClientOrder() {}
	
	public ClientOrder(int numberControl, Date dateRegister, String name, int quantity, BigDecimal value, int clientCode) {
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
	private Date dateRegister = new Date();
	
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
