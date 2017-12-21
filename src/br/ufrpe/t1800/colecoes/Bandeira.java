package br.ufrpe.t1800.colecoes;

public enum Bandeira {
	
	MASTER("Master"),
	VISA("Visa"),
	HIPERCARD("Hiper"),
	AMERICAN_EXPRESS("American Express"),
	BNDES("Bndes"),
	DINNERS("Dinners"),
	OUTROS("Outros");
	
	public String bandeira;

	
	
	private Bandeira(String bandeira) {
		this.bandeira = bandeira;
	}



	public String getBandeira() {
		return bandeira;
	}


	
	
}
