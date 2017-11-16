package TCP.src.tcp.model.repositorios;
import classeNegocio.Automovel;
import exception.AutomovelJaCadastradoException;
import exception.AutomovelNaoCadastradoException;
import exception.AutomovelNaoEncontradoException;

public interface RepositorioAutomovel {
	void inserir(Automovel automovel) throws  AutomovelJaCadastradoException;
	void remover(String chassi) throws AutomovelNaoCadastradoException;
	void atualizar(Automovel automovel) throws AutomovelNaoEncontradoException;
	Automovel procurar(String chassi) throws AutomovelNaoEncontradoException;
	boolean existe(String chassi);

}