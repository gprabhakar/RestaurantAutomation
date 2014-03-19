/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import DatabaseClasses.EmployeeDB;
import GUI.*;
import Main.Menu;
import java.util.ArrayList;
import Main.Order;
import Main.OrderQueue;
/**
 *
 * @author prabh_000
 */
public class ControllerGUI
{
     int UserID;
     String password;
     String designation;
     String auth;
     Menu m=new Menu();
     ControllerOrder Co=new ControllerOrder();
     KitchenStaffGUI kgui=new KitchenStaffGUI();
    public String sendCredentials(int ID,String pass)
    {   
        UserID=ID;
        EmployeeDB empDB=new EmployeeDB();
        String[] empdetails=empDB.getDetails(ID);
        if (empdetails[0]==null)
        return "invalid";
        else 
        {
        password=empdetails[0];
        designation=empdetails[1];
        boolean authenticate=authenticate(pass);
        if(authenticate==true)
        {
            Create(designation);
            return "true";
        }
        else
            return "false";
        }
     
          
                
    }
    boolean authenticate(String pass)
   {   
       if(pass.equals(this.password))
        return true;
       else
        return false;
   }
    void Create(String des)
    {
        if(des.equals("Waiter"))
            new WaiterGUI(UserID).setVisible(true);
        
        if(des.equals("KitchenStaff"))
        {
            
           new KitchenStaffGUI().setVisible(true);
        }
        
}
   public Order create_order_request(int WaiterID,int TableID)
    {
        ControllerOrder Co=new ControllerOrder();
        Order Order=Co.create_order_request(WaiterID, TableID);
   
        return Order;
       }
   public ArrayList<String> get_menu()
   {
       ArrayList<String> category=m.getCategories();
       return category;
   }
  public ArrayList selectCategory(String category) 
  {
      ArrayList<String> categoryItemList =m.getCategoryItems(category);
      return categoryItemList;
  }
    public Order add_items_request(Order order,String[] ItemsList)
    {
        order= Co.add_items_request(order,ItemsList);
        return order;
    }
    public void orderConfirmed(Order order)
    {
        Co.place_order_request(order);
    }
    public void updateOrder(Order order)
    {
        Co.update_order_request(order);
    }
}

  