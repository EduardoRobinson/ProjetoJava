package entities;

public class Consulta {
	private String nomepaciente;
	private String nomemedico;
	private String data;
	private String hora;
	public String getNomepaciente() {
		return nomepaciente;
	}
	public void setNomepaciente(String nomepaciente) {
		this.nomepaciente = nomepaciente;
	}
	public String getNomemedico() {
		return nomemedico;
	}
	public void setNomemedico(String nomemedico) {
		this.nomemedico = nomemedico;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	@Override
	public String toString() {
		return "Consulta [nomepaciente=" + nomepaciente + ", nomemedico=" + nomemedico + ", data=" + data + ", hora="
				+ hora + "]";
	}
	
	
}
