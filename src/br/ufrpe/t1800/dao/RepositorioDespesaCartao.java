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
import br.ufrpe.t1800.negocio.beans.DespesaCartao;

public class RepositorioDespesaCartao implements IRepositorioDespesaCartao, Serializable{

	
	private static final long serialVersionUID = 5322762420817507087L;
	private ArrayList<DespesaCartao> despesas;
	private static RepositorioDespesaCartao instance;
	
	private RepositorioDespesaCartao() {
		despesas = new ArrayList<DespesaCartao>();
	}
	
	public static RepositorioDespesaCartao getInstance() {
		if(instance == null) {
			instance =  RepositorioDespesaCartao.lerArquivo();
		}
		return instance;
	}
	
	
	@Override
	public void cadastrarDespesaCartao(DespesaCartao despesa) {
		despesas.add(despesa);
		
	}

	@Override
	public void atualizarDespesaCartao(DespesaCartao despesa) throws ErroAoAtualizarException, ObjetoNaoExisteException{
		int i = buscarIndice(despesa.getDescriçao());
		
		if(i >= 0) {
			despesas.set(i, despesa);
		}else {
			throw new ErroAoAtualizarException();
		}
		
	}

	@Override
	public void removerDespesaCartao(DespesaCartao despesa) throws ErroAoRemoverException, ObjetoNaoExisteException{
		int i = buscarIndice(despesa.getDescriçao());
		if(i >= 0) {
			despesas.remove(i);
		}else {
			throw new ErroAoRemoverException();
		}
		
	}
	@Override
	public void removeDespesa(String descricao) throws ErroAoRemoverException, ObjetoNaoExisteException{
		int i = buscarIndice(descricao);
		if(i >= 0) {
			despesas.remove(i);
		}else {
			throw new ErroAoRemoverException();
		}
		
	}
	@Override
	public DespesaCartao buscarDespesaCartao(String descricao) throws ObjetoNaoExisteException{
		int i = buscarIndice(descricao);
		 DespesaCartao d = new DespesaCartao();
		 
		 if(i >= 0) {
			 d = despesas.get(i);
		 }else {
			 throw new ObjetoNaoExisteException();
		 }
		 
		 return d;
	}

	@Override
	public int buscarIndice(String descricao) {
		int i = -1;
		for(int j = 0; j < despesas.size(); j++) {
			if(despesas.get(j).getDescriçao().equalsIgnoreCase(descricao)) {
				i = j;
			}
		}
		return i;
	}

	@Override
	public ArrayList<DespesaCartao> listarDespesa() {
		return despesas;
	}

	@Override
	public boolean existe(DespesaCartao despesa) {
		boolean i = false;
		for(DespesaCartao d: despesas) {
			if(d.equals(despesa)) {
				i = true;
			}
		}
		return i;
			
	}
	
	// ARQUIVO
	
		private static RepositorioDespesaCartao lerArquivo() {
			RepositorioDespesaCartao localInstance = null; 
			
			File arquivo = new File("repositorioDespesaCartao.dat");
			
			FileInputStream fis = null; 
			ObjectInputStream ois = null;
			
			try {
				fis = new FileInputStream(arquivo);
				ois = new ObjectInputStream(fis);
				
				Object o = ois.readObject();
				localInstance  = (RepositorioDespesaCartao) o;
				
			} catch (Exception e) {
				localInstance = new RepositorioDespesaCartao();
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
			File arquivo = new File("repositorioDespesaCartao.dat");
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
