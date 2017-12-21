package br.ufrpe.t1800.negocio.beans;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1524271014780799548L;
	private String login;
	private String senha;
	
	
	public Usuario(String login, String senha) {
		
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario() {
		
	}

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean equals(Object o) {
		Usuario outro = (Usuario) o;
		if(outro != null && this.login.equalsIgnoreCase(outro.getLogin()) && this.senha.equals(outro.getSenha())) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Login: " + login + "\n" + "Senha: " + senha;
	}
	
	
	
}
