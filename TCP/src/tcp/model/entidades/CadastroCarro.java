package TCP.src.tcp.model.entidades;
import dados.RepositorioCarro;
import exception.AutomovelNaoCadastradoException;
import exception.AutomovelNaoEncontradoException;
import exception.CarroJaCadastradoException;
import exception.CarroNaoCadastradoException;
import exception.CarroNaoEncontradoException;

public class CadastroCarro {
	
	private RepositorioCarro carro;
	
	public CadastroCarro(RepositorioCarro carro){
		this.carro = carro;
	
	}

	public void cadastra(Carro carro) throws CarroJaCadastradoException {
		if(!this.carro.existe(carro.getChassi())){
			this.carro.inserir(carro);			
		}
		else {
			throw new CarroJaCadastradoException();
		}
	}
	
	public void remover(String chassi) throws CarroNaoCadastradoException{
		if(this.carro.existe(chassi)){
			this.carro.remover(chassi);		
		}
		else {
			throw new CarroNaoCadastradoException();
		}
	}
	
	public void atualizar(String chassi, Carro carro) throws CarroNaoEncontradoException{
		if(this.carro.existe(chassi)){
			this.carro.atualizar(carro);		
		}
		throw new CarroNaoEncontradoException();
	}
	
	public Carro procurar(String chassi) throws CarroNaoEncontradoException{
		if(this.carro.existe(chassi)){
			return this.carro.procurar(chassi);
		
		}
		throw new CarroNaoEncontradoException();
		
	
	}
}