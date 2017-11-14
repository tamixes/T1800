package br.ufrpe.t1800.negocio.beans;

import java.time.LocalDate;

public class DespesaCartao {
	
	private CartaoCredito cartao;
	private double valor; 
	private LocalDate dataCompra; 
	private String descriçao; 
	private String tipo; 
	private int parcela;
	
	
	public DespesaCartao(CartaoCredito cartao, double valor, LocalDate dataCompra, String descriçao, String tipo, int parcela) {
		super();
		this.cartao = cartao;
		this.valor = valor;
		this.dataCompra = dataCompra;
		this.descriçao = descriçao;
		this.tipo = tipo; 
		this.parcela = parcela;
	}


	public CartaoCredito getCartao() {
		return cartao;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public void setCartao(CartaoCredito cartao) {
		this.cartao = cartao;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public LocalDate getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}


	public String getDescriçao() {
		return descriçao;
	}


	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}


	public int getParcela() {
		return parcela;
	}


	public void setParcela(int parcela) {
		this.parcela = parcela;
	}
	
}
