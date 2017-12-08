package br.ufrpe.t1800.negocio.beans;

public class Carteira {
	
	private Pessoa pessoa;
	private double valor; 
	private String titulo; 
	private String descricao;
	private static long geraId = 10;
	private String idCarteira;
	
	
	public Carteira(Pessoa pessoa, double valor, String titulo, String descriçao) {
		this.idCarteira = "T"+ geraId + "WALLET";
		geraId++;
		this.pessoa = pessoa;
		this.valor = valor;
		this.titulo = titulo;
		this.descricao = descriçao;
	}

	public Carteira() {
		
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
		if(valor >= 0.0) {
			this.valor = valor;
		}else {
			System.out.println("Valor inválido!");
		}
		
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescriçao() {
		return descricao;
	}


	public void setDescriçao(String descriçao) {
		this.descricao = descriçao;
	}



	public String getIdCarteira() {
		return idCarteira;
	}


	@Override
	public String toString() {
		String resultado = "\t\tDados da Carteira\n" 
						+"\t Titulo: " + this.getTitulo() + "\n"
						+"\t Nome da Carteira: " +this.getDescriçao() + "\n"
						+"\t Id da Carteira: " + this.getIdCarteira()+ "\n"
						+"\t Valor na Carteira: " + this.getValor()+ "\n";
		
		return resultado; 
	}


	

	@Override
	public boolean equals(Object obj) {
		Carteira c = (Carteira) obj;
		if(this.descricao.equalsIgnoreCase(c.getDescriçao()) && this.idCarteira.equals(c.getIdCarteira())) {
			return true;
		}
		return false; 
		
	}
	
	
}
