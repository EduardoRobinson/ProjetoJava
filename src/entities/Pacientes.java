package entities;

public class Pacientes {
	private String nome;
	private String foto;
	private String datanasc;
	private String sexo;
	private Endereco endereco;
	private String telefone;
	private String formapgt;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	public String getFormapgt() {
		return formapgt;
	}
	public void setFormapgt(String formapgt) {
		this.formapgt = formapgt;
	}

}
