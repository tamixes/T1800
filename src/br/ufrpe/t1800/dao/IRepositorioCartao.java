package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.CartaoCredito;

public interface IRepositorioCartao {
		
	
		void cadastrarCartao(CartaoCredito cartao);
		void atualizarCartao(CartaoCredito cartao) throws ErroAoAtualizarException, ObjetoNaoExisteException;
		void removerCartao(CartaoCredito cartao) throws ErroAoRemoverException, ObjetoNaoExisteException;
		CartaoCredito buscarCartao(String nome) throws ObjetoNaoExisteException;
		int buscarIndice(String nome);
		ArrayList<CartaoCredito> listarCartao();
		boolean existe(CartaoCredito cartao);
		void salvarArquivo();
		void removeCartao(String descricao) throws ErroAoRemoverException, ObjetoNaoExisteException;
}
