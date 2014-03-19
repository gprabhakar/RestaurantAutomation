/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author prabh_000
 */
public class EmployeeDB {
    String dbURL = "jdbc:mysql://localhost:3306/employeedb";
            String username ="root";
            String dbpass = "root";
            
            Connection dbCon = null;
            Statement stmt = null;
            ResultSet rs = null;
           
    public String[] getDetails(int UserID)
    {
         String query ="SELECT password,designation FROM employeedb.employee where EmpID="+UserID+";";
         String[] resultset=new String[2];  
        try {
                //getting database connection to MySQL server
                dbCon = DriverManager.getConnection(dbURL, username, dbpass);
               
                //getting PreparedStatment to execute query
                stmt = dbCon.prepareStatement(query);
                 
                //Resultset returned by query
                rs = stmt.executeQuery(query);
                
               
                while(rs.next()){
                  
                  resultset[0]= rs.getString(1);
                  resultset[1]=rs.getString(2);              
                }
                for(int j=0;j<resultset.length;j++)
                {
                    System.out.println(resultset[j]);
                }
                             
            } catch (SQLException ex) {
                System.out.println(ex);
            }
         
        return (resultset) ;
    }
    public String[] getTables(int UserID)
    {
     //  String resultset[];
         String query ="SELECT Tables FROM employeedb.employee where EmpID="+UserID+";";
         String resultset=""; 
         String[] TableList=new String[5];
        try {
                //getting database connection to MySQL server
                dbCon = DriverManager.getConnection(dbURL, username, dbpass);
               
                //getting PreparedStatment to execute query
                stmt = dbCon.prepareStatement(query);
                 
                //Resultset returned by query
                rs = stmt.executeQuery(query);
                
               
                while(rs.next()){
                  
                  resultset= rs.getString(1);
                       
                }
               TableList = resultset.split(",");
                 
                for(int j=0;j<TableList.length;j++)
                {
                    System.out.println(TableList[j]);
                }
                             
            } catch (SQLException ex) {
                System.out.println(ex);
            }
         
        return (TableList) ;
          
    }
}
