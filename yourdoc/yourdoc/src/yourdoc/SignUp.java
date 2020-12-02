package yourdoc;
import java.sql.*;
public class SignUp
{
   public static void signUp( )
   {
	Connection con=null;
	   Statement stmt=null;
	   ResultSet rs=null;
	   String query=null;
	  try
	   {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","user10","dba_user10");    
	    stmt=con.createStatement();
	    query="insert into customer values(name,password,number)";
	    rs=stmt.executeQuery(query);
	   
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
}
}