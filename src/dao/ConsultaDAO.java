package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import entities.Consulta;

public class ConsultaDAO {
private Connection conn;
	
	public ConsultaDAO(Connection conn) {

		this.conn = conn;
	}
	
	public void agendar(Consulta consulta) throws SQLException{
		PreparedStatement st=null;
		try {
			st=conn.prepareStatement("insert into consulta (nomepaciente,nomemedico,data,hora)values(?,?,?,?)");
			st.setString(1,consulta.getNomepaciente());
			st.setString(2,consulta.getNomemedico());
			st.setString(3,consulta.getData());
			st.setString(4,consulta.getHora());
			st.executeUpdate();
		}finally{
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();	
		}
		
	}
	
	
	
	
}
