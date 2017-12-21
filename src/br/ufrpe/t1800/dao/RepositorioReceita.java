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
import br.ufrpe.t1800.negocio.beans.Receita;

public class RepositorioReceita implements IRepositorioReceita, Serializable{
	
	
	private static final long serialVersionUID = -842034375127234203L;
	private ArrayList<Receita> receitas;
	private static RepositorioReceita instance; 
	
	private RepositorioReceita() {
		receitas = new ArrayList<Receita>();
	}
	public static RepositorioReceita getInstance() {
		if(instance == null) {
			instance =  RepositorioReceita.lerArquivo();
		}
		return instance; 
	}
	
	@Override
	public void cadastrarReceita(Receita receita) {
		receitas.add(receita);
		
	}

	@Override
	public ArrayList<Receita> listarReceita() {
		
		return receitas;
	}

	@Override
	public Receita buscarReceita(String descricao) throws ObjetoNaoExisteException{
		int i = procurarIndice(descricao);
		
		Receita r = new Receita();
		
		if(i >= 0) {
			r = receitas.get(i);
		}else {
			throw new ObjetoNaoExisteException();
		}
		 return r;
	}

	@Override
	public void atualizarReceita(Receita receita) throws ObjetoNaoExisteException, ErroAoAtualizarException{
		int i = procurarIndice(receita.getDescricao());		
			
		if(i >= 0) {
			receitas.set(i, receita);
		}else {
			throw new ErroAoAtualizarException();
		}
		 
		
	}

	@Override
	public void removerReceita(Receita receita) throws ObjetoNaoExisteException, ErroAoRemoverException{
		int i = procurarIndice(receita.getDescricao());		
		
		if(i >= 0) {
			receitas.remove(i);
		}else {
			throw new ErroAoRemoverException();
		}
		
	}

	@Override
	public boolean existe(Receita receita) {
		boolean i = false; 
		
		for(Receita p : receitas) {
			if(p.equals(receita)) {
				i = true;
			}
		}
		return i;
	}

	@Override
	public int procurarIndice(String descricao) {
		int i = -1;
		for(int j = 0 ; j < receitas.size(); j++) {
			if(receitas.get(j).getDescricao().equals(descricao)){
				i = j;
			}
		
		}
		return i;
	}
	
	
	// ARQUIVO
	
		private static RepositorioReceita lerArquivo() {
			RepositorioReceita localInstance = null; 
			
			File arquivo = new File("repositorioReceita.dat");
			
			FileInputStream fis = null; 
			ObjectInputStream ois = null;
			
			try {
				fis = new FileInputStream(arquivo);
				ois = new ObjectInputStream(fis);
				
				Object o = ois.readObject();
				localInstance  = (RepositorioReceita) o;
				
			} catch (Exception e) {
				localInstance = new RepositorioReceita();
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
			File arquivo = new File("repositorioReceita.dat");
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
}
