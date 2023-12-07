package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.MedicoDAO;
import entities.Consulta;
import entities.Medicos;


public class MedicoService {
	public MedicoService() {
		
	}
	public void cadastrar(Medicos medico) throws SQLException,IOException{
		Connection conn = BancoDados.conectar();
		new MedicoDAO(conn).cadastrar(medico);
	}
	public List<Medicos> buscarTodos() throws SQLException, IOException{
		Connection conn = BancoDados.conectar();
		return new MedicoDAO(conn).buscarTodos();
	}
	
	public List<Consulta> montarRelatorio(String nomemedico) throws SQLException, IOException{
		Connection conn = BancoDados.conectar();
		return new MedicoDAO(conn).montarRelatorio(nomemedico);
	}
}
