package br.ufrpe.t1800.gui;

import java.util.Scanner;

import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.IFachada;
import br.ufrpe.t1800.negocio.beans.Pessoa;

public class Menu {
	private IFachada wallet = Fachada.getInstance();
	private Scanner entrada = new Scanner(System.in);
	
	public void começo() {
		System.out.println("~~~~~~~~~~~~~Carteira Digital T1800~~~~~~~~~~~~~~~~\n\n");
	}
	
	
	
	public void menuPrincipal() {
		while(true) {
			this.começo(); 
			System.out.println("Menu Princial\n\n");
			System.out.println("1 - Pessoa\n"
					+ "2 - Carteira\n"
					+ "3 - Receita\n"
					+ "4 - Cartao\n"
					+ "0 - Sair\n\n"
					+ "Opção: ");
			int op = entrada.nextInt();
			
			
			switch(op) {
			case 1:
				int muda = 6;
				while(muda != 6) {
					this.começo();
					System.out.println("Menu de Pessoa");
					System.out.println("1 - Cadastrar"
							+ "2 - Atualizar"
							+ "3 - Remover"
							+ "4 - Buscar"
							+ "5 - Listar"
							+ "6 - Sair");
					int opc = entrada.nextInt();
					
					switch(opc) {
					case 1:{
						boolean ok = false; 
						do {
							entrada.nextLine();
							System.out.println("Cadastro\n\n");
							
							System.out.println("Nome: ");
							String nome = entrada.nextLine();
							System.out.println("\nEmail: ");
							String email = entrada.nextLine();
							System.out.println("\nTelefone: ");
							String telefone = entrada.nextLine();
							
							Pessoa p = new Pessoa(nome, email, telefone);
							try {
								wallet.cadastrarPessoa(p);
							} catch (Exception e) {
								// TODO: handle exception
							}
							ok = true;
							System.out.println("Cadastro realizado");
							
							
						} while (ok==false);
					   	break;
					
					}case 2:{
							entrada.nextLine();
							System.out.println("Atualizar dados Pessoais\n\n");
							System.out.println("Infome o nome: ");
							String busca = entrada.nextLine();
							
							Pessoa atualiza = null;
							try {
								atualiza = wallet.buscarPessoa(busca);
							} catch (Exception e) {
								System.out.println(e.getMessage());
								e.printStackTrace();
							}
							if(atualiza != null) {
								System.out.println("Preencha os dados\n\n");
								System.out.println("Nome: ");
								String novoNome = entrada.nextLine();
								System.out.println("Email: ");
								String novoEmail = entrada.nextLine();
								System.out.println("Telefone: ");
								String novoTelefone = entrada.nextLine();
								
								
								
								atualiza.setNome(novoNome);
								atualiza.setEmail(novoEmail);
								atualiza.setTelefone(novoTelefone);
								
								try {
									wallet.atualizarPessoa(atualiza);
								} catch (Exception e) {
									System.out.println(e.getMessage());
									e.printStackTrace();
								}
							}else {
								System.out.println("\nPessoa Invalida");
							}
							break;
							
					}
					case 3:{
							entrada.nextLine();
							System.out.println("Remover Pessoa");
							System.out.println("\nInfome o nome da pesoa: ");
							String busca = entrada.nextLine();
							
							Pessoa apaga = null;
							try {
								apaga = wallet.buscarPessoa(busca);
							} catch (Exception e) {
								// TODO: handle exception
							}
								if(apaga != null) {
									System.out.println("Deseja deletar " + apaga.getNome() +"?\n"
											+ "1 - Sim\n"
											+ "2 - Nao\n");
									int d = entrada.nextInt();
									switch(d) {
									case 1: {
										try {
											wallet.removerPessoa(apaga);
										} catch (Exception e) {
											// TODO: handle exception
										}
										System.out.println("Pessoa removida\n");
									}
									}
										
								}else {
									System.out.println("Pessoa nao existe\n");
								}
						
					}
					break;
						
					
				}
			}
			
			
			
			
			
			
			
			
			
			
		}
	}
	
	}
}
