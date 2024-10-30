/*
 * This is the DBManager class. This class is used to set up the embedded database.
 * Most of the code estbalished in this class comes directly from the week 8 lab
 */
package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public final class DBManager 
{
    private static final String USERNAME = "pdc";       //DB username   Week 8 lab
    private static final String PASSWORD = "pdc";       //DB password 
    private static final String URL = "jdbc:derby:LeaderBoardDB_Ebd; create=true";   //URL of host, embedded database
    /*
        When you call eg DBManager.getconnection(URL, username, password), derby will connect to leaderboard. If this
        database does not already exist, the create=true; statement will create it
    */
    private Connection conn;
    
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
        return this.getConn();                       
    }

    //Establish connection
    private void establishConnection() 
    {
        //Establish a connection to the database
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            setConn(DriverManager.getConnection(URL, USERNAME, PASSWORD));
            System.out.println(URL + "connected...");         //Print statement 
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database  Driver Error:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        catch (SQLException ex)
            {
                System.out.println("SQLException:" + ex.getMessage());
            }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void closeConnections()
    {
        if(getConn() != null)
        {
            try 
            {
                getConn().close();
            }
            
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public ResultSet queryDB(String sql)
    {
        Connection connection = this.getConn();
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
        Connection connection = this.getConn();
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

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public boolean testConnection() {
    try {
        // Check if connection is valid
        if (conn != null && conn.isValid(2)) { // 2 seconds timeout for validity check
            System.out.println("Connection is valid.");
            return true;
        } else {
            System.out.println("Connection is not valid.");
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Error testing connection: " + e.getMessage());
        return false;
    }
}

}
   
