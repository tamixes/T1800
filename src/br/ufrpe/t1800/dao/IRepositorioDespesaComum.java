package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.DespesaComum;

public interface IRepositorioDespesaComum {
	void cadastraDespesaC(DespesaComum despesa);
	DespesaComum procurarDespesaC(String nome);
	void atualizarDespesaC(DespesaComum despesa);
	void removerDespesaC(DespesaComum despesa);
	ArrayList<DespesaComum> listarDespesaC();
	boolean existe(DespesaComum despesa);
	int procurarIndice(String nome);
}
