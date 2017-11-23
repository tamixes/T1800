package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.CartaoCredito;

public interface IRepositorioCartao {
		
	
		void cadastrarCartao(CartaoCredito cartao);
		void atualizarCartao(CartaoCredito cartao);
		void removerCartao(CartaoCredito cartao);
		CartaoCredito buscarCartao(String nome);
		int buscarIndice(String nome);
		ArrayList<CartaoCredito> listarCartao();
		
}
