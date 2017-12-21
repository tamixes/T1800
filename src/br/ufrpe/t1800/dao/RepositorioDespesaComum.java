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
import br.ufrpe.t1800.negocio.beans.DespesaComum;

public class RepositorioDespesaComum implements IRepositorioDespesaComum, Serializable{
	
	
	private static final long serialVersionUID = -1395398091956626856L;
	private ArrayList<DespesaComum> despesas;
	private static RepositorioDespesaComum instance;
	
	
	private  RepositorioDespesaComum() {
		despesas = new ArrayList<DespesaComum>();
	}
	
	public static RepositorioDespesaComum getInstance() {
		if(instance == null) {
			instance =  RepositorioDespesaComum.lerArquivo();
		}
			return instance;
		
	}
	
	@Override
	public void cadastraDespesaC(DespesaComum despesa) {
		despesas.add(despesa);
		
	}

	@Override
	public DespesaComum procurarDespesaC(String nome) throws ObjetoNaoExisteException{
		int i = procurarIndice(nome);
		
		DespesaComum d = new DespesaComum();
		if(i >= 0) {
			d = despesas.get(i);
		}else {
			throw new ObjetoNaoExisteException();
		}
		return d;
	}

	@Override
	public void atualizarDespesaC(DespesaComum despesa) throws ObjetoNaoExisteException, ErroAoAtualizarException{
		int i = procurarIndice(despesa.getDescriçao());
		if(i>= 0) {
			despesas.set(i, despesa);
		}else {
			throw new ErroAoAtualizarException();
		}
		
	}

	@Override
	public void removerDespesaC(DespesaComum despesa) throws ObjetoNaoExisteException, ErroAoRemoverException {
		int i = procurarIndice(despesa.getDescriçao());
		if(i >= 0) {
			despesas.remove(i);
		}else {
			throw new ErroAoRemoverException();
		}
		
	}

	@Override
	public ArrayList<DespesaComum> listarDespesaC() {
	
		return despesas;
	}

	@Override
	public boolean existe(DespesaComum despesa) {
		
		boolean i = false;
		for(DespesaComum d : despesas ) {
			if(d.equals(despesa)) {
				i = true;
			}
		}
		return i;
		
	}

	@Override
	public int procurarIndice(String nome) {
		int i = -1;
		for(int j = 0 ; j < despesas.size(); j++) {
			if(despesas.get(j).getDescriçao().equalsIgnoreCase(nome)){
				i = j;
			}
		
		}
		return i;
	}

	
	// ARQUIVO
	
		private static RepositorioDespesaComum lerArquivo() {
			RepositorioDespesaComum localInstance = null; 
			
			File arquivo = new File("repositorioDespesaComum.dat");
			
			FileInputStream fis = null; 
			ObjectInputStream ois = null;
			
			try {
				fis = new FileInputStream(arquivo);
				ois = new ObjectInputStream(fis);
				
				Object o = ois.readObject();
				localInstance  = (RepositorioDespesaComum) o;
				
			} catch (Exception e) {
				localInstance = new RepositorioDespesaComum();
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
			File arquivo = new File("repositorioDespesaComum.dat");
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
