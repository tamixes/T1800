package br.ufrpe.t1800.dao;

import java.util.ArrayList;


import br.ufrpe.t1800.negocio.beans.Receita;

public class RepositorioReceita implements IRepositorioReceita{
	
	private ArrayList<Receita> receitas;
	private static RepositorioReceita instance; 
	
	private RepositorioReceita() {
		receitas = new ArrayList<Receita>();
	}
	public static RepositorioReceita getInstance() {
		if(instance == null) {
			instance = new RepositorioReceita();
		}
		return instance; 
	}
	
	@Override
	public void cadastrarReceita(Receita receita) {
		receitas.add(receita);
		
	}

	@Override
	public ArrayList<Receita> listarReceita() {
		
		return receitas;
	}

	@Override
	public Receita buscarReceita(String descricao) {
		int i = procurarIndice(descricao);
		
		Receita r = new Receita();
		
		if(i >= 0) {
			r = receitas.get(i);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
		 return r;
	}

	@Override
	public void atualizarReceita(Receita receita) {
		int i = procurarIndice(receita.getDescricao());		
			
		if(i >= 0) {
			receitas.set(i, receita);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
		 
		
	}

	@Override
	public void removerReceita(Receita receita) {
		int i = procurarIndice(receita.getDescricao());		
		
		if(i >= 0) {
			receitas.remove(i);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
		
	}

	@Override
	public boolean existe(Receita receita) {
		boolean i = false; 
		
		for(Receita p : receitas) {
			if(p.equals(receita)) {
				i = true;
			}
		}
		return i;
	}

	@Override
	public int procurarIndice(String descricao) {
		int i = -1;
		for(int j = 0 ; j < receitas.size(); j++) {
			if(receitas.get(j).getDescricao().equals(descricao)){
				i = j;
			}
		
		}
		return i;
	}

}
