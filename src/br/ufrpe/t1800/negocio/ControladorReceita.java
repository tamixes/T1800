package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioReceita;
import br.ufrpe.t1800.dao.RepositorioReceita;
import br.ufrpe.t1800.negocio.beans.Receita;

public class ControladorReceita {
	private static ControladorReceita instance; 
	private IRepositorioReceita repositorio; 
	
	
	private ControladorReceita() {
		this.repositorio = RepositorioReceita.getInstance();
	}
	
	
	public static ControladorReceita getInstance() {
		if(instance == null) {
			instance = ControladorReceita.getInstance();
		}
		
		return instance;
	}
	
	public void cadastrarReceita(Receita receita) {
		if(receita == null) {
			
		}else if(this.repositorio.existe(receita)) {
			
		}else {
			this.repositorio.cadastrarReceita(receita);
		}
	}
	
	public void atualizarReceita(Receita receita) {
		if(receita != null) {
			this.repositorio.atualizarReceita(receita);
		}else {
			
		}
	}
	
	public void removerReceita(Receita receita) {
		if(receita != null) {
			this.repositorio.removerReceita(receita);
		}else {
			
		}
	}
	
	ArrayList<Receita> listarReceita(){
		return this.repositorio.listarReceita();
	}
	
	Receita buscarReceita(String nome) {
		if(nome != null) {
			return this.repositorio.buscarReceita(nome);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
	}
	
	public boolean existe(Receita receita) {
		return this.repositorio.existe(receita);
	}
	
	
	
	
	
	
}
