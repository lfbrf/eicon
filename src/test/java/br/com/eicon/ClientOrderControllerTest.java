package br.com.eicon;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.eicon.service.ClientOrderService;

@ExtendWith(SpringExtension.class)
@WebMvcTest()
@RunWith(SpringJUnit4ClassRunner.class)
class ClientOrderControllerTest {
	
  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  private ClientOrderService clientOrderService;
  
  
  
  @Test
  void whenSendPosToClientOrdertShowuldReturnMessages() throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
				"\n" + 
				"<orders>\n" + 
				"<order>\n" + 
				"<numberControl>1</numberControl>\n" + 
				"<dateRegister>2002-05-30T09:00:00</dateRegister>\n" + 
				"<name>Produto 01</name>\n" + 
				"<quantity>2</quantity>\n" + 
				"<value>40</value>\n" + 
				"<clientCode>60</clientCode>\n" + 
				"</order>\n" + 
				"\n" + 
				"\n" + 
				"</orders>\n ";
	mockMvc.perform(post("/save").contentType(
	            MediaType.APPLICATION_XML).content(xml ))
			    .andExpect(status().isOk());
  }

  @Test
  void whenSearchToExistingKeyShowuldReturn200() throws Exception {
	 mockMvc.perform(get("/search?clientOrderSearch=Produtssssssso&numberControl=false&dateRegister=false&client=false&all=true")
			    .contentType("application/json"))
			    .andExpect(status().isOk());
  }

}