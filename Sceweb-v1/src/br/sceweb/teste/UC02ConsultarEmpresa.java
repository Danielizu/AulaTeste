package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAOImp;

public class UC02ConsultarEmpresa {
	
	static EmpresaDAOImp empresaDAO;
	static Empresa empresa;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		empresaDAO = new EmpresaDAOImp();
		empresa = new Empresa();
		
		empresa.setCnpj("89424232000180");
		empresa.setNomeDaEmpresa("Pennywise's Circus");
		empresa.setNomeFantasia("Circo do Pennywise");
		empresa.setEndereco("Avenida Águia de Haia");
		empresa.setTelefone("1125634851");
		
	}
	
		
	@Test
	public void CT01ConsultarEmpresaComSucesso() {
		empresaDAO.adiciona(empresa);
		assertTrue (empresa.equals (empresaDAO.consultaEmpresas("89424232000180")));
		empresaDAO.excluir ("89424232000180");
		
	}
	
	/*
	@Test
	public void CT02ConsultarEmpresaComSucesso (){
		empresaDAO.adiciona(empresa);
		Empresa empresateste = new Empresa ();
		empresateste.setCnpj("60409075000152");
		empresateste.setNomeDaEmpresa("Nestle");
		empresateste.setNomeFantasia("Comercio de Chocolates");
		empresateste.setEndereco("Rua Ganges");
		empresateste.setTelefone("1120173224");
		empresaDAO.adiciona(empresateste);
		assertTrue (empresa.equals (empresateste));
		empresaDAO.excluir (null);
		empresaDAO.excluir (null);
		
	}
	
	*/
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	


}
