package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.Receita;

public interface IRepositorioReceita {
	
	void cadastrarReceita(Receita receita);
	ArrayList<Receita> listarReceita();
	Receita buscarReceita(String descricao) throws ObjetoNaoExisteException;
	void atualizarReceita(Receita receita) throws ObjetoNaoExisteException, ErroAoAtualizarException;
	void removerReceita(Receita receita) throws ObjetoNaoExisteException, ErroAoRemoverException;
	boolean existe(Receita receita);
	int procurarIndice(String descricao);
	void salvarArquivo();
	void removeReceita(String descricao) throws ObjetoNaoExisteException, ErroAoRemoverException;
}
