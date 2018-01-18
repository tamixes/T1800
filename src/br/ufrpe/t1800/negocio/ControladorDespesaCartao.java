package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioDespesaCartao;
import br.ufrpe.t1800.dao.RepositorioDespesaCartao;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.DespesaCartao;

public class ControladorDespesaCartao {
	private static ControladorDespesaCartao instance;
	private IRepositorioDespesaCartao repositorio;
	
	private ControladorDespesaCartao() {
		this.repositorio = RepositorioDespesaCartao.getInstance();
	}
	
	public static ControladorDespesaCartao getInstance() {
		if(instance == null) {
			instance = new ControladorDespesaCartao();
		}
		
		return instance;
	}
	
	public void cadastrarDespesaCartao(DespesaCartao despesa) throws ObjetoJaExisteException{
		
		
		if(despesa == null) {
			throw new IllegalArgumentException("Inválido");
		}else if(this.repositorio.existe(despesa)) {
			throw new ObjetoJaExisteException();
		}else {
			repositorio.cadastrarDespesaCartao(despesa);
			
			
		}
	}
	
	public void removerDespesaCartao(DespesaCartao despesa) throws ObjetoNaoExisteException, ErroAoRemoverException{
		if(despesa != null) {
			this.repositorio.removerDespesaCartao(despesa);
		}else {
			throw new IllegalArgumentException("Inválido");
		}
	}
	public void removeDespesa(String descricao) throws ObjetoNaoExisteException, ErroAoRemoverException{
		if(descricao != null) {
			this.repositorio.removeDespesa(descricao);
		}else {
			throw new IllegalArgumentException("Inválido");
		}
	}
	public void atualizarDespesaCartao(DespesaCartao despesa) throws ObjetoNaoExisteException, ErroAoAtualizarException{
		if(despesa != null ) {
			this.repositorio.atualizarDespesaCartao(despesa);
		}else {
			throw new IllegalArgumentException("Inválido");
		}
	}
	public DespesaCartao buscarDespesaCartao(String descricao) throws ObjetoNaoExisteException{
		if(descricao != null) {
			return this.repositorio.buscarDespesaCartao(descricao);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
	}
	
	public ArrayList<DespesaCartao> listar(){
		return this.repositorio.listarDespesa();
	}
	
	public boolean existe(DespesaCartao despesa) {
		
		if(despesa == null) {
			throw new IllegalArgumentException("Inválido");
		}else {
			return this.repositorio.existe(despesa);
		}
		
	}
	
}
