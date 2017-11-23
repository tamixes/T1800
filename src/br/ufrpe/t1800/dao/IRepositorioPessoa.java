package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.Pessoa;

public interface IRepositorioPessoa {
	
	void cadastrarPessoa(Pessoa pessoa);
	Pessoa procurarPessoa(String nome);
	void atualizarPessoa(Pessoa pessoa);
	void removerPessoa(Pessoa pessoa);
	ArrayList<Pessoa> listarPessoas();
	boolean existe(Pessoa pessoa);
	int procurarIndice(String nome);
	
}
