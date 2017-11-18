package br.ufrpe.t1800.negocio.beans;

public class Carteira {
	
	private Pessoa pessoa;
	private double valor; 
	private String titulo; 
	private String descrišao;
	private static long geraId = 10;
	private String idCarteira;
	
	
	public Carteira(Pessoa pessoa, double valor, String titulo, String descrišao) {
		this.idCarteira = "T"+ geraId + "WALLET";
		geraId++;
		this.pessoa = pessoa;
		this.valor = valor;
		this.titulo = titulo;
		this.descrišao = descrišao;
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


	public String getDescrišao() {
		return descrišao;
	}


	public void setDescrišao(String descrišao) {
		this.descrišao = descrišao;
	}



	public String getIdCarteira() {
		return idCarteira;
	}


	@Override
	public String toString() {
		String resultado = "\t\tDados da Carteira\n"
						+"\t Dono da Carteira: " + this.getPessoa().getNome() + "\n"
						+"\t Titulo: " + this.getTitulo() + "\n"
						+"\t Nome da Carteira: " +this.getDescrišao() + "\n"
						+"\t Id da Carteira: " + this.getIdCarteira()+ "\n"
						+"\t Valor na Carteira: " + this.getValor()+ "\n";
		
		return resultado; 
	}


	

	@Override
	public boolean equals(Object obj) {
		Carteira c = (Carteira) obj;
		if(this.descrišao.equalsIgnoreCase(c.getDescrišao()) && this.idCarteira.equals(c.getIdCarteira())) {
			return true;
		}
		return false; 
		
	}
	
	
}
