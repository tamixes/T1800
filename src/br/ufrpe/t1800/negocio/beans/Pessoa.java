package br.ufrpe.t1800.negocio.beans;

public class Pessoa {
	
	private String nome;
	private String email;
	private String telefone;
	
	
	
	public Pessoa(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
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



	@Override
	public String toString() {
		String resultado = "\t\tDados Pessoais\n" 
						+"\t Nome: " + this.getNome()+ "\n"
						+"\t Email: " + this.getEmail()+ "\n"
						+"\t Telefone: " +this.getTelefone() + "\n";
		
		return resultado; 
	}
	
	

}
