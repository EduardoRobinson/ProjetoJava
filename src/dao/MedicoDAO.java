package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Consulta;
import entities.Medicos;

public class MedicoDAO {

	private Connection conn;

	public MedicoDAO(Connection conn) {

		this.conn = conn;
	}

	public void cadastrar(Medicos medico) throws SQLException {
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"insert into medicos (crm, nome,rua,bairro,cidade,uf,cep,especialidade) values (?, ?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, medico.getCRM());
			st.setString(2, medico.getNome());
			st.setString(3, medico.getEndereco().getRua());
			st.setString(4, medico.getEndereco().getBairro());
			st.setString(5, medico.getEndereco().getCidade());
			st.setString(6, medico.getEndereco().getUF());
			st.setString(7, medico.getEndereco().getCEP());
			st.setString(8, medico.getEspecialidade());
			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public List<Medicos> buscarTodos() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st=conn.prepareStatement("select * from medicos");
			rs=st.executeQuery();
			List<Medicos> lista= new ArrayList<>();
			while(rs.next()) {
				Medicos medico = new Medicos();
				medico.setNome(rs.getString("nome"));
				medico.setCRM(rs.getString("CRM"));
				lista.add(medico);
			}
			return lista;

		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}

	}
	
	public List<Consulta> montarRelatorio(String nomemedico)throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st=conn.prepareStatement("select * from consulta where nomemedico like ?");
			st.setString(1,nomemedico);
			rs=st.executeQuery();
			List<Consulta> lista= new ArrayList<>();
			while(rs.next()) {
				Consulta consulta= new Consulta();
				consulta.setNomemedico(rs.getString("nomemedico"));
				consulta.setNomepaciente(rs.getString("nomepaciente"));
				consulta.setData(rs.getString("data"));
				consulta.setHora(rs.getString("hora"));
				lista.add(consulta);
			}
			return lista;
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
		
	}

}
