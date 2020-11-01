package br.com.eicon.Dto;

import br.com.eicon.Utils.Message;

public class ClientOrderOutputDto {
	private int numberControl;
	private String messages;
	private boolean valid;
	
	public ClientOrderOutputDto(int numberControl, String message, boolean valid) {
		this.numberControl = numberControl;
		this.messages = message;
		this.valid = valid;
	}
	
	public int getNumberControl() {
		return numberControl;
	}
	public void setNumberControl(int numberControl) {
		this.numberControl = numberControl;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
