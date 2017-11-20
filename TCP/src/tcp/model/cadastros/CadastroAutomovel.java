package TCP.src.tcp.model.cadastros;
import TCP.src.tcp.model.entidades.Automovel;
import TCP.src.tcp.model.excecoes.AutomovelJaCadastradoException;
import TCP.src.tcp.model.excecoes.AutomovelNaoCadastradoException;
import TCP.src.tcp.model.excecoes.AutomovelNaoEncontradoException;
import TCP.src.tcp.model.repositorios.RepositorioAutomovel;

public class CadastroAutomovel {
	
	private RepositorioAutomovel automovel;
	
	public CadastroAutomovel(RepositorioAutomovel automovel){
		this.automovel = automovel;
	
	}

	public void cadastra(Automovel auto) throws AutomovelJaCadastradoException{
		if(!this.automovel.existe(auto.getChassi())){
			this.automovel.inserir(auto);			
		}
		else {
			
			throw new AutomovelJaCadastradoException();
		}
	}
	
	public void remover(String chassi) throws AutomovelNaoCadastradoException{
		if(this.automovel.existe(chassi)){
			this.automovel.remover(chassi);		
		}
		else {
			throw new AutomovelNaoCadastradoException();
		}
	}
	
	public void atualizar(String chassi, Automovel automovel) throws AutomovelNaoEncontradoException{
		if(this.automovel.existe(chassi)){
			this.automovel.atualizar(automovel);		
		}
		else {
			throw new AutomovelNaoEncontradoException();
		}
	}
	
	public Automovel procurar(String chassi) throws AutomovelNaoEncontradoException{
		if(this.automovel.existe(chassi)){
			return this.automovel.procurar(chassi);
		
		}
		else {
			throw new AutomovelNaoEncontradoException();
		}
	
	}
}