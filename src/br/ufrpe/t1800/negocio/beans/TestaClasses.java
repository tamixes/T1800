package br.ufrpe.t1800.negocio.beans;

import java.time.LocalDate;

import javafx.util.converter.LocalDateStringConverter;

public class TestaClasses {

	public static void main(String[] args) {
		
		LocalDate dataC = LocalDate.now();
				
		Pessoa a = new Pessoa("Tamires", "tamizs@hotmail.com", "81 98940-9117");
		Carteira b = new Carteira(a, 345, "Caixa Economica", "Salario");
		CartaoCredito c = new CartaoCredito(b, "Nubank", 1000, "MasterCard", 8, 15);
		DespesaCartao d = new DespesaCartao(c, 20, dataC, "Bolo", "Comida", 1);
		DespesaComum e = new DespesaComum(b, 232, dataC, "Mercado", "Alimentos", true);
		
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		

	}

}
