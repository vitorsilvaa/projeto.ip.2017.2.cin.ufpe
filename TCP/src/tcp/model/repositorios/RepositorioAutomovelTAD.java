package TCP.src.tcp.model.repositorios;

import TCP.src.tcp.model.entidades.Automovel;
import TCP.src.tcp.model.excecoes.AutomovelJaCadastradoException;
import TCP.src.tcp.model.excecoes.AutomovelNaoCadastradoException;
import TCP.src.tcp.model.excecoes.AutomovelNaoEncontradoException;

public class RepositorioAutomovelTAD implements RepositorioAutomovel{

	private Automovel automovel;
	private RepositorioAutomovelTAD proximo;
	
	public RepositorioAutomovelTAD(){
		this.automovel = null;
		this.proximo = null;
				
	}
	
	
	public Automovel getVeiculo() {
		return automovel;
	}


	public void setVeiculo(Automovel automovel) {
		this.automovel = automovel;
	}


	public RepositorioAutomovelTAD getProximo() {
		return proximo;
	}


	public void setProximo(RepositorioAutomovelTAD proximo) {
		this.proximo = proximo;
	}


	public void inserir(Automovel veiculo) throws AutomovelJaCadastradoException{
		if(!this.existe(veiculo.getChassi())){
			if(this.proximo == null){
				this.automovel = veiculo;
				this.proximo = new RepositorioAutomovelTAD();
			}else {
				this.proximo.inserir(veiculo);
			}
		}
		else {
			throw new AutomovelJaCadastradoException();
		}
		
	}

	public void remover(String chassi) throws AutomovelNaoCadastradoException{
		if(this.existe(chassi)){
			if(this.automovel.equals(chassi)){
				this.automovel = this.proximo.automovel;
				this.proximo = this.proximo.proximo;
			}else {
				this.proximo.remover(chassi);
			}
		}
		else {
			throw new AutomovelNaoCadastradoException();
		}
		
	}

	public void atualizar(Automovel novo) throws AutomovelNaoEncontradoException{
		if(this.existe(automovel.getChassi())){
			if(this.automovel.equals(automovel.getChassi())){
				this.automovel = novo;
			}else {
				this.proximo.atualizar(novo);
			}
		}
		else {
			throw new AutomovelNaoEncontradoException();
		}
		
	}

	public Automovel procurar(String chassi) throws AutomovelNaoEncontradoException{
		if(this.existe(chassi)){
			if(this.automovel.getChassi().equals(chassi)){
				return this.automovel;
			}else {
				return this.proximo.procurar(chassi);
			}
		}
		throw new AutomovelNaoEncontradoException();
	}

	public boolean existe(String chassi)  {
		boolean encontrou = false;
		if(this.automovel != null){
			if(this.automovel.getChassi().equals(chassi)){
				encontrou = true;
			}else {
				this.proximo.existe(chassi);
			}
		}
		return encontrou;
	}

}
