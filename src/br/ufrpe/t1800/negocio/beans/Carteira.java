package br.ufrpe.t1800.negocio.beans;

public class Carteira {
	
	private Pessoa pessoa;
	private double valor; 
	private String titulo; 
	private String descriçao;
	
	
	public Carteira(Pessoa pessoa, double valor, String titulo, String descriçao) {
		super();
		this.pessoa = pessoa;
		this.valor = valor;
		this.titulo = titulo;
		this.descriçao = descriçao;
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
		this.valor = valor;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescriçao() {
		return descriçao;
	}


	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}
	
	
}
