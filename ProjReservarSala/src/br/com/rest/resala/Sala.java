package br.com.rest.resala;

public class Sala {
	
	private int id;
	private String descricao;
	private String dataCadastro;
	private String dataReserva;
	private String hora;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	@Override
	public String toString() {
		return "Sala [id=" + id + ", descricao=" + descricao + ", dataCadastro=" + dataCadastro + ", dataReserva="
				+ dataReserva + ", hora=" + hora + "]";
	}
	
	

}
