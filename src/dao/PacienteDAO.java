package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Consulta;
import entities.Pacientes;
import entities.PedidoExame;

public class PacienteDAO {
	
	private Connection conn;
	
	public PacienteDAO(Connection conn) {

		this.conn = conn;
	}

	public void cadastrar(Pacientes paciente) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"insert into pacientes (nome, foto, sexo, data,rua,bairro,cidade,uf,cep, telefone, formadepagamento) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			st.setString(1, paciente.getNome());
			st.setString(2,paciente.getFoto());
			st.setString(3,paciente.getSexo());
			st.setString(4,paciente.getDatanasc());
			st.setString(5,paciente.getEndereco().getRua());
			st.setString(6,paciente.getEndereco().getBairro());
			st.setString(7,paciente.getEndereco().getCidade());
			st.setString(8,paciente.getEndereco().getUF());
			st.setString(9,paciente.getEndereco().getCEP());
			st.setString(10,paciente.getTelefone());
			st.setString(11,paciente.getFormapgt());
			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<Pacientes> buscarTodos() throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st=conn.prepareStatement("select * from pacientes");
			rs=st.executeQuery();
			List<Pacientes> lista = new ArrayList<>();
			while(rs.next()) {
				Pacientes paciente= new Pacientes();
				paciente.setNome(rs.getString("nome"));
				lista.add(paciente);
			}
			return lista;
			
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public List<Consulta> montarRelatorioConsulta(String nomepaciente)throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st=conn.prepareStatement("select * from consulta where nomepaciente like ?");
			st.setString(1,nomepaciente);
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
	
	public List<PedidoExame> montarRelatorioExame(String nomepaciente) throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st=conn.prepareStatement("select * from controleexames where nomedopaciente like ?");
			st.setString(1, nomepaciente);
			rs=st.executeQuery();
			List<PedidoExame> lista= new ArrayList<>();
			while(rs.next()) {
				PedidoExame pedidoexame=new PedidoExame();
				pedidoexame.setCodigoexame(rs.getString("codigoexame"));
				pedidoexame.setNomepaciente(rs.getString("nomedopaciente"));
				pedidoexame.setCrmMedico(rs.getString("CRMmedico"));
				pedidoexame.setDataRealizacao(rs.getString("datarealizacao"));
				pedidoexame.setValorPago(rs.getString("valorpago"));
				lista.add(pedidoexame);
			}
			return lista;
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
		
	}

}
