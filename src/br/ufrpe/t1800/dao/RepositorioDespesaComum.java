package br.ufrpe.t1800.dao;

import java.util.ArrayList;


import br.ufrpe.t1800.negocio.beans.DespesaComum;

public class RepositorioDespesaComum implements IRepositorioDespesaComum{
	
	private ArrayList<DespesaComum> despesas;
	private static RepositorioDespesaComum instance;
	
	
	private  RepositorioDespesaComum() {
		despesas = new ArrayList<DespesaComum>();
	}
	
	public static RepositorioDespesaComum getInstance() {
		if(instance == null) {
			instance = new RepositorioDespesaComum();
		}
			return instance;
		
	}
	
	@Override
	public void cadastraDespesaC(DespesaComum despesa) {
		despesas.add(despesa);
		
	}

	@Override
	public DespesaComum procurarDespesaC(String nome) {
		return null; 
	}

	@Override
	public void atualizarDespesaC(DespesaComum despesa) {
		int i = procurarIndice(despesa.getDescriçao());
		if(i>= 0) {
			despesas.set(i, despesa);
		}else {
			
		}
		
	}

	@Override
	public void removerDespesaC(DespesaComum despesa) {
		int i = procurarIndice(despesa.getDescriçao());
		if(i >= 0) {
			despesas.remove(i);
		}else {
			
		}
		
	}

	@Override
	public ArrayList<DespesaComum> listarDespesaC() {
	
		return despesas;
	}

	@Override
	public boolean existe(DespesaComum despesa) {
		
		boolean i = false;
		for(DespesaComum d : despesas ) {
			if(d.equals(despesa)) {
				i = true;
			}
		}
		return i;
		
	}

	@Override
	public int procurarIndice(String nome) {
		int i = -1;
		for(int j = 0 ; j < despesas.size(); j++) {
			if(despesas.get(j).getDescriçao().equalsIgnoreCase(nome)){
				i = j;
			}
		
		}
		return i;
	}

}
