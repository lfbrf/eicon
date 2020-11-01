package br.com.eicon.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.eicon.Dao.ClientOrderDao;
import br.com.eicon.Dao.ClientOrderGroupDao;
import br.com.eicon.Dao.ClientOrderHistoryDao;
import br.com.eicon.Dto.ClientOrderInputDto;
import br.com.eicon.Dto.ClientOrderOutputDto;
import br.com.eicon.Utils.Message;
import br.com.eicon.Utils.Util;
import br.com.eicon.model.ClientOrder;
import br.com.eicon.model.ClientOrderGroup;
import br.com.eicon.model.ClientOrderHistory;
import br.com.eicon.service.ClientOrderService;

@Component
public class ClientOrderServiceImpl implements ClientOrderService {
	
	private ArrayList <ClientOrderInputDto> clientOrdersInput = new ArrayList<>();
	private ArrayList <ClientOrder> clientOrder = new ArrayList<>();
	private ArrayList <ClientOrderHistory> clientOrderHistory = new ArrayList<>();
	private  ClientOrderGroup clientOrderGroup = new ClientOrderGroup();
	private int quantity = 0;
	private BigDecimal total = new BigDecimal(0);
	
	@Autowired
	private ClientOrderDao clientOrderDao;
	
	@Autowired
	private ClientOrderHistoryDao clientOrderHistoryDao;
	
	@Autowired
	private ClientOrderGroupDao clientOrderGroupDao;

	private boolean isQuantityOrderAlowed(ArrayList <ClientOrderInputDto> clientOrders) {
		return clientOrders.size() > 0 && clientOrders.size() < 10;
	}
	
	private boolean isOrderAlreadySaved(int numberControl) {
		return clientOrderDao.findOrdersByNumber(numberControl).size() > 0;
	}
	
	private boolean isOrderInSameList(ClientOrderInputDto clientOrderInputDto) {
		return clientOrder.stream().filter(co -> co.getNumberControl() == clientOrderInputDto.getNumberControl()).collect(Collectors 
                .toCollection(ArrayList::new)).size() > 0;
	}
	
	private boolean validateOrder(ClientOrderInputDto order) {
		return !isOrderInSameList(order) && !isOrderAlreadySaved(order.getNumberControl());
	}
	
	private double getOfDicount(int quantity) {
		return quantity > 10 ? 0.10 : (quantity > 5 ? 0.05 : 0); 
	}
	
	private BigDecimal getValueWithDiscount(BigDecimal totalValue, int quantity) {
		totalValue = totalValue.multiply(new BigDecimal(quantity));
		double discount =  getOfDicount(quantity);
		return discount == 0 || totalValue.equals(new BigDecimal(0)) ?  totalValue :  
			totalValue.subtract(new BigDecimal((discount)).multiply(totalValue));
	}
	
	private void setClientOrder(ClientOrderInputDto clientOrderInputDto) {
		
		clientOrder.add(new ClientOrder(clientOrderInputDto));
	}
	
	private void setClientHistory(ClientOrderInputDto clientOrderInputDto) {
		clientOrderHistory.add(new ClientOrderHistory(clientOrderInputDto));
	}
	
	private boolean hasMandatoryFields(ClientOrderInputDto clientOrderInputDto) {
		return clientOrderInputDto.getName() != null && clientOrderInputDto.getValue() != null && clientOrderInputDto.getClientCode() != 0
				&& clientOrderInputDto.getNumberControl() != 0;
	}
	
	private ArrayList<ClientOrderOutputDto> setClientOrder(ArrayList <ClientOrderOutputDto> resultOutputDto) {
		for (ClientOrderInputDto clientOrderInput: clientOrdersInput) {
			boolean valid = hasMandatoryFields(clientOrderInput) && validateOrder(clientOrderInput);
			ClientOrder clientOrder = new ClientOrder(clientOrderInput);
			String message = Message.REPEATED_CONTROL;
			clientOrderInput.setValid(valid);
			if (!hasMandatoryFields(clientOrderInput)) {
				message = Message.MANDATORY_FIELDS;
			}
			else if (valid) {
				message = Message.SUCCESS;
				BigDecimal value = new BigDecimal(0);
				value = getValueWithDiscount(clientOrder.getValue(), clientOrder.getQuantity());
				total = total.add(value);
				quantity += clientOrder.getQuantity();
				clientOrderInput.setTotalValue(value);
				setClientOrder(clientOrderInput);
				message = Util.convertMessage(message, clientOrderInput.getNumberControl() + "");
				clientOrderInput.setMessage(message);
			}
			message = Util.convertMessage(message, clientOrderInput.getNumberControl() + "");
			resultOutputDto.add(new ClientOrderOutputDto(clientOrder.getNumberControl(), message , valid));
			clientOrderInput.setMessage(message);
			setClientHistory(clientOrderInput);
		}
		return resultOutputDto;
	}
	
	private void setClientOrder() {
		for (ClientOrderInputDto clientOrderInput: clientOrdersInput) {
			clientOrderInput.setValid(false);
			clientOrderInput.setMessage(Message.NOT_ALOWED);
			setClientHistory(clientOrderInput);
		}
	}
	
	private ArrayList <ClientOrderOutputDto> clientOrdersInputToOutput(){
		ArrayList <ClientOrderOutputDto> resultOutputDto = new ArrayList<>();
		if (!isQuantityOrderAlowed(clientOrdersInput)) {
			resultOutputDto.add(new ClientOrderOutputDto(0, Message.NOT_ALOWED, false));
			clientOrderGroup = new ClientOrderGroup(0, new BigDecimal(0));
			setClientOrder();
			return resultOutputDto;
		}
		resultOutputDto = setClientOrder(resultOutputDto);
		clientOrderGroup = new ClientOrderGroup(quantity, total);
		return resultOutputDto;
	}
	
	private void saveClientOrders() {
		if (clientOrderGroup.getId() != null) {
			for (ClientOrder order: clientOrder ) {
				order.setClientOrderGroup(clientOrderGroup);
				clientOrderDao.persist(order);
			}
			for (ClientOrderHistory clientOrderHistory: clientOrderHistory) {
				clientOrderHistory.setClientOrderGroup(clientOrderGroup);
				clientOrderHistoryDao.persist(clientOrderHistory);
			}
		}
	}
	
	@Transactional
	public ArrayList<ClientOrderOutputDto> saveClientOrderIfValid(ArrayList <ClientOrderInputDto> clientOrdersInput) {
		this.clientOrdersInput = clientOrdersInput;
		total = new BigDecimal(0);
		quantity = 0;
		ArrayList<ClientOrderOutputDto> resultOutputDto = new ArrayList<>();
		try {
			resultOutputDto = clientOrdersInputToOutput();
			clientOrderGroupDao.persist(clientOrderGroup);
			saveClientOrders();
		}catch(Exception ex) {
			System.out.println("EX " + ex.getMessage());
		}

	
		return resultOutputDto;
	}

}
