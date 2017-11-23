package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.CartaoCredito;

public class RepositorioCartao implements IRepositorioCartao {

	private ArrayList<CartaoCredito> cartoes;
	private static RepositorioCartao instance;
	
	private RepositorioCartao() {
		cartoes = new ArrayList<CartaoCredito>();
	}
	
	public static RepositorioCartao getInstance() {
		if(instance == null) {
			instance = new RepositorioCartao();
		}
		return instance;
	}
	
	@Override
	public void cadastrarCartao(CartaoCredito cartao) {
		cartoes.add(cartao);
		
	}

	@Override
	public void atualizarCartao(CartaoCredito cartao) {
		int i = buscarIndice(cartao.getDescricao());
		
		if(i >= 0) {
			cartoes.set(i, cartao);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
		
	}

	@Override
	public void removerCartao(CartaoCredito cartao) {
		int i = buscarIndice(cartao.getDescricao());
		
		if(i >= 0) {
			cartoes.remove(i);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
		
	}

	@Override
	public CartaoCredito buscarCartao(String nome) {
		int i = buscarIndice(nome);
		
		CartaoCredito c = new CartaoCredito();
		
		if(i >= 0) {
			c = cartoes.get(i);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
		
		return c;
	}

	@Override
	public int buscarIndice(String nome) {
		int i = -1;
		for(int j = 0 ; j < cartoes.size(); j++) {
			if(cartoes.get(j).getDescricao().equalsIgnoreCase(nome)){
				i = j;
			}
		
		}
		return i;
	}

	@Override
	public ArrayList<CartaoCredito> listarCartao() {
		return cartoes;
	}

	@Override
	public boolean existe(CartaoCredito cartao) {
		boolean i = false;
		for(CartaoCredito c : cartoes ) {
			if(c.equals(cartao)) {
				i = true;
			}
		}
		return i;
	}

}
