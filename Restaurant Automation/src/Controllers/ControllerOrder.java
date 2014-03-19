/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import DatabaseClasses.OrderDB;
import GUI.KitchenStaffGUI;
import Main.Order;
import Main.OrderQueue;
import java.util.ArrayList;

/**
 *
 * @author prabh_000
 */
public class ControllerOrder {
    
    OrderQueue q=new OrderQueue();
    OrderDB ordDB=new OrderDB();
    ArrayList<Order> OrderQueue = new ArrayList<>();
    public Order create_order_request(int waiterID, int tableID)
    {    Order Order=new Order();
         Order.WaiterID=waiterID;
         Order.TableID=tableID;
         return Order;
      //Order.create_order(waiterID, tableID);
    }
    public Order add_items_request(Order order,String[] ItemsList)
    {
        order.update_item_list(order,ItemsList);
        return order;
    }
    public boolean place_order_request(Order order)
    {
        order.OrderID=order.get_order();
        System.out.println("Before Saving in DB Waiter:"+order.WaiterID+" TableID"+order.TableID);
      
        order.OrderStatus="InQueue";
        System.out.println("Storing Order in DB...");
        ordDB.store_order(order);
        System.out.println("Stored!");

        return true;
             
    }
    public boolean update_order_request(Order order)
    {
        order.OrderID=order.get_order();
        System.out.println("Before Saving in DB Waiter:"+order.WaiterID+" TableID"+order.TableID);
      
        order.OrderStatus="InQueue";
        System.out.println("Storing Order in DB...");
        ordDB.update_order(order);
        System.out.println("Stored!");
        return true;
    }
}
