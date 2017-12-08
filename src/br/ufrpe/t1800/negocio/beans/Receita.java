package br.ufrpe.t1800.negocio.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receita {
	
	private Carteira id; 
	private double valor;
	private Date data;
	private String descricao;
	private String categoria; 
	private boolean isPago = true;
	
	
	public Receita(Carteira id, double valor, Date data, String descricao, String categoria, boolean pago) {
		
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.descricao = descricao;
		this.categoria = categoria;
		this.isPago = pago;
	}
	public Receita() {
		
	}

	public Carteira getId() {
		return id;
	}


	public void setId(Carteira id) {
		this.id = id;
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public boolean isPago() {
		return isPago;
	}


	public void setPago(boolean pago) {
		this.isPago = pago;
	} 
	
	public String toString() {
		String resultado = "\t\tDados da Receita\n"
					+"\tCarteira: " + this.getId().getIdCarteira()+ "\n"
					+"\tValor: " + this.getValor() + "\n"
					+"\tData: " + this.getData()+ "\n"
					+"\tDescrição: " + this.getDescricao() +"\n"
					+"\tCategoria: " + this.getCategoria()+ "\n"
					+"\tPago: " + this.isPago()+ "\n";
		
		return resultado; 
	//TODO colocar para nao imprir o valor boolean mas sim (sim ou nao)
	
	}
	
	public void formataData() throws ParseException {
		String exemplo = "10/12/2000";
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date =(Date)formatter.parse(exemplo);
	}
	
	public boolean equals(Object obj) {
		Receita r = (Receita) obj;
		
		if(this.descricao.equalsIgnoreCase(descricao) && this.valor == r.getValor() && this.data.equals(r.getData())) {
			return true;
		}
		return false; 
	}
	
}
