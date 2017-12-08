package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.Pessoa;

public interface IRepositorioPessoa {
	
	void cadastrarPessoa(Pessoa pessoa);
	Pessoa procurarPessoa(String nome) throws ObjetoNaoExisteException;
	void atualizarPessoa(Pessoa pessoa) throws ErroAoAtualizarException, ObjetoNaoExisteException;
	void removerPessoa(Pessoa pessoa) throws ErroAoRemoverException, ObjetoNaoExisteException;
	ArrayList<Pessoa> listarPessoas();
	boolean existe(Pessoa pessoa);
	int procurarIndice(String nome);
	
}
