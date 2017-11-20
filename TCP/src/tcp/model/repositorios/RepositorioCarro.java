package TCP.src.tcp.model.repositorios;

import TCP.src.tcp.model.entidades.Carro;
import TCP.src.tcp.model.excecoes.CarroJaCadastradoException;
import TCP.src.tcp.model.excecoes.CarroNaoCadastradoException;
import TCP.src.tcp.model.excecoes.CarroNaoEncontradoException;

public interface RepositorioCarro {
	
	void inserir(Carro carro) throws CarroJaCadastradoException ;
	void remover(String chassi) throws CarroNaoCadastradoException ;
	void atualizar(Carro carroo) throws CarroNaoEncontradoException ;
	Carro procurar(String chassi) throws CarroNaoEncontradoException ;
	boolean existe(String chassi);

}
