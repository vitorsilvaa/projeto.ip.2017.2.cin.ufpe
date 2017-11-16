package TCP.src.tcp.model.repositorios;

import classeNegocio.Carro;

public interface RepositorioCarro {
	
	void inserir(Carro carro) ;
	void remover(String chassi) ;
	void atualizar(Carro carroo) ;
	Carro procurar(String chassi) ;
	boolean existe(String chassi);

}
