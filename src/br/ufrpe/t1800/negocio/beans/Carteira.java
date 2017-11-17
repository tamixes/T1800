package br.ufrpe.t1800.negocio.beans;

public class Carteira {
	
	private Pessoa pessoa;
	private double valor; 
	private String titulo; 
	private String descri�ao;
	private static long geraId = 01;
	private String idCarteira;
	
	
	public Carteira(Pessoa pessoa, double valor, String titulo, String descri�ao) {
		this.idCarteira = "Carteira" + geraId;
		geraId++;
		this.pessoa = pessoa;
		this.valor = valor;
		this.titulo = titulo;
		this.descri�ao = descri�ao;
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


	public String getDescri�ao() {
		return descri�ao;
	}


	public void setDescri�ao(String descri�ao) {
		this.descri�ao = descri�ao;
	}



	public String getIdCarteira() {
		return idCarteira;
	}


	@Override
	public String toString() {
		String resultado = "\t\tDados da Carteira\n"
						+"\t Dono da Carteira: " + this.getPessoa().getNome() + "\n"
						+"\t Nome da Carteira: " +this.getDescri�ao() + "\n"
						+"\t Id da Carteira: " + this.getIdCarteira()+ "\n"
						+"\t Valor na Carteira: " + this.getValor()+ "\n";
		
		return resultado; 
	}
	
	
}
