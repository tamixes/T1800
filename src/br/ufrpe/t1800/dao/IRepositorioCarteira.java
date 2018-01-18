package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.Carteira;

public interface IRepositorioCarteira {
	
	void cadastrarCarteira(Carteira carteira);
	void removerCarteira(Carteira carteira) throws ObjetoNaoExisteException, ErroAoRemoverException;
	void removeCarteira(String codigo) throws ObjetoNaoExisteException, ErroAoRemoverException;
	void atualizarCarteira(Carteira carteira) throws ErroAoAtualizarException, ObjetoNaoExisteException;
	ArrayList<Carteira> listarCarteira();
	int procurarIndice(String id);
	Carteira buscarCarteira(String id) throws ObjetoNaoExisteException;
	boolean existe(Carteira carteira);
	void salvarArquivo();
}
