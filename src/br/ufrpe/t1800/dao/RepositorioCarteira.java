package br.ufrpe.t1800.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.beans.Carteira;

public class RepositorioCarteira implements IRepositorioCarteira, Serializable{
	
	
	private static final long serialVersionUID = 5041401834551666531L;
	private ArrayList<Carteira> carteiras;
	private static RepositorioCarteira instance;
	
	private RepositorioCarteira() {
		carteiras = new ArrayList<Carteira>();
	}
	
	public static RepositorioCarteira getInstance() {
		if(instance == null) {
			instance = RepositorioCarteira.lerArquivo();
		}
		
		return instance; 
	}
	
	
	@Override
	public void cadastrarCarteira(Carteira carteira) {
		carteiras.add(carteira);
		
	}

	@Override
	public void removerCarteira(Carteira carteira) throws ObjetoNaoExisteException, ErroAoRemoverException {
		int i = procurarIndice(carteira.getIdCarteira());
		
		if(i >= 0) {
			carteiras.remove(i);
		}else {
			throw new ErroAoRemoverException();
		}
		
	}

	@Override
	public void atualizarCarteira(Carteira carteira) throws  ObjetoNaoExisteException{
		int i = procurarIndice(carteira.getIdCarteira());
		
		if(i >= 0) {
			carteiras.set(i, carteira);
		}else {
			throw new ObjetoNaoExisteException();
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
	public Carteira buscarCarteira(String id) throws ObjetoNaoExisteException{
		int i = procurarIndice(id);
		
		Carteira c = new Carteira();
		
		if(i >= 0) {
			c = carteiras.get(i);
		}else {
			throw new ObjetoNaoExisteException();
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
	
	// ARQUIVO
	
		private static RepositorioCarteira lerArquivo() {
			RepositorioCarteira localInstance = null; 
			
			File arquivo = new File("repositorioCarteira.dat");
			
			FileInputStream fis = null; 
			ObjectInputStream ois = null;
			
			try {
				fis = new FileInputStream(arquivo);
				ois = new ObjectInputStream(fis);
				
				Object o = ois.readObject();
				localInstance  = (RepositorioCarteira) o;
				
			} catch (Exception e) {
				localInstance = new RepositorioCarteira();
			}finally {
				if(ois != null) {
					try {
						ois.close();
					} catch (IOException e2) {
						// TODO: handle exception
					}
				}
			}
			return localInstance;
		}
		
		public void salvarArquivo() {
			if(instance == null) {
				return;
			}
			File arquivo = new File("repositorioCarteira.dat");
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			
			try {
				if(!arquivo.exists())
					arquivo.createNewFile();
				
				fos = new FileOutputStream(arquivo);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(instance);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(oos != null) {
					try {
						oos.close();
					}catch (IOException e) {
						// TODO: handle exception
					}
				}
			}
		
		}

		@Override
		public void removeCarteira(String codigo) throws ObjetoNaoExisteException, ErroAoRemoverException {
			int indice = procurarIndice(codigo);
			
			if(indice >= 0) {
				carteiras.remove(indice);
			}else {
				throw new ErroAoRemoverException();
			}
		}
}
