package br.ufrpe.t1800.exceptions;

public class ErroAoAtualizarException extends Exception{
	public ErroAoAtualizarException() {
		super("Não foi possível atualizar!");
	}
}
