package br.sceweb.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpresaDAOImp implements EmpresaDAO2{
	

	public int adiciona(Empresa empresa) {
		
		PreparedStatement ps;
		int codigoRetorno = 0;
		
		try (Connection con = new FabricaDeConexoes().getConnection()){
			ps = con.prepareStatement("INSERT into Empresa(cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone) VALUES (?,?,?,?,?);");
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getNomeDaEmpresa());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setString(4, empresa.getEndereco());
			ps.setString(5, empresa.getTelefone());
			
			codigoRetorno = ps.executeUpdate();
			
			ps.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return codigoRetorno;
	}

	@Override
	public Empresa consulta(String cnpj) {
	
		return null;
	}

	@Override
	public List consultaEmpresas() {
		
		return null;
	}

	@Override
	public boolean alterar(Empresa empresa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int excluir(String cnpj) {
		
		int codigoRetorno = 0;

		PreparedStatement ps;
		try (Connection con = new FabricaDeConexoes().getConnection()){
			ps = con.prepareStatement("Delete from Empresa where cnpj = ?;");
			ps.setString(1, cnpj);
			codigoRetorno = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
				
		return codigoRetorno;
	}

}
