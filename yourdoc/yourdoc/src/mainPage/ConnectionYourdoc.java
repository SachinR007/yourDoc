package mainPage;
import java.sql.*;
public class ConnectionYourdoc {
	
	 
	 public static Connection conn()
	  {	  try
	   {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","lenovo","1234");    
	    return con ;
	   }
	  catch(ClassNotFoundException e)
	    {e.printStackTrace();}
	   catch(SQLException ae) 
	     { ae.printStackTrace();}
	  return null;

}
}