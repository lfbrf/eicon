package br.com.eicon.service;

import java.util.ArrayList;

import br.com.eicon.Dto.ClientOrderInputDto;
import br.com.eicon.Dto.ClientOrderOutputDto;

public interface ClientOrderService {
	ArrayList<ClientOrderOutputDto>  saveClientOrderIfValid(ArrayList <ClientOrderInputDto> clientOrders);
}
