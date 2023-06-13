package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import estoque.Product;

public class Server {
	public static void main(String[] args){
		try {
			ServerSocket servidor = new ServerSocket(1234);
			System.out.println("Servidor Criado...");
			
			while(true) {
				Socket cliente = servidor.accept();
				
				ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
				
				Product product = (Product) in.readObject();
				
				SellProduct sell = new SellProduct();
				
				out.writeObject(sell.sellProduct(product.getCod(), product.getStockQuantity()));
				
				cliente.close();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
