package yourdoc;
import java.sql.*;
public class Login 
{ 
    public static boolean logIn(String userName,String passWord)
	
    {
       Connection con=null;
       Statement stmt=null;
	   ResultSet rs=null;
	   String query=null;
	  try
	   {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","lenovo","1234");    
	    stmt=con.createStatement();
	    query="select name,passWord from customer where name=userName";
	    rs=stmt.executeQuery(query);
	    while(rs.next())
	     {
	      String name=rs.getString(1);
	      String pass=rs.getString(2);
	      
          if(name==userName && pass==passWord)
          {
        	 return true;
          }
          
          else
          {
        	  return false;
          }
	     
	     }
	   }//try
	   catch(ClassNotFoundException e)
	    {e.printStackTrace();}
	   catch(SQLException e) 
	     { e.printStackTrace();}
	   finally
	    {
	      try
	       {
	        if(stmt!=null)
	          stmt.close();
	        if(rs!=null)
	          rs.close();
	        if(con!=null)
	          con.close();
	       }
	      catch(SQLException e){e.printStackTrace();}
	    }
	return false;
}
}