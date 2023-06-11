package estoque;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	public void menu() throws MyExeptions {
		ArrayList<Product> products = new ArrayList<Product>();
		Processing processing = new Processing();
		ManipulateFile Mfile = new ManipulateFile();
		products = Mfile.getProductFile();
		Scanner sc = new Scanner(System.in);

		int menu;
		while(true){
			System.out.println("1 - Cadastrar produto\r\n"
					+ "2 - Alterar preço produto\r\n"
					+ "3 - Excluir produto\r\n"
					+ "4 - Sair do sistema");
			
			System.out.println("Qual opção deseja: ");
			menu = sc.nextInt();
			
			
			switch (menu) {
			case 1: { // Cadastrar produto
				products.add(processing.inputs());
				Mfile.saveProductFile(products);
				break ;
			}
			
			case 2: { // Alterar preço produto
				products = processing.findProduct(products);
				Mfile.saveProductFile(products);
				break ;
			}
			
			case 3: {// Excluir produto
				products = processing.deleteProduct(products);
				Mfile.saveProductFile(products);
				break ;
			}
			
			case 5: {
				for (Product product : products) {
					System.out.println("Codigo: "+ product.getCod());
					System.out.println("Descrição: "+ product.getDescription());
					System.out.println("Preço de custo: "+ product.getPriceCost());
					System.out.println("Preço de venda: "+ product.getPriceSale());
					System.out.println("Quantidade: "+ product.getStockQuantity());
					System.out.println("\n");
				}
				break ;
			}
			
			case 4: {
				System.out.println("Saindo....");
				sc.close();
				System.exit(0);
				return ;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + menu);
			}
		}
	}
}
