package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.CartaoCredito;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.DespesaCartao;
import br.ufrpe.t1800.negocio.beans.DespesaComum;
import br.ufrpe.t1800.negocio.beans.Pessoa;
import br.ufrpe.t1800.negocio.beans.Receita;

public class Fachada implements IFachada{
		
	private ControladorPessoa controladorPessoa;
	private ControladorCarteira controladorCarteira;
	private ControladorReceita controladorReceita;
	private ControladorCartao controladorCartao;
	private ControladorDespesaCartao controladorDespesaCartao;
	private ControladorDespesaComum controladorDespesaComum;
	private static Fachada instance;
	
	private Fachada() {
		this.controladorCartao = ControladorCartao.getInstance();
		this.controladorCarteira = ControladorCarteira.getInstance();
		this.controladorPessoa = ControladorPessoa.getInstance();
		this.controladorReceita = ControladorReceita.getInstance();
		this.controladorDespesaCartao = ControladorDespesaCartao.getInstance();
		this.controladorDespesaComum = ControladorDespesaComum.getInstance();
	}
	
	public static Fachada getInstance() {
		if(instance == null) {
			instance = new Fachada();
		}
		return instance; 
	}
	
	@Override
	public void cadastrarPessoa(Pessoa pessoa) {
		this.controladorPessoa.cadastrarPessoa(pessoa);
		
	}

	@Override
	public void removerPessoa(Pessoa pessoa) {
		this.controladorPessoa.removerPessoa(pessoa);
		
	}

	@Override
	public void atualizarPessoa(Pessoa pessoa) {
		this.controladorPessoa.removerPessoa(pessoa);
		
	}

	@Override
	public ArrayList<Pessoa> listarPessoa() {
		return this.controladorPessoa.listarPessoas();
	}

	@Override
	public Pessoa buscarPessoa(String nome) {
		return this.controladorPessoa.procurarPessoa(nome);
	}

	@Override
	public boolean existePessoa(Pessoa pessoa) {
		return this.controladorPessoa.existe(pessoa);
	}

	@Override
	public void cadastrarCartao(CartaoCredito cartao) {
		this.controladorCartao.cadastrarCartao(cartao);
		
	}

	@Override
	public void removerCartao(CartaoCredito cartao) {
		this.controladorCartao.removerCartao(cartao);
		
	}

	@Override
	public void atualizarCartao(CartaoCredito cartao) {
		this.controladorCartao.atualizarCartao(cartao);
		
	}

	@Override
	public ArrayList<CartaoCredito> listarCartao() {
		return this.controladorCartao.listarCartao();
	}

	@Override
	public CartaoCredito buscarCartao(String nome) {
		return this.controladorCartao.buscarCartao(nome);
	}

	@Override
	public boolean existeCartao(CartaoCredito cartao) {
		return this.controladorCartao.existe(cartao);
	}

	@Override
	public void cadastrarReceita(Receita receita) {
		this.controladorReceita.cadastrarReceita(receita);
		
	}

	@Override
	public void removerReceita(Receita receita) {
		this.controladorReceita.cadastrarReceita(receita);
		
	}

	@Override
	public void atualizarReceita(Receita receita) {
		this.controladorReceita.cadastrarReceita(receita);
		
	}

	@Override
	public ArrayList<Receita> listarReceita() {
		return this.controladorReceita.listarReceita();
	}

	@Override
	public Receita buscarReceita(String nome) {
		return this.controladorReceita.buscarReceita(nome);
	}

	@Override
	public boolean existeReceita(Receita receita) {
		return this.controladorReceita.existe(receita);
	}

	@Override
	public void cadastrarCarteira(Carteira carteira) {
		this.controladorCarteira.cadastrarCarteira(carteira);
		
	}

	@Override
	public void removerCarteira(Carteira carteira) {
		this.controladorCarteira.cadastrarCarteira(carteira);
		
	}

	@Override
	public void atualizarCarteira(Carteira carteira) {
		this.controladorCarteira.atualizarCarteira(carteira);
		
	}

	@Override
	public ArrayList<Carteira> listarCarteira() {
		return this.controladorCarteira.listarCarteira();
	}

	@Override
	public Carteira buscarCarteira(String id) {
		return this.controladorCarteira.buscarCarteira(id);
	}

	@Override
	public boolean existeCarteira(Carteira carteira) {
		return this.controladorCarteira.existe(carteira);
	}

	@Override
	public void cadastrarDespesaComum(DespesaComum despesa) {
		this.controladorDespesaComum.cadastrarDespesaC(despesa);
		
	}

	@Override
	public void removerDespesaComum(DespesaComum despesa) {
		this.controladorDespesaComum.cadastrarDespesaC(despesa);
		
	}

	@Override
	public void atualizarDespesaComum(DespesaComum despesa) {
		this.controladorDespesaComum.atualizarDespesaC(despesa);
		
	}

	@Override
	public ArrayList<DespesaComum> listarDespesaComum() {
		return this.controladorDespesaComum.listar();
	}

	@Override
	public DespesaComum buscarDespesaComum(String descricao) {
		
		return this.controladorDespesaComum.buscarDespesa(descricao);
	}

	@Override
	public boolean existeDespesaComum(DespesaComum despesa) {
		
		return this.controladorDespesaComum.existe(despesa);
	}

	@Override
	public void cadastrarDespesaCartao(DespesaCartao despesa) {
		this.controladorDespesaCartao.cadastrarDespesaCartao(despesa);
		
	}

	@Override
	public void removerDespesaCartao(DespesaCartao despesa) {
		this.controladorDespesaCartao.cadastrarDespesaCartao(despesa);
		
	}

	@Override
	public void atualizarDespesaCartao(DespesaCartao despesa) {
		this.controladorDespesaCartao.atualizarDespesaCartao(despesa);
		
	}

	@Override
	public ArrayList<DespesaCartao> listarDespesaCartao() {
		return this.controladorDespesaCartao.listar();
	}

	@Override
	public DespesaCartao buscarDespesaCartao(String descricao) {
		return this.controladorDespesaCartao.buscarDespesaCartao(descricao);
	}

	@Override
	public boolean existeDespesaCartao(DespesaCartao despesa) {
		return this.controladorDespesaCartao.existe(despesa);
	}

}
