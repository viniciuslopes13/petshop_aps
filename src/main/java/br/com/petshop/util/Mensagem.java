package br.com.petshop.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Mensagem {

	public static void exibir(Severity severity, String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		msg.setSeverity(severity);
		FacesContext.getCurrentInstance().addMessage("",msg);
	}
	
}
