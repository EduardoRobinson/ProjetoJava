package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.PacienteDAO;
import entities.Consulta;
import entities.Pacientes;
import entities.PedidoExame;
public class PacienteService {
	public PacienteService() {
		
	}
	public void cadastrar(Pacientes paciente) throws SQLException,IOException {
		Connection conn = BancoDados.conectar();
		new PacienteDAO(conn).cadastrar(paciente);
	}
	
	public List<Pacientes> buscarTodos() throws SQLException,IOException{
		Connection conn = BancoDados.conectar();
		return new PacienteDAO(conn).buscarTodos();
	}
	
	public List<Consulta> montarRelatorioConsulta(String nome) throws SQLException,IOException{
		Connection conn = BancoDados.conectar();
		return new PacienteDAO(conn).montarRelatorioConsulta(nome);
	}
	public List<PedidoExame> montarRelatorioExame(String nome) throws SQLException,IOException{
		Connection conn = BancoDados.conectar();
		return new PacienteDAO(conn).montarRelatorioExame(nome);
	}
}
