/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import DatabaseClasses.OrderDB;

/**
 *
 * @author prabh_000
 */

public class Order {
    public static int OrderID;
    public int ordID;
    public int WaiterID;
    public int TableID;
    public int KitchenStaffID;
    public String OrderStatus;
    public ArrayList<String> OrderItemList = new ArrayList<>();
    OrderDB orderdb=new OrderDB();
 
      
        
    public Order update_item_list(Order order,String[] ItemsList)
    {
       ArrayList<String> orderItemList = new ArrayList<>();
       System.out.println("Order Object updated!");
       System.out.println("Order Object now has:");
        for(int i=0;i<ItemsList.length;i++)
        {
        orderItemList.add(ItemsList[i]);
        System.out.println(orderItemList.get(i));
        }
       order.OrderItemList=orderItemList;
       return order;
        
    }
    
    public void create_order(int waiterID, int tableID)
    {
        this.WaiterID=waiterID;
        this.TableID=tableID;
     }
    
      public int get_order()
    {  
        OrderID=orderdb.getMaxOrderID()+1;
        
        return(OrderID);
       
    }
      
      public static void setOrderID(int OrderID) {
        Order.OrderID = OrderID;
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }

    public void setTableID(int TableID) {
        this.TableID = TableID;
    }

    public void setOrdID(int ordID) {
        this.ordID = ordID;
    }

    public void setWaiterID(int WaiterID) {
        this.WaiterID = WaiterID;
    }

    public int getOrdID() {
        ordID=OrderID;
        return ordID;
    }

    public static int getOrderID() {
        return OrderID;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public int getTableID() {
        return TableID;
    }

    public int getWaiterID() {
        return WaiterID;
    }
   
    public void setKitchenStaffID(int KitchenStaffID) {
        this.KitchenStaffID = KitchenStaffID;
    }

    public int getKitchenStaffID() {
        return KitchenStaffID;
    }
    public void setOrderItemList(ArrayList<String> OrderItemList) {
        this.OrderItemList = OrderItemList;
    }

    public ArrayList<String> getOrderItemList() {
        return OrderItemList;
    }
}

