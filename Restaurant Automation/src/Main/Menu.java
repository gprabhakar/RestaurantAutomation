/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author prabh_000
 */
public class Menu {
	
	ArrayList<String> category = new ArrayList();
	HashMap<String, ArrayList<String>> categoryItems = new HashMap<String, ArrayList<String>>();
	
	public Menu() {
		addCategory();
		addSubMenusForCategoryItem();
	}
	
	private void addCategory() {
		category.add("Soup");
		category.add("Appetizers");
		category.add("Breads");
		category.add("Main Course");
		category.add("Desserts");
	}
	
	public ArrayList getCategories() {
		return category;
	}
	
	private void addSubMenusForCategoryItem() {
		ArrayList<String> soup = new ArrayList<String>(){{
			add("Tomato Soup");
			add("Veg Manchow Soup");
			add("Chicken Manchow Soup");
			add("Chicken Clear Soup");
		}};
		
		ArrayList<String> appetizers = new ArrayList<String>() {{
			add("Spring Roll");
			add("Samosa");
			add("Chicken 65");
			add("Drum stick of Heavens");
		}};
		
		ArrayList<String> bread = new ArrayList<String>() {{
			add("Garlic Naan");
			add("Roti");
			add("Butter Naan");
			add("Aloo Paratha");
		}};
		
		ArrayList<String> mainCourse = new ArrayList<String>() {{
			add("Schezwan Fried Rice");
			add("Desi Fried Rice");
			add("Garlic Fried Rice");
			add("Prawn Fried Rice");
		}};
		
		ArrayList<String> dessert = new ArrayList<String>() {{
			add("Vanilla");
			add("Split Banana");
			add("Choclate Twist");
			add("Butterscotch");
		}};
		
		categoryItems.put("Soup", soup);
		categoryItems.put("Appetizers", appetizers);
		categoryItems.put("Breads", bread);
		categoryItems.put("Main Course", mainCourse);
		categoryItems.put("Desserts", dessert);
	}
	
	public void displayCategories() {
		for( int iterator = 0; iterator < category.size(); iterator++) {
			System.out.println(category.get(iterator));
		}
	}
	
	public void displayCategoriesItem(String category) {
		if(categoryItems.containsKey(category)){
			ArrayList<String> cats = categoryItems.get(category);
			for( int iterator = 0; iterator < cats.size(); iterator++) {
				System.out.println(cats.get(iterator));
			}
		}
	}
	
	public ArrayList  getCategoryItems(String category) {
		if(this.categoryItems.containsKey(category)){
			ArrayList<String> categoryItemList = categoryItems.get(category);
                        
			return categoryItemList;
		}
		
		else {
			return null;
		}
	}		
} 

