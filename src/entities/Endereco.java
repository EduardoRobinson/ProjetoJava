package entities;

public class Endereco {
	
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	public Endereco(String rua, String bairro, String cidade, String uf, String cep) {
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUF() {
		return uf;
	}
	public void setUF(String uf) {
		this.uf = uf;
	}
	public String getCEP() {
		return cep;
	}
	public void setCEP(String cep) {
		this.cep= cep;
	}
	
}
