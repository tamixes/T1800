package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.CartaoCredito;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.DespesaCartao;
import br.ufrpe.t1800.negocio.beans.DespesaComum;
import br.ufrpe.t1800.negocio.beans.Pessoa;
import br.ufrpe.t1800.negocio.beans.Receita;
import br.ufrpe.t1800.negocio.beans.Usuario;

public interface IFachada {
	//Pessoa
	void cadastrarPessoa(Pessoa pessoa) throws ObjetoJaExisteException;
	void removerPessoa(Pessoa pessoa) throws ErroAoRemoverException, ObjetoNaoExisteException;
	void atualizarPessoa(Pessoa pessoa) throws ErroAoAtualizarException, ObjetoNaoExisteException;
	ArrayList<Pessoa> listarPessoa();
	Pessoa buscarPessoa(String nome) throws ObjetoNaoExisteException;
	boolean existePessoa(Pessoa pessoa);
	boolean verificaLogin(Usuario usuario);
	
	//Cartao
	void cadastrarCartao(CartaoCredito cartao) throws ObjetoJaExisteException;
	void removerCartao(CartaoCredito cartao) throws ErroAoRemoverException, ObjetoNaoExisteException;
	void atualizarCartao(CartaoCredito cartao) throws ObjetoNaoExisteException, ErroAoAtualizarException;
	ArrayList<CartaoCredito> listarCartao();
	CartaoCredito buscarCartao(String nome) throws ObjetoNaoExisteException;
	boolean existeCartao(CartaoCredito cartao);
	void removeCartao(String descricao) throws ErroAoRemoverException, ObjetoNaoExisteException;
	
	//Receita
	void cadastrarReceita(Receita receita) throws ObjetoJaExisteException;
	void removerReceita(Receita receita) throws ErroAoRemoverException, ObjetoNaoExisteException;
	void atualizarReceita(Receita receita) throws ObjetoNaoExisteException, ErroAoAtualizarException;
	ArrayList<Receita> listarReceita();
	Receita buscarReceita(String nome) throws ObjetoNaoExisteException;
	boolean existeReceita(Receita receita);
	void removeReceita(String descricao) throws ObjetoNaoExisteException, ErroAoRemoverException;
	
	
	//Carteira
	void cadastrarCarteira(Carteira carteira) throws ObjetoJaExisteException;
	void removerCarteira(Carteira carteira) throws ObjetoNaoExisteException, ErroAoRemoverException;
	void atualizarCarteira(Carteira carteira) throws ObjetoNaoExisteException, ErroAoAtualizarException;
	ArrayList<Carteira> listarCarteira();
	Carteira buscarCarteira(String id) throws ObjetoNaoExisteException;
	boolean existeCarteira(Carteira carteira);
	void removeCarteira(String codigo) throws ObjetoNaoExisteException, ErroAoRemoverException;
	
	//despesa comum
	
	void cadastrarDespesaComum(DespesaComum despesa) throws ObjetoJaExisteException;
	void removerDespesaComum(DespesaComum despesa) throws ObjetoNaoExisteException, ErroAoRemoverException;
	void atualizarDespesaComum(DespesaComum despesa) throws ErroAoAtualizarException, ObjetoNaoExisteException;
	ArrayList<DespesaComum> listarDespesaComum();
	DespesaComum buscarDespesaComum(String descricao) throws ObjetoNaoExisteException;
	boolean existeDespesaComum(DespesaComum despesa);
	void removeDespesa(String descricao) throws ErroAoRemoverException, ObjetoNaoExisteException;
	
	//Despesa Cartao
	void cadastrarDespesaCartao(DespesaCartao despesa) throws ObjetoJaExisteException;
	void removerDespesaCartao(DespesaCartao despesa) throws ObjetoNaoExisteException, ErroAoRemoverException;
	void atualizarDespesaCartao(DespesaCartao despesa) throws ObjetoNaoExisteException, ErroAoAtualizarException;
	ArrayList<DespesaCartao> listarDespesaCartao();
	DespesaCartao buscarDespesaCartao(String descricao) throws ObjetoNaoExisteException;
	boolean existeDespesaCartao(DespesaCartao despesa);
	void removeDespesaCartao(String descricao) throws ErroAoRemoverException, ObjetoNaoExisteException;
}
