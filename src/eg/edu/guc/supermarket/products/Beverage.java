package eg.edu.guc.supermarket.products;

public class Beverage extends GroceryProduct {
	SugarLevel s;
	public Beverage(String n,int  p,int d,SugarLevel sa){
		super(n,p,d);
		this.s=sa;
	}
	public int getActualPrice(){
		return price-(price*(discount/100));
	}

	public String toString(){
		 return super.toString()+"\n"+" Sugar Level: "+this.s;
	}

}
