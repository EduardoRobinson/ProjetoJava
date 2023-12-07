package service;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.BancoDados;
import entities.Consulta;
import dao.ConsultaDAO;

public class ConsultaService {
	
	public ConsultaService() {
		
	}
	public void agendar(Consulta consulta) throws SQLException, IOException{
		Connection conn=BancoDados.conectar();
		new ConsultaDAO(conn).agendar(consulta);
	}

}
