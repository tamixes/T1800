package br.ufrpe.t1800.negocio;


import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioDespesaComum;
import br.ufrpe.t1800.dao.RepositorioDespesaComum;
import br.ufrpe.t1800.negocio.beans.DespesaComum;

public class ControladorDespesaComum {
	private static ControladorDespesaComum instance;
	private IRepositorioDespesaComum repositorio; 
	
	private ControladorDespesaComum () {
		this.repositorio = RepositorioDespesaComum.getInstance();	
	}
	
	public static  ControladorDespesaComum getInstance() {
		if(instance == null) {
			instance = new ControladorDespesaComum();
		}
		return instance; 
	}
	
	public void cadastrarDespesaC(DespesaComum despesa) {
		if(despesa == null) {
			
		}else if(this.repositorio.existe(despesa));
			
		else {
			repositorio.cadastraDespesaC(despesa);
		}		
	}
	
	public void atualizarDespesaC(DespesaComum despesa) {
		if(despesa != null) {
			this.repositorio.atualizarDespesaC(despesa);
		}else {
			
		}
	}
	
	public void removerDespesaC(DespesaComum despesa) {
		if(despesa != null) {
			this.repositorio.removerDespesaC(despesa);
		}else {
			
		}
	}
	
	public DespesaComum buscarDespesa(String nome) {
		if(nome != null) {
			return this.repositorio.procurarDespesaC(nome);
		}else {
			throw new IllegalArgumentException("Invelido");
		}
	}
	
	public ArrayList<DespesaComum> listar(){
		return null;
	}
	
	public boolean existe(DespesaComum despesa) {
		return this.repositorio.existe(despesa);
	}
	
	
}
