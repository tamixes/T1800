package br.ufrpe.t1800.exceptions;

public class ObjetoJaExisteException extends Exception	{
	public ObjetoJaExisteException() {
		super("Já existe no sistema!");
	}
}
