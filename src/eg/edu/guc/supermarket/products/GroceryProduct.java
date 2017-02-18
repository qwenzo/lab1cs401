package eg.edu.guc.supermarket.products;

public class GroceryProduct {
	String name;
	int price;
	int  discount;
	public GroceryProduct(String n,int p,int d){
		name =n;
		price =p;
		discount=d;
	}
	public int getActualPrice(){
		return price-(price*(discount/100));
	}
	public String toString(){
		return " Name:" +this.name+"\n"+"Price:"+this.price+" L.E"+"\n"+"Discount: "+this.discount+" %";
	}
	
	

}
