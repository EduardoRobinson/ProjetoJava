package entities;

public class Medicos {
	private String CRM;
	private String nome;
	private Endereco endereco;
	private String telefone;
	private String especialidade;
	public String getCRM() {
		return CRM;
	}
	public void setCRM(String cRM) {
		CRM = cRM;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}
