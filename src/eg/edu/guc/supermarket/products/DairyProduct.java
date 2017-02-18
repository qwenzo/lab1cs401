package eg.edu.guc.supermarket.products;

public class DairyProduct extends GroceryProduct {
	Fat f;
	public DairyProduct(String n,int  p,int  d,Fat fa){
		super(n,p,d);
		this.f=fa;
	}
	public int getActualPrice(){
		return price-(price*(discount/100));
	}

	public String toString(){
		 return super.toString()+"\n"+" Fat Level: "+this.f;
	}
	
}
