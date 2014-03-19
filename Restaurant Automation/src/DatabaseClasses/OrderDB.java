/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Main.Order;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author prabh_000
 */
public class OrderDB {
     String dbURL = "jdbc:mysql://localhost:3306/OrderDB";
     String username ="root";
     String dbpass = "root";
     String query;     
     Connection dbCon = null;
     Statement stmt = null;
      ResultSet rs ;
       
    public boolean store_order(Order o)
    {   
        query="INSERT INTO OrderDB.order (OrderID,TableID,WaiterID,OrderItems,OrderStatus) VALUE ('"+o.getOrdID()+"','"+o.getTableID()+"','"+o.getWaiterID()+"','"+o.getOrderItemList().toString()+"','"+o.getOrderStatus()+"')";

        try {
                //getting database connection to MySQL server
                dbCon = DriverManager.getConnection(dbURL, username, dbpass);
               
                //getting PreparedStatment to execute query
                stmt = dbCon.prepareStatement(query);
                 
                //Resultset returned by query
                stmt.executeUpdate(query);
        }
        catch (SQLException ex) {
                System.out.println(ex);
         }
        return true;
     }
    public int getMaxOrderID()
    {
      query="SELECT MAX(OrderID) FROM orderdb.order;";
      int Maxorderid=0;
  
        try {
                //getting database connection to MySQL server
                dbCon = DriverManager.getConnection(dbURL, username, dbpass);
               
                //getting PreparedStatment to execute query
                stmt = dbCon.prepareStatement(query);
                 
                //Resultset returned by query
                rs=stmt.executeQuery(query);
        while(rs.next())
                Maxorderid= rs.getInt(1);
        }
        catch (SQLException ex) {
                System.out.println(ex);
         }
        
        return(Maxorderid);
    }
    public String[] getOrderItems(int orderid)
    {
        
         query="SELECT OrderItems FROM orderdb.order WHERE OrderID="+orderid;
         String[] ItemList={};
  
        try {
                //getting database connection to MySQL server
                dbCon = DriverManager.getConnection(dbURL, username, dbpass);
               
                //getting PreparedStatment to execute query
                stmt = dbCon.prepareStatement(query);
                 
                //Resultset returned by query
                rs=stmt.executeQuery(query);
        while(rs.next())
        {
            String s=rs.getString(1);
            ItemList=s.split(",");
            
        }
               
        }
        catch (SQLException ex) {
                System.out.println(ex);
         }
        ItemList[0] = ItemList[0].substring(1);
        for(int i=1;i<ItemList.length;i++)
        {
            ItemList[i]=ItemList[i].substring(1);
        }
        int size = ItemList.length;
        //System.out.println(ItemList[size-1]);
        //ItemList[size-1].l
        ItemList[size-1] = ItemList[size-1].substring(0,ItemList[size-1].length()-1);
        return ItemList;
    }
    public boolean update_order(Order o)
    {
        ArrayList<String> newList = new ArrayList<>();
        newList = o.getOrderItemList();
//        for(int i=0;i<newList.size();i++)
//            System.out.println(newList.get(i));
//        System.out.println(o.getOrderItemList());
        String s = "[";
        s = s+newList.get(0);
        for(int i=1;i<newList.size();i++)
        {
            s= s+", "+newList.get(i);
        }
        s= s+"]";
//        System.out.println(s);
//        System.out.println("###");
//        System.out.println(o.ordID);
        
         query = "update orderdb.order SET OrderItems ='"+s+"' Where OrderID = "+o.ordID+";";
                 //"UPDATE orderdb.order SET OrderItems ='"+o.getOrderItemList()+"' WHERE OrderID ="+o.getOrdID()+";";
         //String query ="SELECT password,designation FROM employeedb.employee where EmpID="+OrderID+";";
        // String[] resultset=new String[2];  
        try {
                //getting database connection to MySQL server
                dbCon = DriverManager.getConnection(dbURL, username, dbpass);
               
                //getting PreparedStatment to execute query
                stmt = dbCon.prepareStatement(query);
                 
                //Resultset returned by query
                stmt.executeUpdate(query);
        }
        catch (SQLException ex) {
                System.out.println(ex);
         }
        return true;
    }
    public boolean remove_order(int orderid)
    {
          query ="DELETE FROM orderdb.order WHERE OrderID="+orderid+";";
         
        try {
                //getting database connection to MySQL server
                dbCon = DriverManager.getConnection(dbURL, username, dbpass);
               
                //getting PreparedStatment to execute query
                stmt = dbCon.prepareStatement(query);
                 
                //Resultset returned by query
                stmt.executeUpdate(query);
                System.out.println("Query Exc" +query);
        }
        catch (SQLException ex) {
                System.out.println(ex);
         }
        return true;
    }
    
    public String check_order_status(int orderid)
    {
        query="SELECT OrderStatus FROM orderdb.order WHERE OrderID='"+orderid+"';";
        String orderstatus="";
           try {
                //getting database connection to MySQL server
                dbCon = DriverManager.getConnection(dbURL, username, dbpass);
               
                //getting PreparedStatment to execute query
                stmt = dbCon.prepareStatement(query);
                 
                //Resultset returned by query
                rs=stmt.executeQuery(query);
                while(rs.next())
                {
                 orderstatus=rs.getString(1);
                }
               System.out.println("Orderstatus "+orderstatus);
        }
         catch (SQLException ex) {
                System.out.println(ex);
         }
        
         return orderstatus;
        }
        
    
    public ArrayList<Order> getOrderofTable(int WaiterID,int TableID){
                
         query="SELECT * FROM orderdb.order WHERE TableID='"+TableID+"' AND WaiterID='"+WaiterID+"';";
         ArrayList<Order> orderList=new ArrayList();      
         
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
                   orderList.add(order);
                }
            }
        
        catch (SQLException ex) {
                System.out.println(ex);
         }
        
       return(orderList);
     }
}