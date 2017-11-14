package br.ufrpe.t1800.negocio.beans;

import java.time.LocalDate;

public class DespesaCartao {
	
	private CartaoCredito cartao;
	private double valor; 
	private LocalDate dataCompra; 
	private String descri�ao; 
	private String tipo; 
	private int parcela;
	
	
	public DespesaCartao(CartaoCredito cartao, double valor, LocalDate dataCompra, String descri�ao, String tipo, int parcela) {
		super();
		this.cartao = cartao;
		this.valor = valor;
		this.dataCompra = dataCompra;
		this.descri�ao = descri�ao;
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


	public String getDescri�ao() {
		return descri�ao;
	}


	public void setDescri�ao(String descri�ao) {
		this.descri�ao = descri�ao;
	}


	public int getParcela() {
		return parcela;
	}


	public void setParcela(int parcela) {
		this.parcela = parcela;
	}
	
}
