package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.Carteira;

public class RepositorioCarteira implements IRepositorioCarteira{
	
	private ArrayList<Carteira> carteiras;
	private static RepositorioCarteira instance;
	
	private RepositorioCarteira() {
		carteiras = new ArrayList<Carteira>();
	}
	
	public static RepositorioCarteira getInstance() {
		if(instance == null) {
			instance = new RepositorioCarteira();
		}
		
		return instance; 
	}
	
	
	@Override
	public void cadastrarCarteira(Carteira carteira) {
		carteiras.add(carteira);
		
	}

	@Override
	public void removerCarteira(Carteira carteira) {
		int i = procurarIndice(carteira.getIdCarteira());
		
		if(i >= 0) {
			carteiras.remove(i);
		}else {
			
		}
		
	}

	@Override
	public void atualizarCarteira(Carteira carteira) {
		int i = procurarIndice(carteira.getIdCarteira());
		
		if(i >= 0) {
			carteiras.set(i, carteira);
		}else {
			
		}
		
	}

	@Override
	public ArrayList<Carteira> listarCarteira() {
		return carteiras;
	}

	@Override
	public int procurarIndice(String id) {
		int i = -1;
		
		for(int j = 0; j < carteiras.size(); j++) {
			if(carteiras.get(j).getIdCarteira().equals(id)){
				i = j;
			}
		}
		return i;
	}

	@Override
	public Carteira buscarCarteira(String id) {
		int i = procurarIndice(id);
		
		Carteira c = new Carteira();
		
		if(i >= 0) {
			c = carteiras.get(i);
		}else {
			
		}
		
		return c;
	}

	@Override
	public boolean existe(Carteira carteira) {
		boolean i = false;
		for(Carteira c : carteiras) {
			if(c.equals(carteira)) {
				i = true;
			}
			
		}
		return i;
	}

}
