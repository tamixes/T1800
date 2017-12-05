package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.DespesaComum;

public interface IRepositorioDespesaComum {
	void cadastraDespesaC(DespesaComum pessoa);
	DespesaComum procurarDespesaC(String nome);
	void atualizarDespesaC(DespesaComum pessoa);
	void removerDespesaC(DespesaComum pessoa);
	ArrayList<DespesaComum> listarPessoas();
	boolean existe(DespesaComum pessoa);
	int procurarIndice(String nome);
}
