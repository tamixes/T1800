package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.CartaoCredito;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.DespesaCartao;
import br.ufrpe.t1800.negocio.beans.DespesaComum;
import br.ufrpe.t1800.negocio.beans.Pessoa;
import br.ufrpe.t1800.negocio.beans.Receita;

public interface IFachada {
	//Pessoa
	void cadastrarPessoa(Pessoa pessoa);
	void removerPessoa(Pessoa pessoa);
	void atualizarPessoa(Pessoa pessoa);
	ArrayList<Pessoa> listarPessoa();
	Pessoa buscarPessoa(String nome);
	boolean existePessoa(Pessoa pessoa);
	
	//Cartao
	void cadastrarCartao(CartaoCredito cartao);
	void removerCartao(CartaoCredito cartao);
	void atualizarCartao(CartaoCredito cartao);
	ArrayList<CartaoCredito> listarCartao();
	CartaoCredito buscarCartao(String nome);
	boolean existeCartao(CartaoCredito cartao);
	
	//Receita
	void cadastrarReceita(Receita receita);
	void removerReceita(Receita receita);
	void atualizarReceita(Receita receita);
	ArrayList<Receita> listarReceita();
	Receita buscarReceita(String nome);
	boolean existeReceita(Receita receita);
	
	//Carteira
	void cadastrarCarteira(Carteira carteira);
	void removerCarteira(Carteira carteira);
	void atualizarCarteira(Carteira carteira);
	ArrayList<Carteira> listarCarteira();
	Carteira buscarCarteira(String id);
	boolean existeCarteira(Carteira carteira);
	
	//despesa comum
	
	void cadastrarDespesaComum(DespesaComum despesa);
	void removerDespesaComum(DespesaComum despesa);
	void atualizarDespesaComum(DespesaComum despesa);
	ArrayList<DespesaComum> listarDespesaComum();
	DespesaComum buscarDespesaComum(String descricao);
	boolean existeDespesaComum(DespesaComum despesa);
	
	//Despesa Cartao
	void cadastrarDespesaCartao(DespesaCartao despesa);
	void removerDespesaCartao(DespesaCartao despesa);
	void atualizarDespesaCartao(DespesaCartao despesa);
	ArrayList<DespesaCartao> listarDespesaCartao();
	DespesaCartao buscarDespesaCartao(String descricao);
	boolean existeDespesaCartao(DespesaCartao despesa);
}
