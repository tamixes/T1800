package br.ufrpe.t1800.negocio.beans;



public class CartaoCredito {
	
	private Carteira id; 
	private int diaF;
	private int diaP;	
	private String descricao; 
	private double valor; 
	private String bandeira;
	
	
	public CartaoCredito(Carteira id, String descricao, double valor, String bandeira, int diaF, int diaP) {
		
		this.id = id; 
		this.descricao = descricao;
		this.valor = valor;
		this.bandeira = bandeira; 
		this.diaF = diaF;
		this.diaP = diaP;
	}
	
	public CartaoCredito() {
		
	}


	public Carteira getId() {
		return id;
	}


	public void setId(Carteira id) {
		this.id = id;
	}


	public int getDiaF() {
		return diaF;
	}



	public void setDiaF(int diaF) {
		if(diaF <= 30 && diaF >= 1) {
			this.diaF = diaF;
		}else {
			System.out.println("Dia inválido!");
		}
		
	}



	public int getDiaP() {
		return diaP;
	}



	public void setDiaP(int diaP) {
		if(diaF <= 30 && diaF >= 1) {
			this.diaP = diaP;
		}else {
			System.out.println("Dia inválido!");
		}
		
	}



	public String getDescricao() {
		return descricao;
	}


	public void setDescriçao(String descricao) {
		this.descricao = descricao;
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


	public String getBandeira() {
		return bandeira;
	}


	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}



	@Override
	public String toString() {
		
		String resultado = 
							"\t\tDados do Cartão\n"
							+ "\t Cartão: " + this.getDescricao()+ "\n"
							+ "\t Fechamento da Fatura: " + this.getDiaF() + "\n"
							+ "\t Data de Vencimento do Cartão: " + this.getDiaP() + "\n"
							+ "\t Valor: " + this.getValor()+ "\n"
							+ "\t Bandeira: " + this.getBandeira() + "\n";
						
		
		return resultado; 
	}
	
	@Override
	public boolean equals(Object obj) {
		CartaoCredito c = (CartaoCredito) obj; 
		
		 if(this.descricao.equalsIgnoreCase(c.getDescricao()) && this.diaF == c.getDiaF() && this.diaP == c.getDiaP()
				&& this.bandeira.equals(c.getBandeira())) {
			return true;
		}
		return false;
	}
	
}
