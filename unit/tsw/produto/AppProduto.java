package unit.tsw.produto;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppProduto {

	static List<ProdutoNovo> listaProdutos = new ArrayList<ProdutoNovo>();
	
	static Scanner ler = new Scanner(System.in);
	static int opcao;

	public static void main(String[] args) {

		do {
			System.out.println("\n*** Seletor de Opções ***");
			System.out.println();
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Consultar produto");
			System.out.println("3 - Registrar produção");
			System.out.println("4 - Registrar saída");
			System.out.println("5 - Listagem de produto");
			System.out.println("0 - Finalizar");

			try {
				System.out.print("\nOpção: ");
				opcao = ler.nextInt();
			} catch (Exception e) {
				System.out.println("\nA opção deve ser numérica\n");
				ler.next();
				continue;
			}

			switch (opcao) {
			case 1:
				cadastrarProduto();
				break;
			case 2:
				consultarProduto();
				break;
			case 3:
				producaoProduto();
				break;
			case 4:
				saidaProduto();
				break;
			case 5:
				listagemProduto();
				break;
			case 0:
				System.out.println("\n--- PROGRAMA FINALIZADO  ---");
				break;
			default:
				System.out.printf("\nOpção incorreta!!!\n");
			}

		} while (opcao != 0);
	}

	public static void cadastrarProduto() {

		int codigo;
		System.out.println("\n--- Cadastro de produto ---");
		do {
			try {
				System.out.print("\nCódigo: ");
				codigo = ler.nextInt();
				break;
			}
			catch(Exception e) {
				System.out.println("\nO código deve ser numérico");
				ler.next();
				continue;
			}		
		} while (true);
		
		// Criticar para não aceitar duplicidade
		
		ler.nextLine();
		System.out.print("Descrição: ");
		String descricao = ler.nextLine();

		float precoCusto;
		do {
			try {
				System.out.print("Preço de custo: ");
				precoCusto = ler.nextFloat();
				break;
			}
			catch (Exception e) {
				System.out.println("\nO preço de custo deve ser numérico");
				ler.next();
				continue;
			}	
		} while (true);

		ProdutoNovo produto = new ProdutoNovo(codigo, descricao, precoCusto);

		listaProdutos.add(produto);
		System.out.println("\nProduto Cadastrado");					
	}

	public static ProdutoNovo pesquisarProdutoPorCodigo(int cod) {
		for (ProdutoNovo produto : listaProdutos) {
			if (produto.getCodigo() == cod) {
				return produto;				
			}
		}
		return null;
	}

	public static void consultarProduto() {
		if (listaProdutos.size() == 0) {
			System.out.println("\nNão há produto cadastrado");
			return;
		}

		System.out.println("\n--- Consultar de produto ---");
		
		int codigo;
		do {
			try {
				System.out.print("\nCódigo: ");
				codigo = ler.nextInt();
				break;
			}
			catch(Exception e) {
				System.out.println("\nO código deve ser numérico");
				ler.next();
				continue;
			}		
		} while (true);

		ProdutoNovo produto = pesquisarProdutoPorCodigo(codigo);
		if (produto == null) {
			System.out.println("\nProduto não cadastrado");			
		}
		else {
			System.out.printf("\nCódigo........: %d", produto.getCodigo());
			System.out.printf("\nDescrição.....: %s", produto.getDescricao());
			System.out.printf("\nPreço de custo: %.2f", produto.getPrecoCusto());
			System.out.printf("\nEstoque.......: %d", produto.getEstoque());
			System.out.println();		
		}
	}
	
	public static void producaoProduto() {
		if (listaProdutos.size() == 0) {
			System.out.println("\nNão há produto cadastrado");
			return;
		}

		System.out.println("\n--- Produção de produto ---");
		
		int codigo;
		do {
			try {
				System.out.print("\nCódigo: ");
				codigo = ler.nextInt();
				break;
			}
			catch(Exception e) {
				System.out.println("\nO código deve ser numérico");
				ler.next();
				continue;
			}		
		} while (true);

		ProdutoNovo produto = pesquisarProdutoPorCodigo(codigo);
		if (produto == null) {
			System.out.println("\nProduto não cadastrado");
			return;
		}
		
		int qtdeProduzida;
		do {
			try {
				System.out.print("\nQuantidade produzida: ");
				qtdeProduzida = ler.nextInt();
				break;
			}
			catch(Exception e) {
				System.out.println("\nA quantidade deve ser numérico");
				ler.next();
				continue;
			}		
		} while (true);

		produto.producao(qtdeProduzida);
		System.out.println("\nEstoque atualizado");			
	}
	
	public static void saidaProduto() {
		if (listaProdutos.size() == 0) {
			System.out.println("\nNão há produto cadastrado");
			return;
		}

		System.out.println("\n--- Saída de produto ---");
		
		int codigo;
		do {
			try {
				System.out.print("\nCódigo: ");
				codigo = ler.nextInt();
				break;
			}
			catch(Exception e) {
				System.out.println("\nO código deve ser numérico");
				ler.next();
				continue;
			}		
		} while (true);

		ProdutoNovo produto = pesquisarProdutoPorCodigo(codigo);
		if (produto == null) {
			System.out.println("\nProduto não cadastrado");			
		}
		else {
			if (produto.getEstoque() == 0) {
				System.out.println("\nEstoque zerado");
				return;				
			}
			
			int qtdeSaida;
			do {
				try {
					System.out.print("\nQuantidade de saída: ");
					qtdeSaida = ler.nextInt();
					break;
				}
				catch(Exception e) {
					System.out.println("\nA quantidade de saída deve ser numérico");
					ler.next();
					continue;
				}		
			} while (true);

			if (produto.getEstoque() < qtdeSaida) {
				System.out.println("\nQuantidade não disponível");
				return;
			}
			
			produto.saida(qtdeSaida);
			System.out.println("\nEstoque atualizado");			
		}
	}
	
	public static void listagemProduto() {
		if (listaProdutos.size() == 0) {
			System.out.println("\nNão há produto cadastrado");
			return;
		}
		System.out.println("           Listagem de Produtos");
		System.out.println("___________________________________________\n");
		System.out.println("Código Descrição       Estoque  Preço Custo");
		System.out.println("___________________________________________");
		for (ProdutoNovo produto : listaProdutos) {
			System.out.printf("\n%-6d %-16s %6d %12.2f", produto.getCodigo(), 
					produto.getDescricao(), produto.getEstoque(), produto.getPrecoCusto());
		}
		System.out.println("\n___________________________________________");
	}


}