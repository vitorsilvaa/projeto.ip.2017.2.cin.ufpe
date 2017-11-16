package TCP.src.tcp.model.entidades;

public class Automovel {
	
	private String crv;
	private String placa;
	private String chassi;
	private String dataAquisicao;
	private String informacoes;
	
	public Automovel(String crv, String placa, String chassi, String dataAquisicao, String informacoes){
		this.crv = crv;
		this.placa = placa;
		this.chassi = chassi;
		this.dataAquisicao =dataAquisicao;
		this.informacoes =  informacoes;
		
	}

	public String getCrv() {
		return crv;
	}

	public void setCrv(String crv) {
		this.crv = crv;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(String dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	
	
	
}