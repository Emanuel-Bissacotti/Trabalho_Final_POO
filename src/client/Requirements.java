package client;

import java.util.Scanner;

import estoque.Product;

public class Requirements {
	public Product dataSale() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Codigo do produto: ");
		int cod = sc.nextInt();
		System.out.println("Quantidade: ");
		int quantity = sc.nextInt();
		
		Product product = new Product(cod, quantity);
		return product;
	}
}
