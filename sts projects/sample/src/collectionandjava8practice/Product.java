package collectionandjava8practice;

public class Product {

	private int prodid;
	private String name;
	private double price;
	private boolean inStock;

	public Product() {
		super();
	}

	public Product(int prodid, String name, double price, boolean inStock) {
		super();
		this.prodid = prodid;
		this.name = name;
		this.price = price;
		this.inStock = inStock;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return "Product [prodid=" + prodid + ", name=" + name + ", price=" + price + ", inStock=" + inStock + "]\n";
	}

}
