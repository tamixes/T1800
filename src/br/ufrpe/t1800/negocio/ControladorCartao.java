package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioCartao;
import br.ufrpe.t1800.dao.RepositorioCartao;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
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
	
	public void cadastrarCartao(CartaoCredito cartao) throws ObjetoJaExisteException {
		if(cartao == null) {
			throw new IllegalArgumentException("Inválido!");
		}else if(this.repositorio.existe(cartao)) {
			throw new ObjetoJaExisteException();
		}else {
			repositorio.cadastrarCartao(cartao);
		}
		
	}
	
	public void removerCartao(CartaoCredito cartao) throws ErroAoRemoverException, ObjetoNaoExisteException{
		if(cartao != null) {
			this.repositorio.removerCartao(cartao);
		}else {
			throw new IllegalArgumentException("Inválido");
		}
	}
	
		
	
	public void atualizarCartao(CartaoCredito cartao) throws ObjetoNaoExisteException, ErroAoAtualizarException {
		if(cartao != null) {
			this.repositorio.atualizarCartao(cartao);
		}else {
			throw new IllegalArgumentException("Inválido");
		}
	}
	
	public ArrayList<CartaoCredito> listarCartao(){
		return this.repositorio.listarCartao();
	}
	
	public CartaoCredito buscarCartao(String nome) throws ObjetoNaoExisteException{
	
		if(nome != null) {
			return this.repositorio.buscarCartao(nome);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
	}
	
	public void removeCartao(String descricao) throws ObjetoNaoExisteException, ErroAoRemoverException{
		if(descricao != null) {
			this.repositorio.removeCartao(descricao);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
	}
	
	public boolean existe(CartaoCredito cartao) {
		
		return this.repositorio.existe(cartao);
		
	}
	
	
}
