package br.ufrpe.t1800.gui;



import java.time.LocalDate;
import java.util.Scanner;

import br.ufrpe.t1800.exceptions.ErroAoAtualizarException;
import br.ufrpe.t1800.exceptions.ErroAoRemoverException;
import br.ufrpe.t1800.exceptions.ObjetoJaExisteException;
import br.ufrpe.t1800.exceptions.ObjetoNaoExisteException;
import br.ufrpe.t1800.negocio.Fachada;
import br.ufrpe.t1800.negocio.IFachada;
import br.ufrpe.t1800.negocio.beans.CartaoCredito;
import br.ufrpe.t1800.negocio.beans.Carteira;
import br.ufrpe.t1800.negocio.beans.DespesaCartao;
import br.ufrpe.t1800.negocio.beans.DespesaComum;
import br.ufrpe.t1800.negocio.beans.Pessoa;
import br.ufrpe.t1800.negocio.beans.Receita;

public class Menu {
	private IFachada wallet = Fachada.getInstance();
	private Scanner entrada = new Scanner(System.in);
	
	public void começo() {
		System.out.println("~~~~~~~~~~~~~Carteira Digital T1800~~~~~~~~~~~~~~~~\n\n");
	}
	
	
	
	public void menuPrincipal() throws Exception {
		while(true) {
			this.começo(); 
			System.out.println("---------Menu Princial----------\n\n");
			System.out.println("1 - Pessoa\n"
					+ "2 - Carteira\n"
					+ "3 - Receita\n"
					+ "4 - Cartao\n"
					+ "5 - Despesa\n"
					+ "0 - Sair\n\n"
					+ "Opção: \n");
			
			int op = entrada.nextInt();
			
			
			switch(op) {
					case 1:
					int muda = 0;
					while(muda != 6) {
						this.começo();
						System.out.println("Menu de Pessoa");
						System.out.println("1 - Cadastrar\n"
								+ "2 - Atualizar\n"
								+ "3 - Remover\n"
								+ "4 - Buscar\n"
								+ "5 - Listar\n"
								+ "6 - Sair\n");
						int opc = entrada.nextInt();
						
						switch(opc) {
						case 1:{
							
							
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
									} catch (ObjetoJaExisteException e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
								
								
								System.out.println("Cadastro realizado");
								
								
							
						   	break;
						
						}case 2:{
								entrada.nextLine();
								System.out.println("Atualizar dados Pessoais\n\n");
								System.out.println("Infome o nome da pessoa que deseja alterar: \n");
								String busca = entrada.nextLine();
								
								Pessoa atualiza = null;
								try {
									atualiza = wallet.buscarPessoa(busca);
									System.out.println("Informe os novos dados: \n");
									System.out.println("Nome: \n");
									String nvNome = entrada.nextLine();
									System.out.println("Telefone: \n");
									String nvTelefone = entrada.nextLine();
									System.out.println("Email: \n");
									String nvEmail = entrada.nextLine();
									
									atualiza.setNome(nvNome);
									atualiza.setEmail(nvEmail);
									atualiza.setTelefone(nvTelefone);
									
									try {
										wallet.atualizarPessoa(atualiza);
										System.out.println("Atualizado com sucesso!");
									} catch (Exception e) {
										// TODO: handle exception
									}
									
								} catch (ObjetoNaoExisteException e) {
									System.out.println(e.getMessage());
									entrada.nextLine();
								}
									
								
									
								
								break;
								
						}
						case 3:{
								entrada.nextLine();
								System.out.println("Remover Pessoa");
								System.out.println("\nInfome o nome da pessoa: \n");
								String busca = entrada.nextLine();
								
								Pessoa apaga = null;
								
									try {
										apaga = wallet.buscarPessoa(busca);
										
										System.out.println("Deseja deletar " + apaga.getNome() +"?\n"
												+ "1 - Sim\n"
												+ "2 - Nao\n");
										int d = entrada.nextInt();
										switch(d) {
										case 1: {
											try {
												wallet.removerPessoa(apaga);
												System.out.println("Pessoa removida\n");
												entrada.nextLine();
											} catch (ErroAoRemoverException e) {
												System.out.println(e.getMessage());
												entrada.nextLine();											}
												
										}
									}
								}	catch (ObjetoNaoExisteException e) {
									System.out.println(e.getMessage());
									entrada.nextLine();		
								}
							}
						break;
						
						
						case 4:{
							entrada.nextLine(); 
							System.out.println("Buscar Pessoa");
							System.out.println("Nome da pessoa: ");
							String busca = entrada.nextLine();
							
							Pessoa encontra = null;
							
							try {
								encontra = wallet.buscarPessoa(busca);
								System.out.println("Dados: " + encontra.getNome());
								System.out.println(encontra);
								
							} catch (ObjetoNaoExisteException e) {
								System.out.println(e.getMessage());
								entrada.nextLine();
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
									
									} catch (ObjetoNaoExisteException e) {
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
									System.out.println("\nCarteira cadastrada id: " + carteira.getIdCarteira());
									ok = true;
									entrada.nextLine();
								} catch (ObjetoJaExisteException e) {
									System.out.println(e.getMessage());
									entrada.nextLine();
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
										} catch (ErroAoAtualizarException e) {
											System.out.println(e.getMessage());
											entrada.nextLine();
										}
										
									} catch (ObjetoNaoExisteException e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
		
										
									}
									break;	
							
							case 3:{
								entrada.nextLine();
								System.out.println("\nRemover Carteira\n\n");
								System.out.println("Digite o id da carteira a ser removida\n");
								String id = entrada.nextLine();
								
								Carteira carteira = null;
								
									
								try {
									carteira = wallet.buscarCarteira(id);
									
									System.out.println("Você realmente quer remover esta carteira" + carteira.getDescriçao() +"?\n"
											+ "1 - sim\n"
											+ "2 - nao\n"
											+ "Digite: \n");
									int esc = entrada.nextInt();
									
									switch(esc) {
										case 1:
											/*try {
												wallet.removerCarteira(carteira);
												System.out.println("\nCarteira Removida!");
												entrada.nextLine();
											} catch (ErroAoRemoverException e) {
												System.out.println(e.getMessage());
												entrada.nextLine();*/
									}
								}
									
								catch (ObjetoNaoExisteException e) {
									System.out.println(e.getMessage());
									entrada.nextLine();
								}
							break;		
						}
							
							case 4: {
								System.out.println("\nBuscar Carteira\n\n");
								System.out.println("Digite o ID da Carteira a ser buscada");
								String id = entrada.nextLine();
								
								Carteira busca = null;
							
									try {
										busca = wallet.buscarCarteira(id);
									System.out.println("\nDados da Carteira" + busca.getDescriçao() +"\n");
									System.out.println(busca);
									} catch (ObjetoNaoExisteException e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
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
												
											} catch (ObjetoNaoExisteException e) {
												System.out.println(e.getMessage());
												entrada.nextLine();
											}	
											
																						
											
										} while (busca == null);
										
					
										System.out.println("Descrição: \n");
										String descricao = entrada.nextLine();
										System.out.println("Categoria: \n");
										String categoria = entrada.nextLine();
										System.out.println("Valor: \n");
										double valor = entrada.nextDouble();
										System.out.println("O valor ja foi pago? sim-nao\n");
										boolean isPago = entrada.nextBoolean();
										
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
											} catch (ObjetoJaExisteException e) {
												System.out.println(e.getMessage());
												entrada.nextLine();
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
											} catch (ErroAoAtualizarException e) {
												// TODO: handle exception
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
													} catch (ErroAoRemoverException e) {
														System.out.println(e.getMessage());
														e.printStackTrace();
													}
													
										
									}
									} catch (ObjetoNaoExisteException e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
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
									} catch (ObjetoNaoExisteException e) {
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
										
									} catch (ObjetoNaoExisteException e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
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
								} catch (ObjetoJaExisteException e) {
									System.out.println(e.getMessage());
									entrada.nextLine();
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
								} catch (ErroAoAtualizarException e) {
									System.out.println(e.getMessage());
									entrada.nextLine();
								}
								} catch (ObjetoNaoExisteException e) {
									System.out.println(e.getMessage());
									entrada.nextLine();
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
									
									if(deleta != null) {
								System.out.println("\nConfirme se deseja deletar " + deleta.getDescricao()
										+ "1 - sim\n"
										+ "2 - nao\n"
										+ "Opção: ");
								int escolha = entrada.nextInt();
								switch(escolha) {
								case 1:
									
										try {
											wallet.removerCartao(deleta);
											
										} catch (ErroAoRemoverException e) {
											System.out.println(e.getMessage());
											entrada.nextLine();
										}
					
									System.out.println("\nCartao Removido!\n");
								}
								
							}else {
								System.out.println("Cartao nao existe!\n");
							}
								} catch (ObjetoNaoExisteException e) {
									System.out.println(e.getMessage());
									entrada.nextLine();
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
									System.out.println("\nDados do cartao " + buscado.getDescricao());
									System.out.println(buscado);
								} catch (ObjetoNaoExisteException e) {
									System.out.println(e.getMessage());
									entrada.nextLine();
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
				
				case 5:
					int muda5 = 0;
					while(muda5 != 3) {
						this.começo();
						System.out.println("\n\nMenu de Despesa\n");
						System.out.println("1 - Despesa Comum\n"
								+ "2 - Despesa Cartao\n"
								+ "3 - Sair\n");
						int escolha = entrada.nextInt();
						switch(escolha) {
						case 1:
							int aux = 0;
							while(aux != 5) {
								this.começo();
								System.out.println("\n1 - Cadastrar despesa Comum\n"
										+ "2 - Remover desepesa comum\n"
										+ "3 - Atualizar despesa comum\n"
										+ "4 - Buscar despesa comum\n"
										+ "5 - Sair\n");
								int escolha2 = entrada.nextInt();
								
								switch(escolha2) {
								case 1:{
									boolean ok = false;
									do {
										entrada.nextLine();
										
										System.out.println("Para cadastrar uma despesa é necessario ter uma carteira cadastrada\n");
										
										Carteira carteira = null;
										
										do {
											System.out.println("Informe o id da carteira: \n");
											String id = entrada.nextLine();
										
											try {
												carteira = wallet.buscarCarteira(id);
												
											System.out.println("\nDesccrição: \n");
											String descricao = entrada.nextLine();
											System.out.println("Data da compra (apenas os numeros)dia/mes/ano\n");
											int dia = entrada.nextInt();
											entrada.nextLine();
											int mes = entrada.nextInt();
											entrada.nextLine();
											int ano = entrada.nextInt();
											entrada.nextLine();
											LocalDate data = LocalDate.of(ano, mes, dia);
											System.out.println("Valor: \n");
											double valor = entrada.nextDouble();
											entrada.nextLine();
											System.out.println("Tipo: \n");
											String tipo = entrada.nextLine();
											System.out.println("Já foi pago? \n");
											boolean isPago = entrada.nextBoolean();
											entrada.nextLine();
																					
											DespesaComum despesa = new DespesaComum(carteira, valor, data, descricao, tipo, isPago);
										
											try {
												wallet.cadastrarDespesaComum(despesa);
												System.out.println("Despesa Cadastrada!\n");
												ok = true;
											} catch (ObjetoJaExisteException e) {
												System.out.println(e.getMessage());
												entrada.nextLine();
											}
											
											} catch (ObjetoNaoExisteException e) {
												System.out.println(e.getMessage());
												entrada.nextLine();
											}
											
										} while (carteira == null);
										
					
									} while (ok==false);
									break;
								}
								case 2:{
									entrada.nextLine();
									System.out.println("Remover despesa comum\n");
									System.out.println("Informe a descrição da receita que deseja remover: \n");
									String descricao = entrada.nextLine();
									
									DespesaComum remove = null;
									try {
										remove = wallet.buscarDespesaComum(descricao);
										
										if(remove != null) {
										System.out.println("Deseja remover a despesa "+ remove.getDescriçao()+ "?\n"
												+ "1 - sim \n"
												+ "2 - nao \n"
												+ "opçao: \n");
										int opc = entrada.nextInt();
										switch(opc) {
										case 1:
												try {
													wallet.removerDespesaComum(remove);
													
												} catch (ErroAoRemoverException e) {
													System.out.println(e.getMessage());
													entrada.nextLine();
												}
												
											}
										}else {
											System.out.println("Despesa removida!");
										}
										
									
									
									} catch (ObjetoNaoExisteException e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
									
									break;
								}
								case 3:{
									entrada.nextLine();
									System.out.println("Atualizar despesa comum\n");
									System.out.println("Informe a descriçao da despesa: \n");
									String descricao = entrada.nextLine();
									
									DespesaComum atualiza = null;
									
									try {
										atualiza = wallet.buscarDespesaComum(descricao);
										
										System.out.println("Informe os novos dados\n");
										System.out.println("Descrição: \n");
										String nvDescricao = entrada.nextLine();
										System.out.println("Tipo? \n");
										String nvTipo = entrada.nextLine();
										System.out.println("Despesa paga? sim-nao\n");
										boolean nvIsPago = entrada.nextBoolean();
										System.out.println("Data (apenas numeros dd/mm/aaaa) ");
										int nvDia = entrada.nextInt();
										int nvMes = entrada.nextInt();
										int nvAno = entrada.nextInt();
										LocalDate nvData = LocalDate.of(nvDia, nvMes, nvAno);
										double nvValor = entrada.nextDouble();
										
										atualiza.setDescriçao(nvDescricao);
										atualiza.setData(nvData);
										atualiza.setPago(nvIsPago);
										atualiza.setValor(nvValor);
										atualiza.setTipo(nvTipo);
										
										try {
											wallet.atualizarDespesaComum(atualiza);
											System.out.println("Despesa atualizada!\n");
											entrada.nextLine();
										} catch (ErroAoAtualizarException e) {
											System.out.println(e.getMessage());
											entrada.nextLine();
										}
										
									} catch (ObjetoNaoExisteException e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
									
									
		
									break;
								}
								case 4:{
									entrada.nextLine();
									System.out.println("Buscar despesa");
									System.out.println("Informe a descricao da despesa: \n");
									String busca = entrada.nextLine();
									
									DespesaComum buscada = null;
									
									try {
										buscada = wallet.buscarDespesaComum(busca);
										System.out.println("Informações sobre " +buscada.getDescriçao()+"\n");
										System.out.println(buscada);
										entrada.nextLine();
										
									} catch (ObjetoNaoExisteException e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
									
									
									break;
								}
								case 5:{
									System.out.println("Saindo...");
									entrada.nextLine();
									aux = 5;
									break;
								}							
							}
								
						}
						case 2:
							int muda6 = 0;
							while(muda6 != 5) {
								entrada.nextLine();
								this.começo();
								System.out.println("\nMenu de Despesa Cartão\n");
								System.out.println("1 - Cadastrar despesa\n"
										+ "2 - Remover despesa\n"
										+ "3 - Atualizar despesa\n"
										+ "4 - Buscar despesa\n"
										+ "5 - Sair\n");
								int esc = entrada.nextInt();
								switch(esc) {
								case 1:{
									boolean ok = false;
									do {
										entrada.nextLine();
										System.out.println("Para cadastrar uma despesa é necessário ter um cartao cadastrado\n");
										
										CartaoCredito cartao = null;
										do {
											System.out.println("Informe a descrição do cartao: \n");
											String descricao = entrada.nextLine();
											
											try {
												cartao = wallet.buscarCartao(descricao);
											} catch (ObjetoNaoExisteException e) {
												System.out.println(e.getMessage());
												entrada.nextLine();
											}
											
										} while (cartao == null);
										
										entrada.nextLine();
										System.out.println("Descrição: \n");
										String descricao = entrada.nextLine();
										System.out.println("Tipo: \n");
										String tipo = entrada.nextLine();
										System.out.println("Valor: \n");
										double valor = entrada.nextDouble();
										System.out.println("Numero de parcelas: \n");
										int numParcelas = entrada.nextInt();
										System.out.println("Data da compra (apenas numeros): \n");
										int dia = entrada.nextInt();
										int mes = entrada.nextInt();
										int ano = entrada.nextInt();
										LocalDate data = LocalDate.of(ano, mes, dia);
										
										DespesaCartao despesa = new DespesaCartao(cartao, valor, data, descricao, tipo, numParcelas);
										
										
											try {
												wallet.cadastrarDespesaCartao(despesa);
												System.out.println("Despesa Cadastrada! \n");
												ok = true;
												entrada.nextLine();
												
											} catch (ObjetoJaExisteException e) {
												System.out.println(e.getMessage());
												entrada.nextLine();
											}
										
											
											
										
										
										
									} while (ok==false);
									
									break;
								}
								case 2:{
									entrada.nextLine();
									System.out.println("Remover Despesa\n");
									System.out.println("Informe a descrição da despesa: \n");
									String busca = entrada.nextLine();
									DespesaCartao remove = null;
									
									try {
										remove = wallet.buscarDespesaCartao(busca);
										
										if(remove != null) {
										System.out.println("Você realmente deseja remover a despesa " + remove.getDescriçao() +"?\n");
										System.out.println("1 - sim\n"
												+ "2 - nao\n"
												+ "opção: \n");
										int opc = entrada.nextInt();
										switch(opc) {
										case 1:
												try {
													wallet.removerDespesaCartao(remove);
													System.out.println("Despesa removida! \n");
													entrada.nextLine();
												} catch (ErroAoRemoverException e) {
													System.out.println(e.getMessage());
													entrada.nextLine();
												}
												
											
											}
										
										}
										
									} catch (ObjetoNaoExisteException e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
									
									
									break;
								}
								case 3:{
									entrada.nextLine();
									System.out.println("Atualizar Despesa!\n");
									System.out.println("Informe a descrição da despesa que deseja atualizar: \n");
									String descricao = entrada.nextLine();
									
									DespesaCartao atualiza = null;
									
									try {
										atualiza = wallet.buscarDespesaCartao(descricao);
										
										
										System.out.println("Informe os novos dados: \n");
										
										System.out.println("Descrição: \n");
										String nvDescricao = entrada.nextLine();
										System.out.println("Tipo: \n");
										String nvTipo = entrada.nextLine();
										System.out.println("Valor: \n");
										double nvValor = entrada.nextDouble();
										System.out.println("Numero de parcelas: \n");
										int nvNumParcelas = entrada.nextInt();
										System.out.println("Data da compra (apenas numeros): \n");
										int nvDia = entrada.nextInt();
										int nvMes = entrada.nextInt();
										int nvAno = entrada.nextInt();
										LocalDate nvData = LocalDate.of(nvAno, nvMes, nvDia);
										
										atualiza.setDataCompra(nvData);
										atualiza.setDescriçao(nvDescricao);
										atualiza.setParcela(nvNumParcelas);
										atualiza.setTipo(nvTipo);
										atualiza.setValor(nvValor);
										
										try {
											wallet.atualizarDespesaCartao(atualiza);
											System.out.println("Despesa atualizada!\n");
											entrada.nextLine();
										} catch (ErroAoAtualizarException e) {
											System.out.println(e.getMessage());
											entrada.nextLine();
										}
									} catch (ObjetoNaoExisteException e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
									
									
										
										
				
										
									
									break;
								}
								case 4:{
									entrada.nextLine();
									System.out.println("Buscar despesa");
									System.out.println("Informe a descricao da despesa: \n");
									String busca = entrada.nextLine();
									
									DespesaCartao buscada = null;
									
									try {
										buscada = wallet.buscarDespesaCartao(busca);
										
										System.out.println("Informações sobre " +buscada.getDescriçao()+"\n");
										System.out.println(buscada);
										entrada.nextLine();
										
									} catch (ObjetoNaoExisteException e) {
										System.out.println(e.getMessage());
										entrada.nextLine();
									}
									
									
									break;
								}
								case 5:{
									System.out.println("Saindo...");
									entrada.nextLine();
									muda6 = 5;
									break;
								}
							}
						}
						case 3:
							System.out.println("Saindo...");
							entrada.nextLine();
							muda5 = 3;
							break;		
					}
					
						
					}
					
				
				case 0: 
					entrada.close();
					System.out.println("\nSaindo...");
					System.exit(0);
					break;
					
				default:
					System.out.println("\nInvalido!");
					break;
			
			
		}
	}
	
	}
		
	}
	