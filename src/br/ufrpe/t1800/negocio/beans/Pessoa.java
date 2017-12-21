package br.ufrpe.t1800.negocio.beans;

import java.io.Serializable;

public class Pessoa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5476787932456464261L;
	private String nome;
	private String email;
	private String telefone;
	private Usuario usuario;
	
	
	
	public Pessoa(String nome, String email, String telefone, Usuario usuario) {
		
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.usuario = usuario;
	}

	
	public Pessoa() {
		
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	@Override
	public String toString() {
		String resultado = "\t\tDados Pessoais\n" 
						+"\t Nome: " + this.getNome()+ "\n"
						+"\t Email: " + this.getEmail()+ "\n"
						+"\t Telefone: " +this.getTelefone() + "\n";
		
		return resultado; 
	}




	@Override
	public boolean equals(Object obj) {
		Pessoa p = (Pessoa) obj;
		
		if(this.nome.equalsIgnoreCase(p.getNome()) && this.email.equalsIgnoreCase(p.getEmail()) && this.telefone.equals(p.getTelefone())) {
			return true;
		}
		return false;
	}
	
	

}
