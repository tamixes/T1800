package br.ufrpe.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.Pessoa;

public class RepositorioPessoa implements IRepositorioPessoa{

	private ArrayList<Pessoa> pessoas;
	private static RepositorioPessoa instance;
	
	private RepositorioPessoa() {
		pessoas = new ArrayList<Pessoa>();
		
	}
	
	public static RepositorioPessoa getInstance() {
		if(instance == null) {
			instance = new RepositorioPessoa();
		}
		return instance; 
	}
	
	
	
	@Override
	public void cadastrarPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
		
	}

	@Override
	public Pessoa procurarPessoa(String nome) {
		int i = procurarIndice(nome);
		
		Pessoa resultado = new Pessoa();
		
		if(i >= 0) {
			resultado = pessoas.get(i);
		}else {
			
		}
		 return resultado;
	}

	@Override
	public void atualizarPessoa(Pessoa pessoa) {
		int i = procurarIndice(pessoa.getNome());
		
		if(i >= 0) {
			pessoas.set(i, pessoa);
		}else {
			
		}
		
	}

	@Override
	public void removerPessoa(Pessoa pessoa) {
		int i = procurarIndice(pessoa.getNome());
		
		if(i >= 0) {
			pessoas.remove(i);
		}else {
			
		}
		
	}

	@Override
	public ArrayList<Pessoa> listarPessoas() {
		return pessoas;
	}

	@Override
	public boolean existe(Pessoa pessoa) {
		boolean i = false; 
		
		for(Pessoa p : pessoas) {
			if(p.equals(pessoa)) {
				i= true;
				
			}
			
		}
		return i;
	}

	public int procurarIndice(String nome) {
		int i = -1;
		for(int j = 0 ; j < pessoas.size(); j++) {
			if(pessoas.get(j).getNome().equalsIgnoreCase(nome)){
				i = j;
			}
		
		}
		return i;
	}
	
	

}
