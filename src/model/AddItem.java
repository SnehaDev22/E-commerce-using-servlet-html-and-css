package model;



public class AddItem {
	 private int id;
   
	private String name;
    private int qty;
    private double price;
    private double total;
	public AddItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	 public AddItem(int id, String name, int qty, double price, double total) {
			super();
			this.id = id;
			this.name = name;
			this.qty = qty;
			this.price = price;
			this.total = total;
		}
	public AddItem(String name, int qty, double price,double total) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.total = total;
	}
	
	public AddItem(String name, int qty, double price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	
	public AddItem(String name, int qty) {
		super();
		this.name = name;
		this.qty = qty;
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    
  /*  public AddItem(String name,int qty, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    public int getQty() {
        return qty;
    }*/
}
