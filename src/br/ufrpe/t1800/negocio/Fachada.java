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
	public void cadastrarPessoa(Pessoa pessoa) throws ObjetoJaExisteException {
		this.controladorPessoa.cadastrarPessoa(pessoa);
		
	}

	@Override
	public void removerPessoa(Pessoa pessoa) throws ErroAoRemoverException, ObjetoNaoExisteException {
		this.controladorPessoa.removerPessoa(pessoa);
		
	}

	@Override
	public void atualizarPessoa(Pessoa pessoa) throws ObjetoNaoExisteException, ErroAoAtualizarException {
		this.controladorPessoa.atualizarPessoa(pessoa);
	}

	@Override
	public ArrayList<Pessoa> listarPessoa() {
		return this.controladorPessoa.listarPessoas();
	}

	@Override
	public Pessoa buscarPessoa(String nome) throws ObjetoNaoExisteException {
		return this.controladorPessoa.procurarPessoa(nome);
	}

	@Override
	public boolean existePessoa(Pessoa pessoa) {
		return this.controladorPessoa.existe(pessoa);
	}

	@Override
	public void cadastrarCartao(CartaoCredito cartao) throws ObjetoJaExisteException {
		this.controladorCartao.cadastrarCartao(cartao);
		
	}

	@Override
	public void removerCartao(CartaoCredito cartao) throws ErroAoRemoverException, ObjetoNaoExisteException {
		this.controladorCartao.removerCartao(cartao);
		
	}

	@Override
	public void atualizarCartao(CartaoCredito cartao) throws ObjetoNaoExisteException, ErroAoAtualizarException {
		this.controladorCartao.atualizarCartao(cartao);
		
	}

	@Override
	public ArrayList<CartaoCredito> listarCartao() {
		return this.controladorCartao.listarCartao();
	}

	@Override
	public CartaoCredito buscarCartao(String nome) throws ObjetoNaoExisteException {
		return this.controladorCartao.buscarCartao(nome);
	}

	@Override
	public boolean existeCartao(CartaoCredito cartao) {
		return this.controladorCartao.existe(cartao);
	}
	
	@Override
	public long contadorCartao() {
		return this.controladorCartao.contadorCartao();
	}
	@Override
	public void cadastrarReceita(Receita receita) throws ObjetoJaExisteException {
		this.controladorReceita.cadastrarReceita(receita);
		
	}

	@Override
	public void removerReceita(Receita receita) throws ObjetoNaoExisteException, ErroAoRemoverException {
		this.controladorReceita.removerReceita(receita);
		
	}

	@Override
	public void atualizarReceita(Receita receita) throws ObjetoNaoExisteException {
		this.controladorReceita.atualizarReceita(receita);
		
	}

	@Override
	public ArrayList<Receita> listarReceita() {
		return this.controladorReceita.listarReceita();
	}

	@Override
	public Receita buscarReceita(String nome) throws ObjetoNaoExisteException {
		return this.controladorReceita.buscarReceita(nome);
	}

	@Override
	public boolean existeReceita(Receita receita) {
		return this.controladorReceita.existe(receita);
	}

	@Override
	public void cadastrarCarteira(Carteira carteira) throws ObjetoJaExisteException {
		this.controladorCarteira.cadastrarCarteira(carteira);
		
	}

	@Override
	public void removerCarteira(Carteira carteira) throws  ObjetoNaoExisteException, ErroAoRemoverException {
		this.controladorCarteira.removerCarteira(carteira);
		
	}

	@Override
	public void atualizarCarteira(Carteira carteira) throws ObjetoNaoExisteException {
		this.controladorCarteira.atualizarCarteira(carteira);
		
	}

	@Override
	public ArrayList<Carteira> listarCarteira() {
		return this.controladorCarteira.listarCarteira();
	}

	@Override
	public Carteira buscarCarteira(String id) throws ObjetoNaoExisteException {
		return this.controladorCarteira.buscarCarteira(id);
	}

	@Override
	public boolean existeCarteira(Carteira carteira) {
		return this.controladorCarteira.existe(carteira);
	}

	@Override
	public void cadastrarDespesaComum(DespesaComum despesa) throws ObjetoJaExisteException {
		this.controladorDespesaComum.cadastrarDespesaC(despesa);
		
	}

	@Override
	public void removerDespesaComum(DespesaComum despesa) throws ObjetoNaoExisteException, ErroAoRemoverException {
		this.controladorDespesaComum.removerDespesaC(despesa);
		
	}

	@Override
	public void atualizarDespesaComum(DespesaComum despesa) throws ErroAoAtualizarException, ObjetoNaoExisteException {
		this.controladorDespesaComum.atualizarDespesaC(despesa);
		
	}

	@Override
	public ArrayList<DespesaComum> listarDespesaComum() {
		return this.controladorDespesaComum.listar();
	}

	@Override
	public DespesaComum buscarDespesaComum(String descricao) throws ObjetoNaoExisteException {
		
		return this.controladorDespesaComum.buscarDespesa(descricao);
	}

	@Override
	public boolean existeDespesaComum(DespesaComum despesa) {
		
		return this.controladorDespesaComum.existe(despesa);
	}

	@Override
	public void cadastrarDespesaCartao(DespesaCartao despesa) throws ObjetoJaExisteException {
		this.controladorDespesaCartao.cadastrarDespesaCartao(despesa);
		
	}

	@Override
	public void removerDespesaCartao(DespesaCartao despesa) throws ObjetoNaoExisteException, ErroAoRemoverException {
		this.controladorDespesaCartao.removerDespesaCartao(despesa);
		
	}

	@Override
	public void atualizarDespesaCartao(DespesaCartao despesa) throws ObjetoNaoExisteException, ErroAoAtualizarException {
		this.controladorDespesaCartao.atualizarDespesaCartao(despesa);
		
	}

	@Override
	public ArrayList<DespesaCartao> listarDespesaCartao() {
		return this.controladorDespesaCartao.listar();
	}

	@Override
	public DespesaCartao buscarDespesaCartao(String descricao) throws ObjetoNaoExisteException {
		return this.controladorDespesaCartao.buscarDespesaCartao(descricao);
	}

	@Override
	public boolean existeDespesaCartao(DespesaCartao despesa) {
		return this.controladorDespesaCartao.existe(despesa);
	}

	@Override
	public boolean verificaLogin(Usuario usuario) {
		return this.controladorPessoa.login(usuario.getLogin(), usuario.getSenha());
	}

	@Override
	public void removeCarteira(String codigo) throws ObjetoNaoExisteException, ErroAoRemoverException {
		this.controladorCarteira.removerCarteira(codigo);
		
	}

	@Override
	public void removeCartao(String descricao) throws ErroAoRemoverException, ObjetoNaoExisteException {
		this.controladorCartao.removeCartao(descricao);
		
	}

	@Override
	public void removeReceita(String descricao) throws ObjetoNaoExisteException, ErroAoRemoverException {
		this.controladorReceita.removeReceita(descricao);
		
	}

	@Override
	public void removeDespesa(String descricao) throws ErroAoRemoverException, ObjetoNaoExisteException {
		this.controladorDespesaComum.removeDespesa(descricao);
		
	}

	@Override
	public void removeDespesaCartao(String descricao) throws ErroAoRemoverException, ObjetoNaoExisteException {
		this.controladorDespesaCartao.removeDespesa(descricao);
		
	}

}
