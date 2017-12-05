package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioDespesaCartao;
import br.ufrpe.t1800.dao.RepositorioDespesaCartao;
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
	
	public void cadastrarDespesaCartao(DespesaCartao despesa) {
		if(despesa == null) {
			
		}else if(repositorio.existe(despesa)) {
			
		}else {
			repositorio.cadastrarDespesaCartao(despesa);
		}
	}
	
	public void removerDespesaCartao(DespesaCartao despesa) {
		if(despesa != null) {
			this.repositorio.removerDespesaCartao(despesa);
		}else {
			
		}
	}
	public void atualizarDespesaCartao(DespesaCartao despesa) {
		if(despesa != null) {
			this.repositorio.removerDespesaCartao(despesa);
		}else {
			
		}
	}
	public DespesaCartao buscarDespesaCartao(String descricao) {
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
		return this.repositorio.existe(despesa);
	}
	
}
