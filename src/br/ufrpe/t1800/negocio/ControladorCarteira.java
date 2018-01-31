package br.ufrpe.t1800.negocio;

import java.util.ArrayList;

import br.ufrpe.t1800.dao.IRepositorioCarteira;
import br.ufrpe.t1800.dao.RepositorioCarteira;
import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
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
	
	
	public void cadastrarCarteira(Carteira carteira) throws ObjetoJaExisteException{
		if(carteira == null) {
			throw new IllegalArgumentException("Inválido");
			
		}else if(this.repositorio.existe(carteira)) {
			throw new ObjetoJaExisteException();
		}else {
			this.repositorio.cadastrarCarteira(carteira);
			
		}
	}
	
	public void removerCarteira(Carteira carteira) throws ObjetoNaoExisteException, ErroAoRemoverException{
		if(carteira != null) {
			this.repositorio.removerCarteira(carteira);
		}else {
			throw new IllegalArgumentException("Inválido");
		}
	}
	
	
	public void removerCarteira(String codigo) throws ObjetoNaoExisteException, ErroAoRemoverException{
		if(codigo!= null) {
			repositorio.removeCarteira(codigo);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
	}
	public void atualizarCarteira(Carteira carteira) throws ObjetoNaoExisteException{
		if(carteira != null ) {
			this.repositorio.atualizarCarteira(carteira);
		}else {
			throw new IllegalArgumentException("Inválido");
		}
	}
	
	public ArrayList<Carteira> listarCarteira(){
		return this.repositorio.listarCarteira();
	}
	
	public Carteira buscarCarteira(String id) throws ObjetoNaoExisteException{
		if(id != null) {
			return this.repositorio.buscarCarteira(id);
		}else {
			throw new IllegalArgumentException("Invalido");
		}
	}
	
	boolean existe(Carteira carteira) {
		if(carteira == null) {
			throw new IllegalArgumentException("Inválido");
		}else {
			return this.repositorio.existe(carteira);
		}
	
	}
}
