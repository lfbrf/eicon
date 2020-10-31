package br.com.eicon.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

import br.com.eicon.DTO.ClientOrderInputDTO;
import br.com.eicon.DTO.ClientOrderOutputDTO;
import br.com.eicon.service.ClientOrderService;

public class ClientOrderServiceImpl implements ClientOrderService {
	
	private ArrayList<ClientOrderOutputDTO> clientOrdersOutput;
	ArrayList <ClientOrderInputDTO> clientOrdersInput;

	private boolean isQuantityOrderAlowed(ArrayList <ClientOrderInputDTO> clientOrders) {
		return clientOrders.size() > 0 && clientOrders.size() < 10;
	}
	
	private boolean isOrderAlreadySaved(ClientOrderInputDTO order) {
		return false;
	}
	
	private boolean isOrderInSameList(ClientOrderInputDTO order) {
		return clientOrdersInput.stream().filter(co -> co.getNumberControl() == order.getNumberControl()).collect(Collectors 
                .toCollection(ArrayList::new)).size() > 1;
	}
	
	private boolean validateOrder(ClientOrderInputDTO order) {
		return isOrderInSameList(order) && isOrderAlreadySaved(order);
	}
	
	private int getPercentDiscount(int quantity) {
		return quantity > 10 ? 10 : (quantity > 5 ? 5 : 0); 
	}
	
	@Override
	public ArrayList<ClientOrderOutputDTO> validateOrders(ArrayList <ClientOrderInputDTO> clientOrdersInput) {
		this.clientOrdersInput = clientOrdersInput;
		return clientOrdersOutput;
	}

}
