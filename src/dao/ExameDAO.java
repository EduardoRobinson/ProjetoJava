package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Exames;
import entities.PedidoExame;

public class ExameDAO {
private Connection conn;
	
	public ExameDAO(Connection conn) {

		this.conn = conn;
	}
	
	public void cadastrar(Exames exame)throws SQLException {
		PreparedStatement st= null;
		try {
			st=conn.prepareStatement("insert into exames(codigoexame,nome,valor,orientacoes) values (?,?,?,?)");
			st.setString(1,exame.getCodigo());
			st.setString(2,exame.getNome());
			st.setInt(3,exame.getValor());
			st.setString(4,exame.getOrientacoes());
			st.executeUpdate();
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
		
	}
	
	
	public void cadastrarPedidoExame(PedidoExame pedidoexame)throws SQLException{
		PreparedStatement st=null;
		try {
			st=conn.prepareStatement("insert into controleexames(codigoexame,nomedopaciente,CRMmedico,datarealizacao,valorpago) values(?,?,?,?,?)");
			st.setString(1,pedidoexame.getCodigoexame());
			st.setString(2,pedidoexame.getNomepaciente());
			st.setString(3,pedidoexame.getCrmMedico());
			st.setString(4,pedidoexame.getDataRealizacao());
			st.setString(5,pedidoexame.getValorPago());
			st.executeUpdate();
			
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
		
	}
	
	public List<Exames> buscarTodos() throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st=conn.prepareStatement("select codigoexame from exames");
			rs=st.executeQuery();
			List<Exames> lista = new ArrayList<>();
			while(rs.next()) {
				Exames exame= new Exames();
				exame.setCodigo(rs.getString("codigoexame"));
				lista.add(exame);
			}
			return lista;
			
		}finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
			
		}
		
	}
	
	public List<PedidoExame> montarRelatorio(String codigo) throws SQLException{
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st=conn.prepareStatement("select * from controleexames where codigoexame like ?");
			st.setString(1, codigo);
			rs=st.executeQuery();
			List<PedidoExame> lista=new ArrayList<>();
			while(rs.next()) {
				PedidoExame pedidoexame= new PedidoExame();
				pedidoexame.setCodigoexame(rs.getString("codigoexame"));
				pedidoexame.setCrmMedico(rs.getString("nomedopaciente"));
				pedidoexame.setNomepaciente(rs.getString("CRMmedico"));
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
