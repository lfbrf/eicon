package br.com.eicon.DTO;

import br.com.eicon.Utils.Messages;

public class ClientOrderOutputDTO {
	private int numberControl;
	private Messages messages;
	
	public int getNumberControl() {
		return numberControl;
	}
	public void setNumberControl(int numberControl) {
		this.numberControl = numberControl;
	}
	public Messages getMessages() {
		return messages;
	}
	public void setMessages(Messages messages) {
		this.messages = messages;
	}
}
