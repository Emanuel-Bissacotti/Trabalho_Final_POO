package estoque;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ManipulateFile {
	@SuppressWarnings("unchecked")
	
	public ArrayList<Product> getProductFile() { //recebe todos os produtos do arquivo e armazena em uma lista de outra forma
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			File file = new File("produtos.ser");
	        if (file.exists()) {
				ObjectInputStream escritor = new ObjectInputStream(new FileInputStream("produtos.ser"));
				products = (ArrayList<Product>)escritor.readObject();
				escritor.close();
	        }
	        
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public void saveProductFile(ArrayList<Product> products) {
	      try {
	    	 FileOutputStream fileProducts = new FileOutputStream("produtos.ser");
	    	 ObjectOutputStream escritor = new ObjectOutputStream(fileProducts);
	    	  
	        
	        escritor.writeObject(products);
	        escritor.close();
	        fileProducts.close();

	      } catch(IOException erro) {
	          System.out.printf("Erro: %s", erro.getMessage());
	      }
	}
	
}
