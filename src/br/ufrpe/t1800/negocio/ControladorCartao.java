package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioCartao;
import br.ufrpe.t1800.dao.RepositorioCartao;
import br.ufrpe.t1800.negocio.beans.CartaoCredito;

public class ControladorCartao {
	private static ControladorCartao instance;
	private IRepositorioCartao repositorio;
	
	private ControladorCartao() {
		this.repositorio = RepositorioCartao.getInstance();
	}
	
	public static ControladorCartao getInstance() {
		if(instance == null ) {
			instance = new ControladorCartao();
		}
		
		return instance; 
	}
	
	public void cadastrarCartao(CartaoCredito cartao) {
		if(cartao == null) {
			//exceçao 
		}else if(this.repositorio.existe(cartao)) {
			
		}else {
			repositorio.cadastrarCartao(cartao);
		}
		
	}
	
	public void removerCartao(CartaoCredito cartao) {
		if(cartao != null) {
			this.repositorio.removerCartao(cartao);
		}else {
			
		}
	}
	
	public void atualizarCartao(CartaoCredito cartao) {
		if(cartao != null) {
			this.repositorio.atualizarCartao(cartao);
		}else {
			
		}
	}
	
	public ArrayList<CartaoCredito> listarCartao(){
		return this.repositorio.listarCartao();
	}
	
	public CartaoCredito buscarCartao(String nome) {
	
		if(nome != null) {
			return this.repositorio.buscarCartao(nome);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
	}
	
	
	
	public boolean existe(CartaoCredito cartao) {
		
		return this.repositorio.existe(cartao);
		
	}
	
	
}
