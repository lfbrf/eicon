package br.com.eicon.service;

import java.util.ArrayList;

import br.com.eicon.DTO.ClientOrderInputDTO;
import br.com.eicon.DTO.ClientOrderOutputDTO;

public interface ClientOrderService {
	ArrayList<ClientOrderOutputDTO>  validateOrders(ArrayList <ClientOrderInputDTO> clientOrders);
}
