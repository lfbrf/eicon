package br.com.eicon.service;

import java.util.List;

import br.com.eicon.dto.ClientOrderInputDto;
import br.com.eicon.dto.ClientOrderOutputDto;
import br.com.eicon.model.ClientOrder;

public interface ClientOrderService  {
	List<ClientOrderOutputDto>  saveClientOrderIfValid(List <ClientOrderInputDto> clientOrders);
	List<ClientOrder> searchClientOrder(String clientOrderSearch, boolean numberControl, boolean dateRegister, boolean client 
			, boolean all);
}
