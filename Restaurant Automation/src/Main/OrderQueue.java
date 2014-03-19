/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import Main.Order;
import GUI.KitchenStaffGUI;
import java.sql.*;

/**
 *
 * @author prabh_000
 */
public class OrderQueue {
//    ArrayList<Order> OrderQueue = new ArrayList<>();
//    KitchenStaffGUI kgui=new KitchenStaffGUI();
//    public  ArrayList<Order> get_order_queue()
//    {
//        return OrderQueue;
//    }
//    
//    public KitchenStaffGUI place_order_in_queue(Order order)
//    {   int orderid=0;
//        OrderQueue.add(order);
//        kgui.updateOrderQueue(OrderQueue);
//        return(kgui);
//    }
//    
//    public void update_order_in_queue()
//    {
//        
//    }
     String dbURL = "jdbc:mysql://localhost:3306/OrderDB";
     String username ="root";
     String dbpass = "root";
     String query;     
     Connection dbCon = null;
     Statement stmt = null;
     ResultSet rs;
     
       
    public ArrayList<Order> get_order_queue()
    {    query="SELECT * FROM orderdb.order WHERE OrderStatus='InQueue'";
         ArrayList<Order> orderqueue=new ArrayList();      
         String[] resultset=new String[2];  
        try {
                //getting database connection to MySQL server
                dbCon = DriverManager.getConnection(dbURL, username, dbpass);
               
                //getting PreparedStatment to execute query
                stmt = dbCon.prepareStatement(query);
                 
                //Resultset returned by query
                rs=stmt.executeQuery(query);
                while(rs.next())
                {
                   Order order=new Order();
                   order.setOrdID(rs.getInt(1));
                   order.setTableID(2);
                   order.setWaiterID(3);
                   String s=",";
                   String temp=rs.getString(4);
                   String[] itemlist;
                   itemlist=temp.split(s);
                   for(int i=0;i<itemlist.length;i++)
                   {
                       order.OrderItemList.add(itemlist[i]);
                   }
                   order.setOrderStatus(rs.getString(5));
                   orderqueue.add(order);
                }
                
        }
        catch (SQLException ex) {
                System.out.println(ex);
         }
        
        return(orderqueue);
     }
}
