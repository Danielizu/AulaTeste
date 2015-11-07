package br.sceweb.modelo;
import java.text.*;
import java.util.Date;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;



public class Convenio {
	
	private String cnpj;
	private DateTime dataInicio;
	private DateTime dataTerminino;
	Logger logger = Logger.getLogger(Convenio.class);
	public String getCNPJ(){
	return cnpj;
	}


	public Object validaData(String dataInicio) {
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		df.setLenient (false); //
		try {
		df.parse (dataInicio); // data válida
		return true;
		} catch (ParseException ex) {
		logger.error("Erro na validacao de data - " + ex.getMessage());
		return false;
		}
	}
	
	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public DateTime getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(DateTime dataInicio) {
		this.dataInicio = dataInicio;
	}


	public DateTime getDataTerminino() {
		return dataTerminino;
	}


	public void setDataTerminino(DateTime dataTerminino) {
		this.dataTerminino = dataTerminino;
	}


	public Logger getLogger() {
		return logger;
	}


	public void setLogger(Logger logger) {
		this.logger = logger;
	}


	public void setDataInicio(String dataInicio) throws IllegalArgumentException {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>data inicio = " + dataInicio);
		if ((boolean) validaData(dataInicio)){
		this.dataInicio = new DateTime(Integer.parseInt(dataInicio.substring(6, 10)),
		Integer.parseInt(dataInicio.substring(3, 5)),
		Integer.parseInt(dataInicio.substring(0, 2)), 0, 0);
		}
		else{
		throw new IllegalArgumentException("data invalida");
		}
		
	}


		
}
