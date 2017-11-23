package br.ufrpe.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.Receita;

public interface IRepositorioReceita {
	
	void cadastrarReceita(Receita receita);
	ArrayList<Receita> listarReceita();
	Receita buscarReceita(String descricao);
	void atualizarReceita(Receita receita);
	void removerReceita(Receita receita);
	boolean existe(Receita receita);
	int procurarIndice(String descricao);
}
