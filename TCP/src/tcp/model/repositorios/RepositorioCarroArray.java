package TCP.src.tcp.model.repositorios;

import classeNegocio.Carro;



public class RepositorioCarroArray implements RepositorioCarro{

	private Carro[] carro;
	private int indice;

	public RepositorioCarroArray(){
		carro = new Carro[100];
		indice = 0;	
	}

	public void inserir(Carro carro) {
		this.carro[indice] = carro;
		if(this.indice >= this.carro.length-1){
			Carro[] veiculosNovo = new Carro[2*this.carro.length];
			for(int i = 0; i < this.carro.length; i++){
				veiculosNovo[i] = this.carro[i];
			}
			this.carro = veiculosNovo;
		}
		this.indice++;
	}


	public void remover(String chassi) {
		if(this.equals(chassi)){
			this.carro[this.indice] = this.carro[this.indice - 1];
			this.indice = this.indice - 1;
		}
		
	}

	public void atualizar(Carro carro) {
		this.carro[getIndice(carro.getChassi())] = carro;

	}

	public Carro procurar(String chassi) {
		return this.carro[this.getIndice(chassi)];

	}

	public boolean existe(String chassi) {
		for(int i = 0;i < this.indice;i++){
			if(this.carro[i].getChassi().equals(chassi)){
				return true;
			}
		}
		return false;

	}

	public int getIndice(String chassi) {
		for(int i = 0;i < this.indice;i++){
			if(this.carro[i].getChassi().equals(chassi)){
				return i;
			}
		}
		return indice;
		
	}

}