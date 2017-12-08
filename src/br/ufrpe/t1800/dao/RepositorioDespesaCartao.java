package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.DespesaCartao;

public class RepositorioDespesaCartao implements IRepositorioDespesaCartao{

	private ArrayList<DespesaCartao> despesas;
	private static RepositorioDespesaCartao instance;
	
	private RepositorioDespesaCartao() {
		despesas = new ArrayList<DespesaCartao>();
	}
	
	public static RepositorioDespesaCartao getInstance() {
		if(instance == null) {
			instance = new RepositorioDespesaCartao();
		}
		return instance;
	}
	
	
	@Override
	public void cadastrarDespesaCartao(DespesaCartao despesa) {
		despesas.add(despesa);
		
	}

	@Override
	public void atualizarDespesaCartao(DespesaCartao despesa) throws ErroAoAtualizarException, ObjetoNaoExisteException{
		int i = buscarIndice(despesa.getDescriçao());
		
		if(i >= 0) {
			despesas.set(i, despesa);
		}else {
			throw new ErroAoAtualizarException();
		}
		
	}

	@Override
	public void removerDespesaCartao(DespesaCartao despesa) throws ErroAoRemoverException, ObjetoNaoExisteException{
		int i = buscarIndice(despesa.getDescriçao());
		if(i >= 0) {
			despesas.remove(i);
		}else {
			throw new ErroAoRemoverException();
		}
		
	}

	@Override
	public DespesaCartao buscarDespesaCartao(String descricao) throws ObjetoNaoExisteException{
		int i = buscarIndice(descricao);
		 DespesaCartao d = new DespesaCartao();
		 
		 if(i >= 0) {
			 d = despesas.get(i);
		 }else {
			 throw new ObjetoNaoExisteException();
		 }
		 
		 return d;
	}

	@Override
	public int buscarIndice(String descricao) {
		int i = -1;
		for(int j = 0; j < despesas.size(); j++) {
			if(despesas.get(j).getDescriçao().equalsIgnoreCase(descricao)) {
				i = j;
			}
		}
		return i;
	}

	@Override
	public ArrayList<DespesaCartao> listarDespesa() {
		return despesas;
	}

	@Override
	public boolean existe(DespesaCartao despesa) {
		boolean i = false;
		for(DespesaCartao d: despesas) {
			if(d.equals(despesa)) {
				i = true;
			}
		}
		return i;
			
	}
	
}
