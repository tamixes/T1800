package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioReceita;
import br.ufrpe.t1800.dao.RepositorioReceita;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.Receita;

public class ControladorReceita {
	private static ControladorReceita instance; 
	private IRepositorioReceita repositorio; 
	
	
	private ControladorReceita() {
		this.repositorio = RepositorioReceita.getInstance();
	}
	
	
	public static ControladorReceita getInstance() {
		if(instance == null) {
			instance = new ControladorReceita();
		}
		
		return instance;
	}
	
	public void cadastrarReceita(Receita receita) throws ObjetoJaExisteException{
	 
		if(receita == null) {
			throw new IllegalArgumentException("Inválido");
		}else if(this.repositorio.existe(receita)) {
			throw new ObjetoJaExisteException();
		}else {
			this.repositorio.cadastrarReceita(receita);
			
		}
	}
	
	public void atualizarReceita(Receita receita) throws ErroAoAtualizarException, ObjetoNaoExisteException{
		if(receita != null ) {
			this.repositorio.atualizarReceita(receita);
		}else {
			throw new IllegalArgumentException("Inválido");
		}
	}
	
	public void removerReceita(Receita receita)throws ErroAoRemoverException, ObjetoNaoExisteException {
		if(receita != null) {
			this.repositorio.removerReceita(receita);
		}else {
			throw new IllegalArgumentException("Inválido");
		}
	}
	
	ArrayList<Receita> listarReceita(){
		return this.repositorio.listarReceita();
	}
	
	Receita buscarReceita(String nome) throws ObjetoNaoExisteException{
		if(nome != null) {
			return this.repositorio.buscarReceita(nome);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
	}
	
	public boolean existe(Receita receita){
		if(receita == null) {
			throw new IllegalArgumentException("Inválido");
		}else {
			return this.repositorio.existe(receita);
		}
		
	}
	
	public void removeReceita(String descricao) throws ErroAoRemoverException, ObjetoNaoExisteException{
		if(descricao != null) {
			this.repositorio.removeReceita(descricao);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
	}
	
	
	
	
	
}
