package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioCarteira;
import br.ufrpe.t1800.dao.RepositorioCarteira;
import br.ufrpe.t1800.negocio.beans.Carteira;

public class ControladorCarteira {
	private static ControladorCarteira instance;
	private IRepositorioCarteira repositorio;
	
	private  ControladorCarteira() {
		this.repositorio = RepositorioCarteira.getInstance();
	}
	
	public static ControladorCarteira getInstance() {
		if(instance == null) {
			instance = new ControladorCarteira();
		}
		return instance; 
	}
	
	
	public void cadastrarCarteira(Carteira carteira) {
		if(carteira == null) {
			
		}else if(this.repositorio.existe(carteira)) {
			
		}else {
			this.repositorio.cadastrarCarteira(carteira);
		}
	}
	
	public void removerCarteira(Carteira carteira) {
		if(carteira != null) {
			this.repositorio.removerCarteira(carteira);
		}else {
			
		}
	}
	
	public void atualizarCarteira(Carteira carteira) {
		if(carteira != null) {
			this.repositorio.atualizarCarteira(carteira);
		}else {
			
		}
	}
	
	public ArrayList<Carteira> listarCarteira(){
		return this.repositorio.listarCarteira();
	}
	
	public Carteira buscarCarteira(String id) {
		if(id != null) {
			return this.repositorio.buscarCarteira(id);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
	}
	
	boolean existe(Carteira carteira) {
		return this.repositorio.existe(carteira);
	}
}
