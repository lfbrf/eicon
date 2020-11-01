package br.com.eicon.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.eicon.Dto.ClientOrderInputDto;

@Entity
public class ClientOrderHistory {
	
	public ClientOrderHistory() {}
	
	public ClientOrderHistory(ClientOrderInputDto clientOrderInputDto) {
		this.numberControl = clientOrderInputDto.getNumberControl();
		this.dateRegister = clientOrderInputDto.getDateRegister();
		this.name = clientOrderInputDto.getName();
		this.quantity = clientOrderInputDto.getQuantity();
		this.value = clientOrderInputDto.getValue();
		this.clientCode = clientOrderInputDto.getClientCode();
		this.valid = clientOrderInputDto.isValid();
		this.messageStatus = clientOrderInputDto.getMessage();
		dateOfSignUpRegister = new Date();
	}

	private Date dateOfSignUpRegister;

	private Date dateRegister;
	
	private String name;
	
	private int quantity;
	
	private BigDecimal value;
	
	private boolean valid;	

	private int clientCode;
	
	private String messageStatus;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;
	
	@ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="group_id", updatable = false)
    private ClientOrderGroup clientOrderGroup;

	private int numberControl;
	
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

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public int getClientCode() {
		return clientCode;
	}

	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClientOrderGroup getClientOrderGroup() {
		return clientOrderGroup;
	}

	public void setClientOrderGroup(ClientOrderGroup clientOrderGroup) {
		this.clientOrderGroup = clientOrderGroup;
	}

	public Date getDateOfSignUpRegister() {
		return dateOfSignUpRegister;
	}

	public void setDateOfSignUpRegister(Date dateOfSignUpRegister) {
		this.dateOfSignUpRegister = dateOfSignUpRegister;
	}
}
