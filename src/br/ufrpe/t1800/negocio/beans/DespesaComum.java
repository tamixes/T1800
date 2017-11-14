package br.ufrpe.t1800.negocio.beans;

import java.time.LocalDate;

public class DespesaComum {
	private double valor; 
	private LocalDate data;
	private String descriçao;
	private String tipo; 
	private boolean pago = true;
	
	
	public DespesaComum(double valor, LocalDate data, String descriçao, String tipo, boolean pago) {
		super();
		this.valor = valor;
		this.data = data;
		this.descriçao = descriçao;
		this.tipo = tipo;
		this.pago = pago;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}


	public String getDescriçao() {
		return descriçao;
	}


	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public boolean isPago() {
		return pago;
	}


	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
	
}
