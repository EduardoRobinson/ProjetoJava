package dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import entities.Pacientes;
import entities.Endereco;


public class PacienteDAOteste {
	public static void cadastrarPacienteTeste() throws SQLException, IOException {
		
		Pacientes paciente = new Pacientes();
		paciente.setNome("Eduardo");
		paciente.setFoto("asdasda");
		paciente.setSexo("Masculino");
		paciente.setDatanasc("18/07/1998");
		paciente.setEndereco(new Endereco("Rua chafic cury", "Jardim caravalho", "Ponta Grossa", "PR", "84015700"));
		paciente.setTelefone("42 988335322");
		paciente.setFormapgt("Boleto");
		
		Connection conn = BancoDados.conectar();
		new PacienteDAO(conn).cadastrar(paciente);
		
	}
	
	public static void main(String[] args) {
		try {
			PacienteDAOteste.cadastrarPacienteTeste();
		}catch(SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
