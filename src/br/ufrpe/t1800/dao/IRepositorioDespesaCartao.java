package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.DespesaCartao;

public interface IRepositorioDespesaCartao {

	void cadastrarDespesaCartao(DespesaCartao despesa);
	void atualizarDespesaCartao(DespesaCartao despesa);
	void removerDespesaCartao(DespesaCartao despesa);
	DespesaCartao buscarDespesaCartao(String descricao);
	int buscarIndice(String descricao);
	ArrayList<DespesaCartao> listarDespesa ();
	boolean existe(DespesaCartao despesa);
}
