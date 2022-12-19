package br.com.comex.sql.main;

import javax.xml.ws.Endpoint;

import br.com.comex.ws.ComexWS;

public class MainComexWS {
	public static void main(String[] args) {		
		String url = "http://0.0.0.0:8080/ComexWS";
	    ComexWS service = new ComexWS();

	    System.out.println("Servico Rodando" + url + "?wsdl");
	    Endpoint.publish(url, service);
	}
}