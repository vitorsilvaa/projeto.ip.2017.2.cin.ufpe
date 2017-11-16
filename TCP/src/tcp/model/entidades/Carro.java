package TCP.src.tcp.model.entidades;

public class Carro extends Automovel{
	
	private String codigo;
	private String tipo;
	private String marca;
	private String modelo;
	private String versao;
	private int ano;
	private int capacidadePassageiros;
	
	public Carro(String crv, String placa, String chassi, String dataAquisicao, String informacoes, String codigo, String tipo, String marca,
			String modelo, String versao, int ano, int capacidadePassageiros) {
		super(crv, placa, chassi, dataAquisicao, informacoes);
		this.codigo = codigo;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.versao = versao;
		this.ano = ano;
		this.capacidadePassageiros = capacidadePassageiros;
		
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getCapacidadePassageiros() {
		return capacidadePassageiros;
	}

	public void setCapacidadePassageiros(int capacidadePassageiros) {
		this.capacidadePassageiros = capacidadePassageiros;
	}


	
	
}