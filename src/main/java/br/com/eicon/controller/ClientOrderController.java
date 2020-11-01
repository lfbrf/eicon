package br.com.eicon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.eicon.Dao.ClientOrderDao;
import br.com.eicon.Dto.ClientOrderInputDto;
import br.com.eicon.Dto.ClientOrderOutputDto;
import br.com.eicon.service.ClientOrderService;

@Controller
@RequestMapping("/")
class ClientOrderController {
	@Autowired
	private ClientOrderService clientOrderService;
	
	@RequestMapping(value = {"/"})
    public String clientOrder(Model model){
		ArrayList<ClientOrderInputDto> orders = new ArrayList <ClientOrderInputDto>();
		orders.add(new ClientOrderInputDto());
		model.addAttribute("orders", orders );
        return "index";
    }
	
	@PostMapping(path = "/save", produces = "application/json")
    public @ResponseBody  ArrayList<ClientOrderOutputDto> clientOrder(@RequestBody  ArrayList <ClientOrderInputDto> order) {
    	return clientOrderService.saveClientOrderIfValid(order);
    }
    
}
