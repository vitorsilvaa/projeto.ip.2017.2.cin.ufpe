package TCP.src.tcp.model.repositorios;

import classeNegocio.Carro;


public class RepositorioCarroTAD implements RepositorioCarro{

	private Carro carro;
	private RepositorioCarroTAD proximo;
	
	public RepositorioCarroTAD(){
		this.carro = null;
		this.proximo = null;
				
	}
	
	
	public Carro getVeiculo() {
		return carro;
	}


	public void setVeiculo(Carro Carro) {
		this.carro = carro;
	}


	public RepositorioCarroTAD getProximo() {
		return proximo;
	}


	public void setProximo(RepositorioCarroTAD proximo) {
		this.proximo = proximo;
	}


	public void inserir(Carro carro){
		if(!this.existe(carro.getChassi())){
			if(this.proximo == null){
				this.carro = carro;
				this.proximo = new RepositorioCarroTAD();
			}else {
				this.proximo.inserir(carro);
			}
		}
		
		
	}

	public void remover(String chassi){
		if(this.existe(chassi)){
			if(this.carro.equals(chassi)){
				this.carro = this.proximo.carro;
				this.proximo = this.proximo.proximo;
			}else {
				this.proximo.remover(chassi);
			}
		}
		
		
	}

	public void atualizar(Carro novo) {
		if(this.existe(carro.getChassi())){
			if(this.carro.equals(carro.getChassi())){
				this.carro = novo;
			}else {
				this.proximo.atualizar(novo);
			}
		}
		
		
	}

	public Carro procurar(String chassi){
		if(this.existe(chassi)){
			if(this.carro.getChassi().equals(chassi)){
				return this.carro;
			}else {
				return this.proximo.procurar(chassi);
			}
		}
		return carro;
		
	}

	public boolean existe(String chassi)  {
		boolean encontrou = false;
		if(this.carro != null){
			if(this.carro.getChassi().equals(chassi)){
				encontrou = true;
			}else {
				this.proximo.existe(chassi);
			}
		}
		return encontrou;
	}

}
