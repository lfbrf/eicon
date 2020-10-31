package br.com.eicon;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
class MessageController {
    @RequestMapping("/message")
    public String Message(){
        return "OK FUNCIONOU";
    }
}