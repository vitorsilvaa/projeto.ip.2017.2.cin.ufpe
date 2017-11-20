package TCP.src.tcp.model.repositorios;

import TCP.src.tcp.model.entidades.Carro;
import TCP.src.tcp.model.excecoes.CarroJaCadastradoException;
import TCP.src.tcp.model.excecoes.CarroNaoCadastradoException;
import TCP.src.tcp.model.excecoes.CarroNaoEncontradoException;



public class RepositorioCarroArray implements RepositorioCarro{

	private Carro[] carro;
	private int indice;

	public RepositorioCarroArray(){
		carro = new Carro[100];
		indice = 0;	
	}

	public void inserir(Carro carro) throws CarroJaCadastradoException {
		if(!this.existe(carro.getChassi())) {
		this.carro[indice] = carro;
		if(this.indice >= this.carro.length-1){
			Carro[] veiculosNovo = new Carro[2*this.carro.length];
			for(int i = 0; i < this.carro.length; i++){
				veiculosNovo[i] = this.carro[i];
			}
			this.carro = veiculosNovo;
		}
		this.indice++;
	}else {
		throw new CarroJaCadastradoException(); 
	}
		
	}

	public void remover(String chassi) throws CarroNaoCadastradoException{
		if(this.existe(chassi)) {
		if(this.carro.equals(chassi)){
			this.carro[this.indice] = this.carro[this.indice - 1];
			this.indice = this.indice - 1;
		}
		else {
			throw new CarroNaoCadastradoException();
		}
		}
	}

	public void atualizar(Carro carro) throws CarroNaoEncontradoException{
		this.carro[getIndice(carro.getChassi())] = carro;

	}

	public Carro procurar(String chassi)  throws CarroNaoEncontradoException{
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

	public int getIndice(String chassi) throws CarroNaoEncontradoException{
		for(int i = 0;i < this.indice;i++){
			if(this.carro[i].getChassi().equals(chassi)){
				return i;
			}
		}
		throw new CarroNaoEncontradoException();
		
	}

}