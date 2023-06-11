package estoque;

import java.util.ArrayList;
import java.util.Scanner;

public class Processing {
	public Product inputs() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite os dados do produto");
		System.out.println("codigo, descrição, preço de custo, preço de venda e estoque disponível");
		
		int cod = sc.nextInt();
		sc.nextLine();
		String description = sc.nextLine();
		double priceCost = sc.nextDouble();
		double priceSale = sc.nextDouble();
		int stockQuantity = sc.nextInt();
		
		Product product = new Product(cod, description, priceCost, priceSale, stockQuantity);
		return product;
	}
	
	public ArrayList<Product> findProduct(ArrayList<Product> products) throws MyExeptions{
		Scanner sc = new Scanner(System.in);
		boolean exist = false;
		System.out.println("Insira o codigo do produto: ");
		int cod = sc.nextInt();
		
		for (Product product : products) {
			if(product.getCod() == cod) {
				exist = true;
				System.out.println("Novo preço: ");
				double newPrice = sc.nextDouble();
				product.setPriceSale(newPrice);
			}
		}
		
		if(!exist) {
			throw new MyExeptions("Produto não encontrado");
		}
		
		return products;
	}
	
	public ArrayList<Product> deleteProduct(ArrayList<Product> products) throws MyExeptions{
		Scanner sc = new Scanner(System.in);
		boolean exist = false;
		System.out.println("Insira o codigo do produto: ");
		int cod = sc.nextInt();
		
		
		for (Product product : products) {
			if(product == null) {
				return products;
			}
			else if(product.getCod() == cod) {
				exist = true;
				Product productRemov = product;
				products.remove(productRemov);
				return products;
			}
		}
		
		if(!exist) {
			throw new MyExeptions("Produto não encontrado");
		}

		return products;
	}
}
