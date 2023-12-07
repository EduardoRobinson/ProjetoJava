package entities;

public class PedidoExame {
	private String codigoexame;
	private String nomepaciente;
	private String crmMedico;
	private String valorPago;
	private String dataRealizacao;
	public String getCodigoexame() {
		return codigoexame;
	}
	public void setCodigoexame(String codigoexame) {
		this.codigoexame = codigoexame;
	}
	public String getNomepaciente() {
		return nomepaciente;
	}
	public void setNomepaciente(String nomepaciente) {
		this.nomepaciente = nomepaciente;
	}
	public String getCrmMedico() {
		return crmMedico;
	}
	public void setCrmMedico(String crmMedico) {
		this.crmMedico = crmMedico;
	}
	public String getValorPago() {
		return valorPago;
	}
	public void setValorPago(String valorPago) {
		this.valorPago = valorPago;
	}
	public String getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

}
