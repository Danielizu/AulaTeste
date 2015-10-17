package br.sceweb.modelo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class FabricadeConexoes {
	
	public Connection getConnection(){
		String url = "jdbc:mysql://localhost/sceweb";
		
		try {
			return DriverManager.getConnection(url,"root", "aluno");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
