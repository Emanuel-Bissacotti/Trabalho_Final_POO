package server;

import java.io.Serializable;
import java.util.ArrayList;

import estoque.ManipulateFile;
import estoque.MyExeptions;
import estoque.Product;

@SuppressWarnings("serial")
public class SellProduct implements Serializable{
	private boolean salle;
	
	public boolean getSalle() {
		return salle;
	}

	public SellProduct sellProduct(int cod, int quantity) throws MyExeptions{
		ManipulateFile file = new ManipulateFile();
		ArrayList<Product> products = file.getProductFile();
		SellProduct Sp = new SellProduct();
		Sp.salle = false;
		for (Product product : products) {
			if(product.getCod() == cod) {
				Sp.salle = product.sale(quantity);
				System.out.println("Foi vendida "+quantity+" unidades do produto: "+product.getDescription());
			}
		}
		file.saveProductFile(products);
		return Sp;
	}
}
