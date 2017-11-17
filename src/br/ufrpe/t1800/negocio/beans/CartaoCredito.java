package br.ufrpe.t1800.negocio.beans;



public class CartaoCredito {
	
	private Carteira id; 
	private int diaF;
	private int diaP;	
	private String descriçao; 
	private double valor; 
	private String bandeira;
	
	
	public CartaoCredito(Carteira id, String descriçao, double valor, String bandeira, int diaF, int diaP) {
		
		this.id = id; 
		this.descriçao = descriçao;
		this.valor = valor;
		this.bandeira = bandeira; 
		this.diaF = diaF;
		this.diaP = diaP;
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
		this.diaF = diaF;
	}



	public int getDiaP() {
		return diaP;
	}



	public void setDiaP(int diaP) {
		this.diaP = diaP;
	}



	public String getDescriçao() {
		return descriçao;
	}


	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
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
							+ "\t Cartão: " + this.getDescriçao()+ "\n"
							+ "\t Fechamento da Fatura: " + this.getDiaF() + "\n"
							+ "\t Data de Vencimento do Cartão: " + this.getDiaP() + "\n"
							+ "\t Valor: " + this.getValor()+ "\n"
							+ "\t Bandeira: " + this.getBandeira() + "\n";
						
		
		return resultado; 
	}
	
	
	
}
