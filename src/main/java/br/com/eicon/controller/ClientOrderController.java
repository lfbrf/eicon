package br.com.eicon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.eicon.dto.ClientOrderInputDto;
import br.com.eicon.dto.ClientOrderOutputDto;
import br.com.eicon.model.ClientOrder;
import br.com.eicon.service.ClientOrderService;

@Controller
@RequestMapping("/")
class ClientOrderController {
	@Autowired
	private ClientOrderService clientOrderService;
	
	@RequestMapping(value = "/")
    public String clientOrderHome(Model model){
		ArrayList<ClientOrderInputDto> orders = new ArrayList <ClientOrderInputDto>();
		orders.add(new ClientOrderInputDto());
		model.addAttribute("orders", orders );
        return "index";
    }
	
	@RequestMapping(value = {"/search", "/search/"})
    public @ResponseBody List<ClientOrder> searchClientOrder(
    		@RequestParam(name="clientOrderSearch", required = false, defaultValue = "") String clientOrderSearch, 
    		@RequestParam(name="numberControl", required = false, defaultValue = "false")  boolean numberControl, 
    		@RequestParam(name="dateRegister", required = false, defaultValue = "false") boolean dateRegister,
    		@RequestParam(name="client", required = false, defaultValue = "false") boolean client , 
    		@RequestParam(name="all", required = false, defaultValue = "false") boolean all){
		return clientOrderService.searchClientOrder(clientOrderSearch, numberControl, dateRegister, client, all);
    }
	
	@PostMapping(path = {"/save" , "/save/" }, produces = "application/json")
    public @ResponseBody  List<ClientOrderOutputDto> clientOrder(@RequestBody  List<ClientOrderInputDto> order) {
    	return clientOrderService.saveClientOrderIfValid(order);
    }
    
}
