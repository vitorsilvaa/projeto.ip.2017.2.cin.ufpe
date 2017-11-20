package TCP.src.tcp.model.cadastros;
import TCP.src.tcp.model.entidades.Carro;
import TCP.src.tcp.model.excecoes.AutomovelNaoCadastradoException;
import TCP.src.tcp.model.excecoes.AutomovelNaoEncontradoException;
import TCP.src.tcp.model.excecoes.CarroJaCadastradoException;
import TCP.src.tcp.model.excecoes.CarroNaoCadastradoException;
import TCP.src.tcp.model.excecoes.CarroNaoEncontradoException;
import TCP.src.tcp.model.repositorios.RepositorioCarro;

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