package Database;

//My class

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public final class DBManager 
{
    private static final String USERNAME = "pdc";      //DB username   Week 8 lab
    private static final String PASSWORD = "pdc";       //DB password 
    
    //Fill later 
    private static final String URL = "";        //URL of host
    
    Connection conn;
    
    public DBManager()
    {
        establishConnection();
    }
    
    //Main method of the class
    public static void main(String[] args)
    {
        DBManager dbManager = new DBManager();          //New DB manager
        System.out.println(dbManager.getConnection());  //Get connection
    }
    
    public Connection getConnection()
    {
        return this.conn;                       
    }

    //Establish connection
    private void establishConnection() 
    {
        //Establish a connection to the database
        try
        {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println(URL + "connected...");         //Print statement 
        }
        
        catch (SQLException ex)
            {
                System.out.println("SQLException:" + ex.getMessage());
            }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void closeConnections()
    {
        if(conn != null)
        {
            try 
            {
                conn.close();
            }
            
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public ResultSet queryDB(String sql)
    {
        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try
        {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        }
        
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        return resultSet;
    }
    
    public void UpdateDB(String sql)
    {
        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try 
        {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
        
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
            
    
    
    
    
    
    
}
