package br.ufrpe.t1800.negocio;


import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioDespesaComum;
import br.ufrpe.t1800.dao.RepositorioDespesaComum;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
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
	
	public void cadastrarDespesaC(DespesaComum despesa) throws ObjetoJaExisteException{
		if(despesa != null && despesa.getValor() >= 0) {
			repositorio.cadastraDespesaC(despesa);
		}else if(this.repositorio.existe(despesa)) {
			throw new ObjetoJaExisteException();
		}else {
			
			throw new IllegalArgumentException("Inválido");
		}
		
	}
	
	public void atualizarDespesaC(DespesaComum despesa)throws ErroAoAtualizarException, ObjetoNaoExisteException {
		if(despesa != null && despesa.getValor() >= 0) {
			this.repositorio.atualizarDespesaC(despesa);
		}else {
			throw new IllegalArgumentException("Inválido");
		}
	}
	
	public void removerDespesaC(DespesaComum despesa) throws ErroAoRemoverException, ObjetoNaoExisteException{
		if(despesa != null) {
			this.repositorio.removerDespesaC(despesa);
		}else {
			throw new IllegalArgumentException("Inválido");
		}
	}
	
	public DespesaComum buscarDespesa(String nome) throws ObjetoNaoExisteException{
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
		
		if(despesa == null) {
			throw new IllegalArgumentException("Inválido");
		}else {
			return this.repositorio.existe(despesa);
		}
		
	}
	
	
}
