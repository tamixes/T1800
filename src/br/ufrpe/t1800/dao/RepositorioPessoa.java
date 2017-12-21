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
import br.ufrpe.t1800.negocio.beans.Pessoa;
import br.ufrpe.t1800.negocio.beans.Usuario;

public class RepositorioPessoa implements IRepositorioPessoa, Serializable{

	
	private static final long serialVersionUID = -8343281501164085333L;
	private ArrayList<Pessoa> pessoas;
	private static RepositorioPessoa instance;
	
	private RepositorioPessoa() {
		pessoas = new ArrayList<Pessoa>();
		
	}
	
	public static RepositorioPessoa getInstance() {
		if(instance == null) {
			instance = RepositorioPessoa.lerArquivo();
		}
		return instance; 
	}
	
	
	
	@Override
	public void cadastrarPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
		
	}

	@Override
	public Pessoa procurarPessoa(String nome) throws ObjetoNaoExisteException {
		int i = procurarIndice(nome);
		
		Pessoa resultado = new Pessoa();
		
		if(i >= 0) {
			resultado = pessoas.get(i);
		}else {
			throw new ObjetoNaoExisteException();
		}
		 return resultado;
	}

	@Override
	public void atualizarPessoa(Pessoa pessoa) throws ErroAoAtualizarException, ObjetoNaoExisteException{
		int i = procurarIndice(pessoa.getNome());
		
		if(i >= 0) {
			pessoas.set(i, pessoa);
		}else {
			throw new ErroAoAtualizarException();
		}
		
	}

	@Override
	public void removerPessoa(Pessoa pessoa) throws ErroAoRemoverException, ObjetoNaoExisteException{
		int i = procurarIndice(pessoa.getNome());
		
		if(i >= 0) {
			pessoas.remove(i);
		}else {
			throw new ErroAoRemoverException();
		}
		
	}

	@Override
	public ArrayList<Pessoa> listarPessoas() {
		return pessoas;
	}

	@Override
	public boolean existe(Pessoa pessoa) {
		boolean i = false; 
		
		for(Pessoa p : pessoas) {
			if(p.equals(pessoa)) {
				i= true;
				
			}
			
		}
		return i;
	}

	public int procurarIndice(String nome) {
		int i = -1;
		for(int j = 0 ; j < pessoas.size(); j++) {
			if(pessoas.get(j).getNome().equalsIgnoreCase(nome)){
				i = j;
			}
		
		}
		return i;
	}
	
	public boolean verificaLogin(Usuario usuario) {
		boolean r = false; 
		
		for(int i = 0; i<pessoas.size(); i++) {
			if(this.pessoas.get(i) instanceof Pessoa) {
				if(((Pessoa) this.pessoas.get(i)).getUsuario().equals(usuario)) {
					r = true;
				}
			}
		}
		return r;
	}
	
	
	
	// ARQUIVO
	
	private static RepositorioPessoa lerArquivo() {
		RepositorioPessoa localInstance = null; 
		
		File arquivo = new File("repositorioPessoa.dat");
		
		FileInputStream fis = null; 
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(arquivo);
			ois = new ObjectInputStream(fis);
			
			Object o = ois.readObject();
			localInstance  = (RepositorioPessoa) o;
			
		} catch (Exception e) {
			localInstance = new RepositorioPessoa();
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
		File arquivo = new File("repositorioPessoa.dat");
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
