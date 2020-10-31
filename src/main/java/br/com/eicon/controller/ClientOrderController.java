package br.com.eicon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.eicon.DTO.ClientOrderInputDTO;

@Controller
@RequestMapping("/api")
class ClientOrderController {
	@RequestMapping(value = {"/", "/teste/**", "/teste/**"})
    public String Test(){
        return "OK FUNCIONOU";
    }
    
    @PostMapping(path = "/save")
    public String customerInformation(@RequestBody ArrayList <ClientOrderInputDTO> order) {
        return "Customer information saved successfully ::." + order.toString();
    }
}
