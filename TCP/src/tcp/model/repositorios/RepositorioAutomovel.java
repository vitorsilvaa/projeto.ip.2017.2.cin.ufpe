package TCP.src.tcp.model.repositorios;
import TCP.src.tcp.model.entidades.Automovel;
import TCP.src.tcp.model.excecoes.AutomovelJaCadastradoException;
import TCP.src.tcp.model.excecoes.AutomovelNaoCadastradoException;
import TCP.src.tcp.model.excecoes.AutomovelNaoEncontradoException;

public interface RepositorioAutomovel {
	void inserir(Automovel automovel) throws  AutomovelJaCadastradoException;
	void remover(String chassi) throws AutomovelNaoCadastradoException;
	void atualizar(Automovel automovel) throws AutomovelNaoEncontradoException;
	Automovel procurar(String chassi) throws AutomovelNaoEncontradoException;
	boolean existe(String chassi);

}