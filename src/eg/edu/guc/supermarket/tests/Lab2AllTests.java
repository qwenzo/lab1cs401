package eg.edu.guc.supermarket.tests;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import static org.junit.Assert.*;
import eg.edu.guc.supermarket.products.Beverage;
import eg.edu.guc.supermarket.products.DairyProduct;
import eg.edu.guc.supermarket.products.Fat;
import eg.edu.guc.supermarket.products.GroceryProduct;
import eg.edu.guc.supermarket.products.SugarLevel;

public class Lab2AllTests {
	
	//--------------------------------Checking methods in superclass/subclasses-----------------------------------
	//Private
	@Test(timeout = 1000)
	public void testMethodsInSuperclass()
	{
		Method[] methods= GroceryProduct.class.getDeclaredMethods();
		assertTrue("The method \"getActualPrice\" should be declared in the GroceryProduct class", containsMethodName(methods, "getActualPrice"));
		assertTrue("The method \"toString\" should be declared in the GroceryProduct class", containsMethodName(methods, "toString"));
	}
	
	@Test(timeout = 1000)
	public void testMethodsInSubclasses()
	{
		Method[] methodsDairyProduct= DairyProduct.class.getDeclaredMethods();
		assertFalse("The method \"getActualPrice\" should be not declared in the DairyProduct class", containsMethodName(methodsDairyProduct, "getActualPrice"));
		assertTrue("The method \"toString\" should be overriden in the DairyProduct class", containsMethodName(methodsDairyProduct, "toString"));
		
		Method[] methodsBeverage= Beverage.class.getDeclaredMethods();
		assertFalse("The method \"getActualPrice\" should be not declared in the Beverage class", containsMethodName(methodsBeverage, "getActualPrice"));
		assertTrue("The method \"toString\" should be overriden in the Beverage class", containsMethodName(methodsBeverage, "toString"));
	}
	//---------------------------------------------------Checking Final methods----------------------------------------------------------------
	//Private
	@Test(timeout = 1000)
	public void testFinalMethodsDeclaration() throws NoSuchFieldException, NoSuchMethodException, SecurityException
	{
		assertTrue(Modifier.isFinal(GroceryProduct.class.getDeclaredMethod("getActualPrice", null).getModifiers()));
	}
	//--------------------------------------Checking methods work correctly----------------------------------------------
	
	//test getActualPrice
	@Test(timeout = 1000)
	public void testGetActualPrice()
	{
		DairyProduct milk= new DairyProduct("Juhayna Milk", 10, 5, Fat.FULLCREAM);
		assertEquals("The actual price should be 9.5", 9.5, milk.getActualPrice(), 0.1);
	}
	//toString -> Grocery
		@Test(timeout = 1000)
		public void testToStringGroceryProduct()
		{
			GroceryProduct milk= new GroceryProduct("Juhayna Milk", 10, 5);
			assertEquals("The toString() method should return: \n Name: Juhayna Milk \n Price: 10.0 \n Discount: 5.0 %",
					"Name: Juhayna Milk\nPrice: 10.0\nDiscount: 5.0 %", milk.toString());
		}
	//toString -> Dairy
	@Test(timeout = 1000)
	public void testToStringDairyProduct()
	{
		DairyProduct milk= new DairyProduct("Juhayna Milk", 10, 5, Fat.FULLCREAM);
		assertEquals("The toString() method should return: \n Name: Juhayna Milk \n Price: 10.0 \n Discount: 5.0 %\n Fat Level: FULLCREAM",
				"Name: Juhayna Milk\nPrice: 10.0\nDiscount: 5.0 %\nFat Level: FULLCREAM", milk.toString());
	}
	//toString -> Beverage
	//Private
	@Test(timeout = 1000)
	public void testToStringBeverage()
	{
		Beverage beverage= new Beverage("Schweppes Pomegranate", 5, 25, SugarLevel.ADDED_SUGAR);
		assertEquals("The toString() method should return: \n Name: Schweppes Pomegranate \n Price: 5.0 \n Discount: 25.0 %\n Sugar Level: ADDED_SUGAR\n",
				"Name: Schweppes Pomegranate\nPrice: 5.0\nDiscount: 25.0 %\nSugar Level: ADDED_SUGAR", beverage.toString());
	}
	//--------------------------------------------Helper methods----------------------------------------------------------
	public static boolean containsMethodName(Method[]methods, String name){
		for (Method method : methods) {
			if(method.getName().equals(name))
				return true;
		}
		return false;
	}
}
