package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Convenio;
import br.sceweb.modelo.ConvenioDAO;

public class UC05CadastrarConvenio {
	
	static ConvenioDAO convenioDAO;

	
	static Convenio convenio;
	static String dataInicio;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	convenioDAO = new ConvenioDAO();
	convenio = new Convenio();
	
	}
	/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		convenio = new Convenio();
		dataInicio = "07/11/2015";
	}
*/	
	@Test
	public void CT05UC05CadastrarConvenio_com_sucesso() {
		convenioDAO.adiciona(convenio);
		assertTrue (convenio.equals(convenioDAO.adiciona(convenio)));
		convenioDAO.exclui(convenio.getCNPJ());
	}

	
	
	
	@Test
	public void CT01UC05CadastrarConvenio_com_sucesso_data_valida() {
	dataInicio = "07/11/2015";
	assertTrue(convenio.validaData(dataInicio));
	}
	
	
	
	private void assertTrue(Object validaData) {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void CT02UC05CadastrarConvenio_com_data_invalida() {
	dataInicio = "42/04/2015";
	assertFalse(convenio.validaData(dataInicio));
	}

	private void assertFalse(Object validaData) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Test
	public void CT03UC05CadastrarConvenio_com_sucesso_data_valida() {
	dataInicio = "07/11/2015";
	convenio.setDataInicio(dataInicio);
	assertTrue(dataInicio.equals(convenio.getDataInicio()));
	}

	
	
	
	@Test(expected=IllegalArgumentException.class)
	
	public void CT04UC05CadastrarConvenio_com_data_invalida() {
		dataInicio = "242/10/2015";	
	assertFalse(convenio.validaData(dataInicio));
	//convenio.setDataInicio("242/10/2015");
	}
	
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}
	
}
