package br.com.eicon.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;


@Entity
public class ClientOrderGroup implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private Long id;
	
	@NotBlank
	private int quantity;
	
	@NotBlank
	private BigDecimal totalValue;
	
	@OneToMany(mappedBy = "clientOrderGroup", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<ClientOrder> clientOrders = new ArrayList<>();
	
	@OneToMany(mappedBy = "clientOrderGroup", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<ClientOrderHistory> clientOrderHistory = new ArrayList<>();

	public ClientOrderGroup() {
		
	}
	
	public ClientOrderGroup(int quantity, BigDecimal totalValue) {
		this.quantity = quantity;
		this.totalValue = totalValue;
	}
	
	public ClientOrderGroup(int quantity, BigDecimal totalValue, List<ClientOrder> clientOrders) {
		this.quantity = quantity;
		this.totalValue = totalValue;
		this.clientOrders = clientOrders;
	}
	
	public ClientOrderGroup(List<ClientOrder> clientOrders) {
		this.clientOrders = clientOrders;
	}
	
	public List<ClientOrder> getClientOrders() {
		return clientOrders;
	}

	public void setClientOrders(List<ClientOrder> clientOrders) {
		this.clientOrders = clientOrders;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ClientOrderHistory> getClientOrderHistory() {
		return clientOrderHistory;
	}

	public void setClientOrderHistory(List<ClientOrderHistory> clientOrderHistory) {
		this.clientOrderHistory = clientOrderHistory;
	}
}
