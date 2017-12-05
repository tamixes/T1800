package br.ufrpe.t1800.gui;

import java.time.LocalDate;
import java.util.Scanner;

import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.IFachada;
import br.ufrpe.t1800.negocio.beans.CartaoCredito;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.Pessoa;
import br.ufrpe.t1800.negocio.beans.Receita;

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
					+ "Opção: \n");
			
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
						
						case 4:{
							entrada.nextLine(); 
							System.out.println("Busca de Pessoa");
							System.out.println("Nome da pessoa: ");
							String busca = entrada.nextLine();
							
							Pessoa encontra = null;
							try {
								encontra = wallet.buscarPessoa(busca);
							} catch (Exception e) {
								// TODO: handle exception
							}
							if(encontra != null) {
								System.out.println("Dados: " + encontra.getNome());
								System.out.println(encontra);
							}else {
								System.out.println("Pessoa nao existe!!");
							}
							
						}
						break;	
						
						case 5:{
							entrada.nextLine();
							System.out.println("Lista de Pessoas");
						}
						break;
						
						case 6:{
							System.out.println("Saindo...");
							entrada.nextLine();
							muda = 6;
							break;
					}
				}
			}
				break;
			
				case 2:
					int muda2 = 0;
					while(muda2 != 6) {
						this.começo();
						System.out.println("Menu de Carteira");
						System.out.println("1 - Cadastrar\n"
								+ "2 - Atualizar\n"
								+ "3 - Remover\n"
								+ "4 - Buscar\n"
								+ "5 - Listar\n"
								+ "6 - Sair\n");
						int o = entrada.nextInt();
						
						switch(o) {
							case 1:{
							boolean ok = false;
							do {
								entrada.nextLine();
								System.out.println("Cadastro de Carteira\n\n");
								System.out.println("Para cadastrar uma carteira é necessário ter cadastrado uma pessoa\n");
								
								
								Pessoa pessoaBusca = null;
					
								do {
									
									System.out.println("\nDigite o nome da pessoa: ");
									String busca = entrada.nextLine();
									
									try {
										pessoaBusca = wallet.buscarPessoa(busca);
									} catch (Exception e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
									
								} while (pessoaBusca == null);
								
								entrada.nextLine(); 
								
								System.out.println("\nDigite o nome da Carteira: ");
								String descricao = entrada.nextLine();
								System.out.println("\nDigite o titulo da Carteira: ");
								String titulo = entrada.nextLine();
								System.out.println("\nDigite o valor da Carteira: ");
								double valor = entrada.nextDouble();
								entrada.nextLine();
								
								Carteira carteira = new Carteira(pessoaBusca, valor, titulo, descricao);
								
								try {
									wallet.cadastrarCarteira(carteira);
									System.out.println("\nCarteira Cadastrada!!");
									ok = true;
									entrada.nextLine();
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
								
													
								
								
							} while (ok==false);
							
							break;
							}
							
							case 2:{
									entrada.nextLine();
									System.out.println("\nAtualizar Carteira");
									
									System.out.println("\nInforme o ID da carteira que deseja atualizar");
									String busca = entrada.nextLine();
									
									Carteira buscada = null;
						
									try {
										buscada = wallet.buscarCarteira(busca);
										
										
										
										System.out.println("Informe os novos dados: \n\n");
										
										System.out.println("\nDescriçao: ");
										String novaDesc = entrada.nextLine();
										System.out.println("\nTitulo: ");
										String novoTit = entrada.nextLine();
										System.out.println("\nValor");
										double  novoValor = entrada.nextDouble();
										entrada.nextLine();
										
									
										buscada.setDescriçao(novaDesc);
										buscada.setTitulo(novoTit);
										buscada.setValor(novoValor);
										
										try {
											wallet.atualizarCarteira(buscada);
											System.out.println("Carteira atualizada!");
											entrada.nextLine();
											
										} catch (Exception e) {
											System.out.println(e.getMessage());
											entrada.nextLine();
										}
									} catch (Exception e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
									break;	
							}
							case 3:{
								entrada.nextLine();
								System.out.println("\nRemover Carteira\n\n");
								System.out.println("Digite o id da carteira a ser removida\n");
								String id = entrada.nextLine();
								
								Carteira carteira = null;
								try {
									carteira = wallet.buscarCarteira(id);
									
								} catch (Exception e) {
									System.out.println(e.getMessage());
									entrada.nextLine();
								}
								if(carteira != null) {
									System.out.println("Você realmente quer remover esta carteira" + carteira.getDescriçao() +"?\n"
											+ "1 - sim\n"
											+ "2 - nao\n"
											+ "Digite: \n");
									int esc = entrada.nextInt();
									switch(esc) {
									case 1:
										try {
											wallet.removerCarteira(carteira);
										} catch (Exception e) {
											System.out.println(e.getMessage());
											e.printStackTrace();
										}
										System.out.println("\nCarteira Removida!");
									}	
								}else {
									System.out.println("\nCarteira nao existe!");
								}
								
						}
							break;
							case 4: {
								System.out.println("\nBuscar Carteira\n\n");
								System.out.println("Digite o ID da Carteira a ser buscada");
								String id = entrada.nextLine();
								
								Carteira busca = null;
								try {
									busca = wallet.buscarCarteira(id);
								} catch (Exception e) {
									System.out.println(e.getMessage());
									e.printStackTrace();
								}
								if(busca != null) {
									System.out.println("\nDados da Carteira" + busca.getDescriçao() +"\n");
									System.out.println(busca);
								}else {
									System.out.println("\nCarteira nao existe!");
								}
								break;
							}
							case 5:{
								break;
							}
							
							case 6:{
								System.out.println("Voltando ao menu...");
								entrada.nextLine();
								muda2 = 6;
								break;
						}
					}	
				}
				
			break;
			
				case 3:
					int muda3 = 0;
					while(muda3 != 6) {
						this.começo();
						System.out.println("\n\nMenu de Receita");
						System.out.println("1 - Cadastrar Receita\n"
								+ "2 - Atualizar Receita\n"
								+ "3 - Remover Receita\n"
								+ "4 - Buscar Receita\n"
								+ "5 - Listar Receita\n"
								+ "6 - Sair\n");
							int esc = entrada.nextInt();
							switch(esc) {
							
								case 1:{
									boolean ok = false; 
									do {
																
										
										entrada.nextLine();
										System.out.println("\nCadastro de Receita");
										System.out.println("\nPara Cadastrar uma receita é necessário ter uma carteira\n");
										
										
										Carteira busca = null;
										do {
											System.out.println("Digite o ID da carteira: \n");
											String id = entrada.nextLine();
											try {
												busca = wallet.buscarCarteira(id);
												
											} catch (Exception e) {
												// TODO: handle exception
											}
										} while (busca == null);
										
					
										System.out.println("Descrição: \n");
										String descricao = entrada.nextLine();
										System.out.println("Categoria: \n");
										String categoria = entrada.nextLine();
										System.out.println("Valor: \n");
										double valor = entrada.nextDouble();
										System.out.println("O valor ja foi pago? sim-nao\n");
										String pago = entrada.nextLine();
										boolean isPago = false;
										if(pago.equalsIgnoreCase("sim")) {
											isPago = true;
										}else {
											System.out.println("Invalido!");
										}
										System.out.println("Data ano/mes/dia (digite sem espaços apenas os numeros): \n");
										int dia = entrada.nextInt();
										int mes = entrada.nextInt();
										int ano = entrada.nextInt();
										entrada.nextLine();
										LocalDate data = LocalDate.of(ano, mes, dia);
										
										Receita receita = new Receita(busca, valor, data, descricao, categoria, isPago);
										try {
											wallet.cadastrarReceita(receita);
											System.out.println("Receita cadastrada!\n");
											ok = true;
										} catch (Exception e) {
											// TODO: handle exception
										}
									
									} while (ok==false);
									
									break; 
								}
								case 2:{
									entrada.nextLine();
									System.out.println("\nAtualizar Receita\n");
									System.out.println("Informe a descriçao da receita que deseja atualizar: \n");
									String busca = entrada.nextLine();
									
									Receita atualiza = null;
									
									try {
										atualiza = wallet.buscarReceita(busca);
										
										System.out.println("Digite os novos dados: \n");
										System.out.println("Descriçao: \n");
										String novaDesc = entrada.nextLine();
										System.out.println("Categoria: \n");
										String novaCateg = entrada.nextLine();
										System.out.println("Valor: \n");
										int novoValor = entrada.nextInt();
										System.out.println("Data dia/mes/ano: \n");
										String text = entrada.nextLine();
										LocalDate novaData = LocalDate.parse(text);
										System.out.println("O valor está pago? sim-nao\n");
										String novoPago = entrada.nextLine();
										boolean novoIsPago = false;
										if(novoPago.equalsIgnoreCase("sim")) {
											novoIsPago = true;
										}else {
											System.out.println("Invalido\n");
										}
										
										atualiza.setCategoria(novaCateg);
										atualiza.setData(novaData);
										atualiza.setDescricao(novaDesc);
										atualiza.setPago(novoIsPago);
										atualiza.setValor(novoValor);
										
										try {
											wallet.atualizarReceita(atualiza);
											System.out.println("Receita atualizada!\n");
											entrada.nextLine();
										} catch (Exception e) {
											System.out.println(e.getMessage());
											entrada.nextLine();
										}
									} catch (Exception e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
									break;
											
								}
								case 3:{
									entrada.nextLine();
									System.out.println("\nRemover Receita\n\n");
									System.out.println("Informe a descrição da receita a ser removida");
									String busca = entrada.nextLine();
									
									Receita remover = null;
									try {
										remover = wallet.buscarReceita(busca);
										System.out.println("Você realmente quer remover  " + remover.getDescricao()+ "\n"
												+ "1 - sim\n"
												+ "2 - nao\n"
												+ "Opção: \n");
										int opc = entrada.nextInt();
										switch(opc) {
										case 1:
											try {
												wallet.removerReceita(remover);
												System.out.println("Removido!\n");
												entrada.nextLine();
												
											} catch (Exception e) {
												// TODO: handle exception
											}
										}
									} catch (Exception e) {
										// TODO: handle exception
									}
									break; 
								}
								case 4:{
									entrada.nextLine();
									System.out.println("\nBuscar receita\n\n");
									System.out.println("Digite a descrição da receita a ser buscada: \n");
									String busca = entrada.nextLine();
									
									Receita buscada = null;
									try {
										buscada = wallet.buscarReceita(busca);
										System.out.println("Dados da receita " + buscada.getDescricao() + "\n");
										System.out.println(buscada);
										
									} catch (Exception e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
									break;
								}
								case 5: {
									break;
								}
								case 6:{
									System.out.println("Saindo...");
									entrada.nextLine();
									muda3 = 6;
							}
						}
					}
					break;
					
				case 4:
					int muda4 = 0;
					while(muda4 != 6) {
						this.começo(); 
						System.out.println("\n\nMenu de Cartao");
						System.out.println("1 - Cadastrar Cartao\n"
								+ "2 - Atualizar Cartao\n"
								+ "3 - Remover Cartao\n"
								+ "4 - Buscar Cartao\n"
								+ "5 - Listar Cartao\n"
								+ "6 - Sair\n");
						int escolhe = entrada.nextInt();
						switch(escolhe) {
						case 1:{
														
							boolean ok = false;
							do {
								entrada.nextLine();
								System.out.println("\nPara cadastrar um cartao é necessario uma carteira");
								
								Carteira buscada = null;
								do {
									System.out.println("\nInforme o ID da carteira");
									String idBuscado = entrada.nextLine();
									
									try {
										buscada = wallet.buscarCarteira(idBuscado);
									} catch (Exception e) {
										// TODO: handle exception
									}
								} while (buscada == null);		
								
								entrada.nextLine();
								
								System.out.println("\nDescrição: ");
								String descricao = entrada.nextLine();
								System.out.println("\nBandeira: ");
								String bandeira = entrada.nextLine();
								System.out.println("\nDia de fechamento: ");
								int fechamento = entrada.nextInt();
								entrada.nextLine();
								System.out.println("\nDia de pagamento: ");
								int pagamento = entrada.nextInt();
								entrada.nextLine();
								System.out.println("\nValor: ");
								double valor = entrada.nextDouble();
								entrada.nextLine();
								
								CartaoCredito cartao = new CartaoCredito(buscada, descricao, valor, bandeira, fechamento, pagamento);
								
								try {
									wallet.cadastrarCartao(cartao);
									System.out.println("\nCartao Cadastrado!\n");
									ok = true;
									
								} catch (Exception e) {
									// TODO: handle exception
								}
							} while (ok == false);
							
							break;
						}
						
						case 2:{
							entrada.nextLine();
							System.out.println("\nAtualizar Cartão \n");
							System.out.println("\nInforme a descrição do cartao: \n");
							String busca = entrada.nextLine();
							
							CartaoCredito buscado = null;
							
							try {
								buscado = wallet.buscarCartao(busca);
								
								System.out.println("\nInforme os novos dados para o cartao: \n");
								
								System.out.println("\nDescrição: ");
								String nvDescricao = entrada.nextLine();
								System.out.println("\nBandeira: ");
								String nvBandeira = entrada.nextLine();
								System.out.println("\nDia de fechamento: ");
								int nvFechamento = entrada.nextInt();
								entrada.nextLine();
								System.out.println("\nDia de pagamento: ");
								int nvPagamento = entrada.nextInt();
								entrada.nextLine();
								System.out.println("\nValor: ");
								double nvValor = entrada.nextDouble();
								entrada.nextLine();
								
								buscado.setDescriçao(nvDescricao);
								buscado.setBandeira(nvBandeira);
								buscado.setDiaF(nvFechamento);
								buscado.setDiaP(nvPagamento);
								buscado.setValor(nvValor);
								
								try {
									wallet.atualizarCartao(buscado);
									System.out.println("\n\nCartao atualizado!");
									entrada.nextLine();
									
								} catch (Exception e) {
									// TODO: handle exception
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
							
							break;
						}
						
						case 3:{
							entrada.nextLine();
							System.out.println("\nRemover Cartao");
							System.out.println("\nInforme a descrição do cartao que deseja remover");
							String busca = entrada.nextLine();
							
							CartaoCredito deleta = null;
							
							try {
								deleta = wallet.buscarCartao(busca);
								
							} catch (Exception e) {
								// TODO: handle exception
							}
							if(deleta != null) {
								System.out.println("\nConfirme se deseja deletar o cartao"
										+ "1 - sim\n"
										+ "2 - nao\n"
										+ "Opção: ");
								int escolha = entrada.nextInt();
								switch(escolha) {
								case 1:
									try {
										wallet.removerCartao(deleta);
										
									} catch (Exception e) {
										// TODO: handle exception
									}
									System.out.println("\nCartao Removido!\n");
								}
								
							}else {
								System.out.println("Cartao nao existe!\n");
							}
							
						}
						break;
						case 4: {
							entrada.nextLine();
							System.out.println("\nBuscar Cartao\n");
							System.out.println("Informe a descrição do cartao que deseja buscar: \n");
							String busca = entrada.nextLine();
							
							CartaoCredito buscado = null;
							
							try {
								buscado = wallet.buscarCartao(busca);
								
							} catch (Exception e) {
								// TODO: handle exception
							}
							
							if (buscado != null) {
								System.out.println("\nDados do cartao " + buscado.getDescricao());
								System.out.println(buscado);
								
							} else {
								System.out.println("Cartao nao existe!\n");
							}
						break;
						}
						
						case 5:{
							break;
						}
						case 6:{
							System.out.println("Voltando ao menu...");
							entrada.nextLine();
							muda4 = 6;
							break;
						}
					}
				}
				break;	
			
			
			
		}
	}
	
	}
}
