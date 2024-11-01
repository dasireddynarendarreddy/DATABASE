package DBPRACTICE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TASK3 {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@//localhost:1521/orcl";
		String username="system";
		String password="tiger";
		Connection connection=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection(url,username,password);
			Statement statement = connection.createStatement();
			String sql="SELECT * FROM sample";
		String del="DELETE FROM sample WHERE NAME=? AND ID=? ";
		String update="UPDATE sample SET NAME= ? WHERE id = ?";
		PreparedStatement std=connection.prepareStatement(update);
		std.setString(1,"newman");
		std.setInt(2, 3456);
		std.executeUpdate();
			ResultSet set=statement.executeQuery(sql);
			
			PreparedStatement st=connection.prepareStatement(del);
		 st.setString(1, "new one");
		 st.setInt(2, 55);
			st.executeUpdate();
		    System.out.println("no of rows deleted:"+st.getLargeUpdateCount());
		    
			System.out.println("row deleted");
			while (set.next()) {
                
	        	  System.out.print("ID: \t" + set.getString("id"));
	        	  System.out.print("  ");
	        	  System.out.print("Name: \t" + set.getString("name"));
	        	  System.out.println("");
	             
	              
	            }
			set.close();
	         statement.close();
	         connection.close();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		 
            try {
				System.out.println(connection.isClosed());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
