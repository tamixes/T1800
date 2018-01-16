package br.ufrpe.t1800.negocio.beans;

import java.io.Serializable;

public class Carteira implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7095336030568535549L;
	private Pessoa pessoa;
	private double valor; 
	private String titulo; 
	private String descricao;
	private static long geraId = 10;
	private String idCarteira;
	
	
	public Carteira(Pessoa pessoa, double valor, String titulo, String descricao) {
		this.idCarteira = "T"+ geraId + "WALLET";
		geraId++;
		this.pessoa = pessoa;
		this.valor = valor;
		this.titulo = titulo;
		this.descricao = descricao;
		
		
	}

	public Carteira() {
		
	}
	
	public Carteira(String titulo, String descricao, double valor) {
		
		
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		if(valor >= 0.0) {
			this.valor = valor;
		}else {
			System.out.println("Valor inválido!");
		}
		
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getIdCarteira() {
		return idCarteira;
	}


	@Override
	public String toString() {
		String resultado = "\t\tDados da Carteira\n" 
						+"\t Titulo: " + this.getTitulo() + "\n"
						+"\t Nome da Carteira: " +this.getDescricao() + "\n"
						+"\t Id da Carteira: " + this.getIdCarteira()+ "\n"
						+"\t Valor na Carteira: " + this.getValor()+ "\n";
		
		return resultado; 
	}


	

	@Override
	public boolean equals(Object obj) {
		Carteira c = (Carteira) obj;
		if(c != null && this.descricao.equalsIgnoreCase(c.getDescricao()) && this.idCarteira.equals(c.getIdCarteira())) {
			return true;
		}
		return false; 
		
	}
	
	
}
