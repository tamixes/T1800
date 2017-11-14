package br.ufrpe.t1800.negocio.beans;

import java.time.LocalDate;

public class CartaoCredito {
	
	private Pessoa pessoa; 
	private LocalDate fechamento;
	private LocalDate pagamento;
	private String descriçao; 
	private double valor; 
	private String bandeira;
	
	
	public CartaoCredito(Pessoa pessoa, String descriçao, double valor, String bandeira, LocalDate fechamento, LocalDate pagamento) {
		
		this.pessoa = pessoa; 
		this.descriçao = descriçao;
		this.valor = valor;
		this.bandeira = bandeira; 
		this.fechamento = fechamento;
		this.pagamento = pagamento; 
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public LocalDate getFechamento() {
		return fechamento;
	}


	public void setFechamento(LocalDate fechamento) {
		this.fechamento = fechamento;
	}


	public LocalDate getPagamento() {
		return pagamento;
	}


	public void setPagamento(LocalDate pagamento) {
		this.pagamento = pagamento;
	}


	public String getDescriçao() {
		return descriçao;
	}


	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getBandeira() {
		return bandeira;
	}


	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	
	
	
}
