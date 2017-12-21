package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioPessoa;
import br.ufrpe.t1800.dao.RepositorioPessoa;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.Pessoa;
import br.ufrpe.t1800.negocio.beans.Usuario;

public class ControladorPessoa {
	private static ControladorPessoa instance;
	private IRepositorioPessoa repositorio;

	private ControladorPessoa() {
		this.repositorio = RepositorioPessoa.getInstance();
	}

	public static ControladorPessoa getInstance() {
		if (instance == null) {
			instance = new ControladorPessoa();
		}
		return instance;
	}

	public void cadastrarPessoa(Pessoa pessoa)throws ObjetoJaExisteException {
		if (pessoa == null) {
			throw new IllegalArgumentException("Invalido");
		}else if(this.repositorio.existe(pessoa)){
			throw new ObjetoJaExisteException();
		}else {
			repositorio.cadastrarPessoa(pessoa);
		}
	}

	public Pessoa procurarPessoa(String nome) throws ObjetoNaoExisteException {
		if (nome != null) {
			return this.repositorio.procurarPessoa(nome);
		} else {
			throw new IllegalArgumentException("Invalido");
		}
	}

	public void atualizarPessoa(Pessoa pessoa) throws ObjetoNaoExisteException, ErroAoAtualizarException{
		if (pessoa != null) {
			repositorio.atualizarPessoa(pessoa);
		} else {
			throw new IllegalArgumentException("Invalido");
		}
	}

	public void removerPessoa(Pessoa pessoa) throws ErroAoRemoverException, ObjetoNaoExisteException{
		if (pessoa != null) {
			repositorio.removerPessoa(pessoa);
		} else {
			throw new IllegalArgumentException("Invalido");

		}
	}

	public ArrayList<Pessoa> listarPessoas() {
		return this.repositorio.listarPessoas();
	}

	public boolean existe(Pessoa pessoa) {
		if(pessoa == null) {
			throw new IllegalArgumentException("Inválido");
		}else {
			return this.repositorio.existe(pessoa);
		}
		

	}
	
	public boolean login(String login, String senha) {
		Usuario u = new Usuario(login, senha);
		boolean r = false; 
		if(this.repositorio.verificaLogin(u)) {
			r = true;
		}
		return r;
	}
}
