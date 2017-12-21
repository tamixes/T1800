package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.DespesaCartao;

public interface IRepositorioDespesaCartao {

	void cadastrarDespesaCartao(DespesaCartao despesa);
	void atualizarDespesaCartao(DespesaCartao despesa) throws ErroAoAtualizarException, ObjetoNaoExisteException;
	void removerDespesaCartao(DespesaCartao despesa) throws ErroAoRemoverException, ObjetoNaoExisteException;
	DespesaCartao buscarDespesaCartao(String descricao) throws ObjetoNaoExisteException;
	int buscarIndice(String descricao);
	ArrayList<DespesaCartao> listarDespesa ();
	boolean existe(DespesaCartao despesa);
	void salvarArquivo();
}
