package TCP.src.tcp.model.repositorios;

import classeNegocio.Automovel;
import exception.AutomovelJaCadastradoException;
import exception.AutomovelNaoCadastradoException;
import exception.AutomovelNaoEncontradoException;


public class RepositorioAutomovelArray implements RepositorioAutomovel{

	private Automovel[] automovel;
		private int indice;
		
		public RepositorioAutomovelArray(){
			automovel = new Automovel[100];
			indice = 0;	
		}
		
		public void inserir(Automovel automovel) throws AutomovelJaCadastradoException{
			if(!this.existe(automovel.getChassi())){
				this.automovel[indice] = automovel;
				if(this.indice >= this.automovel.length-1){
					Automovel[] veiculosNovo = new Automovel[2*this.automovel.length];
					for(int i = 0; i < this.automovel.length; i++){
						veiculosNovo[i] = this.automovel[i];
					}
					this.automovel = veiculosNovo;
				}
				this.indice++;
			}
			else {
				throw new AutomovelJaCadastradoException();
			}
		}
		
		public void remover(String chassi) throws AutomovelNaoCadastradoException{
			if(this.equals(chassi)){
				this.automovel[this.indice] = this.automovel[this.indice - 1];
				this.indice = this.indice - 1;
			}
			else {
				throw new AutomovelNaoCadastradoException();
			}
		}
		
		public void atualizar(Automovel automovel) throws AutomovelNaoEncontradoException{
			this.automovel[getIndice(automovel.getChassi())] = automovel;
		
		}
		
		public Automovel procurar(String chassi) throws AutomovelNaoEncontradoException{
			return this.automovel[this.getIndice(chassi)];
		
		}
		
		public boolean existe(String chassi) {
			for(int i = 0;i < this.indice;i++){
				if(this.automovel[i].getChassi().equals(chassi)){
					return true;
				}
			}
			return false;
		
		}
		
		public int getIndice(String chassi) throws AutomovelNaoEncontradoException{
			for(int i = 0;i < this.indice;i++){
				if(this.automovel[i].getChassi().equals(chassi)){
					return i;
				}
			}
			throw new  AutomovelNaoEncontradoException();
		}

}