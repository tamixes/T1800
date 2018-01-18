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
import br.ufrpe.t1800.negocio.beans.CartaoCredito;

public class RepositorioCartao implements IRepositorioCartao, Serializable{


	private static final long serialVersionUID = 184836574374500028L;
	private ArrayList<CartaoCredito> cartoes;
	private static RepositorioCartao instance;
	
	private RepositorioCartao() {
		cartoes = new ArrayList<CartaoCredito>();
	}
	
	public static RepositorioCartao getInstance() {
		if(instance == null) {
			instance =  RepositorioCartao.lerArquivo();
		}
		return instance;
	}
	
	@Override
	public void cadastrarCartao(CartaoCredito cartao) {
		cartoes.add(cartao);
		
	}

	@Override
	public void atualizarCartao(CartaoCredito cartao) throws ErroAoAtualizarException, ObjetoNaoExisteException{
		int i = buscarIndice(cartao.getDescricao());
		
		if(i >= 0) {
			cartoes.set(i, cartao);
		}else {
			throw new ErroAoAtualizarException();
		}
		
	}

	@Override
	public void removerCartao(CartaoCredito cartao) throws ErroAoRemoverException, ObjetoNaoExisteException{
		int i = buscarIndice(cartao.getDescricao());
		
		if(i >= 0) {
			cartoes.remove(i);
		}else {
			throw new ErroAoRemoverException();
		}
		
	}

	@Override
	public CartaoCredito buscarCartao(String nome) throws ObjetoNaoExisteException{
		int i = buscarIndice(nome);
		
		CartaoCredito c = new CartaoCredito();
		
		if(i >= 0) {
			c = cartoes.get(i);
		}else {
			throw new ObjetoNaoExisteException();
		}
		
		return c;
	}

	@Override
	public int buscarIndice(String nome) {
		int i = -1;
		for(int j = 0 ; j < cartoes.size(); j++) {
			if(cartoes.get(j).getDescricao().equalsIgnoreCase(nome)){
				i = j;
			}
		
		}
		return i;
	}

	@Override
	public ArrayList<CartaoCredito> listarCartao() {
		return cartoes;
	}

	@Override
	public boolean existe(CartaoCredito cartao) {
		boolean i = false;
		for(CartaoCredito c : cartoes ) {
			if(c.equals(cartao)) {
				i = true;
			}
		}
		return i;
	}

	// ARQUIVO
	
	private static RepositorioCartao lerArquivo() {
		RepositorioCartao localInstance = null; 
		
		File arquivo = new File("repositorioCartao.dat");
		
		FileInputStream fis = null; 
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(arquivo);
			ois = new ObjectInputStream(fis);
			
			Object o = ois.readObject();
			localInstance  = (RepositorioCartao) o;
			
		} catch (Exception e) {
			localInstance = new RepositorioCartao();
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
		File arquivo = new File("repositorioCartao.dat");
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
	public void removeCartao(String descricao) throws ErroAoRemoverException, ObjetoNaoExisteException {
		int indice = buscarIndice(descricao);
		
		if(indice >= 0) {
			cartoes.remove(indice);
		}else {
			throw new ErroAoRemoverException();
		}
		
	}
}
