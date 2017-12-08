package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.DespesaComum;

public interface IRepositorioDespesaComum {
	void cadastraDespesaC(DespesaComum despesa);
	DespesaComum procurarDespesaC(String nome) throws ObjetoNaoExisteException;
	void atualizarDespesaC(DespesaComum despesa) throws ObjetoNaoExisteException, ErroAoAtualizarException;
	void removerDespesaC(DespesaComum despesa) throws ObjetoNaoExisteException, ErroAoRemoverException;
	ArrayList<DespesaComum> listarDespesaC();
	boolean existe(DespesaComum despesa);
	int procurarIndice(String nome);
}
