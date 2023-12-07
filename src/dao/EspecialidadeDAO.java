package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Especialidades;

public class EspecialidadeDAO {
	private Connection conn;
	
	public EspecialidadeDAO(Connection conn) {

		this.conn = conn;
	}
	
	
	public void cadastrar(Especialidades especialidade) throws SQLException{
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("insert into especialidades (especialidade,codigo) values (?,?)");
			st.setString(1,especialidade.getEspecialidade());
			st.setString(2, especialidade.getCodigo());
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
		
	}
	
	public List<Especialidades> buscarTodas() throws SQLException{
		PreparedStatement st = null;
		ResultSet rs=null;
		try {
			st=conn.prepareStatement("select * from especialidades group by especialidade");
			rs=st.executeQuery();
			List<Especialidades> lista= new ArrayList<>();
			while(rs.next()) {
				Especialidades especialidade = new Especialidades();
				especialidade.setCodigo(rs.getString("codigo"));
				especialidade.setEspecialidade(rs.getString("especialidade"));
				lista.add(especialidade);
			}
			return lista;
				
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	

}
