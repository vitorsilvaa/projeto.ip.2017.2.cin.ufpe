package TCP.src.tcp.model.repositorios;

import TCP.src.tcp.model.entidades.Carro;
import TCP.src.tcp.model.excecoes.CarroJaCadastradoException;
import TCP.src.tcp.model.excecoes.CarroNaoCadastradoException;
import TCP.src.tcp.model.excecoes.CarroNaoEncontradoException;


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


	public void inserir(Carro carro) throws CarroJaCadastradoException{
		if(!this.existe(carro.getChassi())){
			if(this.proximo == null){
				this.carro = carro;
				this.proximo = new RepositorioCarroTAD();
			}else {
				this.proximo.inserir(carro);
			}
		}else {
			throw new CarroJaCadastradoException();
		}
		
		
		
	}

	public void remover(String chassi) throws CarroNaoCadastradoException{
		if(this.existe(chassi)){
			if(this.carro.equals(chassi)){
				this.carro = this.proximo.carro;
				this.proximo = this.proximo.proximo;
			}else {
				this.proximo.remover(chassi);
			}
		}
		else {
			throw new CarroNaoCadastradoException();
		}
		
		
	}

	public void atualizar(Carro novo) throws CarroNaoEncontradoException{
		if(this.existe(carro.getChassi())){
			if(this.carro.equals(carro.getChassi())){
				this.carro = novo;
			}else {
				this.proximo.atualizar(novo);
			}
		}
		else {
			throw new CarroNaoEncontradoException();
		}
		
		
	}

	public Carro procurar(String chassi) throws CarroNaoEncontradoException{
		if(this.existe(chassi)){
			if(this.carro.getChassi().equals(chassi)){
				return this.carro;
			}else {
				return this.proximo.procurar(chassi);
			}
		}
		throw new CarroNaoEncontradoException();
		
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
