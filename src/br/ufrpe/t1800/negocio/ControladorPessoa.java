package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioPessoa;
import br.ufrpe.t1800.dao.RepositorioPessoa;
import br.ufrpe.t1800.negocio.beans.Pessoa;

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

	public void cadastrarPessoa(Pessoa pessoa) {
		if (pessoa == null) {
			throw new IllegalArgumentException("Invalido");
		}else if(this.repositorio.existe(pessoa)){
			
		}else {
			repositorio.cadastrarPessoa(pessoa);
		}
	}

	public Pessoa procurarPessoa(String nome) {
		if (nome != null) {
			return this.repositorio.procurarPessoa(nome);
		} else {
			throw new IllegalArgumentException("Invalido");
		}
	}

	public void atualizarPessoa(Pessoa pessoa) {
		if (pessoa != null) {
			repositorio.atualizarPessoa(pessoa);
		} else {
			throw new IllegalArgumentException("Invalido");
		}
	}

	public void removerPessoa(Pessoa pessoa) {
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
		return this.repositorio.existe(pessoa);

	}
}
