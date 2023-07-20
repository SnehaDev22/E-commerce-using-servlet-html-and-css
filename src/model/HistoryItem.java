package model;

public class HistoryItem {
	private int id;
	 private String custname;  
	private String name;
    private int qty;
    private double price;
    private double total;
    
	public HistoryItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoryItem(int id, String custname, String name, int qty, double price, double total) {
		super();
		this.id = id;
		this.custname = custname;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.total = total;
	}
	
	public HistoryItem(String custname, String name, int qty, double price, double total) {
		super();
		this.custname = custname;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.total = total;
	}
	public HistoryItem(String custname, String name, int qty, double price) {
		super();
		this.custname = custname;
		this.name = name;
		this.qty = qty;
		this.price = price;
	
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
    
}
