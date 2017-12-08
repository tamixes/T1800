package br.ufrpe.t1800.negocio.beans;

import java.util.Date;

public class DespesaComum {
	
	private Carteira id;
	private double valor; 
	private Date data;
	private String descricao;
	private String tipo; 
	private boolean isPago = true;
	
	
	public DespesaComum(Carteira id, double valor, Date data, String descriçao, String tipo, boolean pago) {
		
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.descricao = descriçao;
		this.tipo = tipo;
		this.isPago = pago;
	}
	
	public DespesaComum() {
		
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getDescriçao() {
		return descricao;
	}


	public void setDescriçao(String descriçao) {
		this.descricao = descriçao;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public boolean isPago() {
		return isPago;
	}


	public void setPago(boolean pago) {
		this.isPago = pago;
	}


	public Carteira getId() {
		return id;
	}


	public void setId(Carteira id) {
		this.id = id;
	}


	@Override
	public String toString() {
		String resultado = "\t\tDespesa Comum\n"
				+"\t Carteira: " + this.getId().getIdCarteira()+ "\n"
				+"\t Valor da Compra: " + this.getValor()+ "\n"
				+"\t Data da Compra: " + this.getData()+ "\n"
				+"\t Descrição: " + this.getDescriçao()+ "\n"
				+"\t Tipo: " + this.getTipo()+ "\n"
				+"\t Pago: " + this.isPago()+ "\n";
		
		return resultado; 
		
		//TODO colocar para nao imprimir o valor boolean (sim ou nao)
	}
	
	@Override
	public boolean equals(Object obj) {
		DespesaComum d = (DespesaComum) obj;
		if(this.data.equals(d.getData()) && this.descricao.equalsIgnoreCase(d.getDescriçao())
				&& this.valor == d.getValor()) {
			return true;
		}
		return false; 
	}
	
}
