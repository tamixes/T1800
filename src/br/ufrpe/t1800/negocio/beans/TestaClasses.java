package br.ufrpe.t1800.negocio.beans;

import java.time.LocalDate;



public class TestaClasses {

	public static void main(String[] args) {
		
		LocalDate dataC = LocalDate.now();
				
		Pessoa a = new Pessoa("Tamires", "tamizs@hotmail.com", "81 98940-9117");
		Carteira b = new Carteira(a, 345, "Caixa Economica", "Salario");
		CartaoCredito c = new CartaoCredito(b, "Nubank", 1000, "MasterCard", 8, 15);
		DespesaCartao d = new DespesaCartao(c, 20, dataC, "Bolo", "Comida", 1);
		DespesaComum e = new DespesaComum(b, 232, dataC, "Mercado", "Alimentos", true);
		Receita f = new Receita(b, 300, dataC, "Semana", "Bolsa", false);
		
		
		/*System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);*/
		
		
		Pessoa a1 = new Pessoa("Diego", "diego123@gmail.com", "81 2102-1221");
		Carteira b1 = new Carteira(a1, 3000, "Banco do Brasil", "Pensão");
		
		System.out.println(a1);
		System.out.println(b1);

	}

}
