package br.ufrpe.t1800.negocio.beans;

import java.time.LocalDate;

public class DespesaCartao {
	
	private CartaoCredito cartao;
	private double valor; 
	private LocalDate dataCompra; 
	private String descriçao; 
	private String tipo; 
	private int numParcelas;
	
	
	public DespesaCartao(CartaoCredito cartao, double valor, LocalDate dataCompra, String descriçao, String tipo, int parcela) {
		
		this.cartao = cartao;
		this.valor = valor;
		this.dataCompra = dataCompra;
		this.descriçao = descriçao;
		this.tipo = tipo; 
		this.numParcelas = parcela;
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
		return numParcelas;
	}


	public void setParcela(int parcela) {
		this.numParcelas = parcela;
	}


	@Override
	public String toString() {
		String resultado = "\t\tDespesa do Cartao\n"
						+"\t Cartão: " + this.getCartao().getDescricao()+ "\n"
						+"\t Valor da Compra: " + this.getValor()+ "\n"
						+"\t Data da Compra: " + this.getDataCompra()+ "\n"
						+"\t Descrição: " + this.getDescriçao()+ "\n"
						+"\t Tipo: " + this.getTipo()+ "\n"
						+"\t Parcelas: " + this.getParcela() + "\n";
		
		return resultado; 
	}


	
	@Override
	public boolean equals(Object obj) {
		DespesaCartao d = (DespesaCartao) obj;
		if(this.dataCompra.equals(d.getDataCompra()) && this.descriçao.equalsIgnoreCase(d.getDescriçao())
				&& this.valor == d.getValor()) {
			return true;
		}
		return false; 
	}
	
	
	
}
