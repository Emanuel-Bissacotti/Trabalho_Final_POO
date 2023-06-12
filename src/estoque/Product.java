package estoque;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable{
	private int cod;
	private String description;
	private double priceCost;
	private double priceSale;
	private int stockQuantity;
	
	public Product(int cod, String description, double priceCost, double priceSale, int stockQuantity) {
		super();
		this.cod = cod;
		this.description = description;
		this.priceCost = priceCost;
		this.priceSale = priceSale;
		this.stockQuantity = stockQuantity;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public double getPriceCost() {
		return priceCost;
	}

	public double getPriceSale() {
		return priceSale;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}


	public void setPriceSale(double priceSale) {
		this.priceSale = priceSale;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	public void sale() throws MyExeptions{
		if(this.stockQuantity > 0) this.stockQuantity--;
		
		else throw new MyExeptions("Produto não esta disponivel"); 
	}
	
	
}
