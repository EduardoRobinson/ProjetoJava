package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ExameDAO;
import entities.Exames;
import entities.PedidoExame;

public class ExameService {
	public ExameService() {
		
	}
	
	public void cadastrar(Exames exame) throws SQLException, IOException{
		Connection conn = BancoDados.conectar();
		new ExameDAO(conn).cadastrar(exame);
		
	}
	
	public List<Exames> buscarTodos() throws SQLException, IOException{
		Connection conn = BancoDados.conectar();
		return new ExameDAO(conn).buscarTodos();
	}
	
	public void cadastrarPedidoExame(PedidoExame pedidoexame) throws SQLException, IOException{
		Connection conn = BancoDados.conectar();
		new ExameDAO(conn).cadastrarPedidoExame(pedidoexame);
	}
	public List<PedidoExame>  montarRelatorio(String codigo) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new ExameDAO(conn).montarRelatorio(codigo);
	}
	
}
