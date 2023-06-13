package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import estoque.MyExeptions;
import estoque.Product;
import server.SellProduct;

public class Client {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws MyExeptions, ClassNotFoundException {
		// TODO Auto-generated method stub
			
		try {
			while(true) {
				Socket s = new Socket("localhost", 1234);
				System.out.println("Conexão efetuada...");
				
				ObjectInputStream in = new ObjectInputStream(s.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
				
				Requirements Rsalle = new Requirements();
				Product product = Rsalle.dataSale();
				
				out.writeObject(product);
				
				SellProduct sp = (SellProduct) in.readObject();
				
				if(sp.getSalle()) {
					System.out.println("Produto Vendido");
				}
				else {
					throw new MyExeptions("Produto não encontrado ou fora de estoque");
				}
				s.close();
				}	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
