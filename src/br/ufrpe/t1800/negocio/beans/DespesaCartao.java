package br.ufrpe.t1800.negocio.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class DespesaCartao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8869698266227495341L;
	private CartaoCredito cartao;
	private double valor; 
	private LocalDate dataCompra; 
	private String descricao; 
	private String tipo; 
	private int numParcelas;
	
	
	public DespesaCartao(CartaoCredito cartao, double valor, LocalDate data, String descricao, String tipo, int parcela) {
		
		this.cartao = cartao;
		this.valor = valor;
		this.dataCompra = data;
		this.descricao = descricao;
		this.tipo = tipo; 
		this.numParcelas = parcela;
	}
	
	public DespesaCartao() {
		
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
		if(valor >= 0.0) {
			this.valor = valor;
		}else {
			System.out.println("Valor inv�lido!");
		}
		
	}


	public LocalDate getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getParcela() {
		return numParcelas;
	}


	public void setParcela(int parcela) {
		if(valor > 0) {
			this.numParcelas = parcela;
		}else {
			System.out.println("Valor inv�lido!");
		}
		
	}


	@Override
	public String toString() {
		String resultado = "\t\tDespesa do Cartao\n"
						+"\t Cart�o: " + this.getCartao().getDescricao()+ "\n"
						+"\t Valor da Compra: " + this.getValor()+ "\n"
						+"\t Data da Compra: " + this.getDataCompra()+ "\n"
						+"\t Descri��o: " + this.getDescricao()+ "\n"
						+"\t Tipo: " + this.getTipo()+ "\n"
						+"\t Parcelas: " + this.getParcela() + "\n";
		
		return resultado; 
	}


	
	@Override
	public boolean equals(Object obj) {
		DespesaCartao d = (DespesaCartao) obj;
		if(d != null && this.dataCompra.equals(d.getDataCompra()) && this.descricao.equalsIgnoreCase(d.getDescricao())
				&& this.valor == d.getValor()) {
			return true;
		}
		return false; 
	}
	
	
	
}
