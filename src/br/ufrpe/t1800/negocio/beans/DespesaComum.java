package br.ufrpe.t1800.negocio.beans;

import java.time.LocalDate;

public class DespesaComum {
	
	private Carteira id;
	private double valor; 
	private LocalDate data;
	private String descri�ao;
	private String tipo; 
	private boolean pago = true;
	
	
	public DespesaComum(Carteira id, double valor, LocalDate data, String descri�ao, String tipo, boolean pago) {
		
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.descri�ao = descri�ao;
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


	public String getDescri�ao() {
		return descri�ao;
	}


	public void setDescri�ao(String descri�ao) {
		this.descri�ao = descri�ao;
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
				+"\t Descri��o: " + this.getDescri�ao()+ "\n"
				+"\t Tipo: " + this.getTipo()+ "\n"
				+"\t Pago: " + this.isPago()+ "\n";
		
		return resultado; 
	}
	
	
	
}
