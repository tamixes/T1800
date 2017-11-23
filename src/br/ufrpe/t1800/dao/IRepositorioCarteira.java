package br.ufrpe.t1800.dao;

import java.util.ArrayList;

import br.ufrpe.t1800.negocio.beans.Carteira;

public interface IRepositorioCarteira {
	
	void cadastrarCarteira(Carteira carteira);
	void removerCarteira(Carteira carteira);
	void atualizarCarteira(Carteira carteira);
	ArrayList<Carteira> listarCarteira();
	int procurarIndice(String id);
	Carteira buscarCarteira(String id);
	boolean existe(Carteira carteira);
}
