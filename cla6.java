import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cla6 {

	public static void main(String[] args) {
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 System.out.println("succeeded");
			 String surl="jdbc:oracle:thin:@localhost:1521:xe";
			 String uname="system";
			 String pass="1234";
			 Connection con=DriverManager.getConnection(surl,uname,pass);
			 System.out.println("succeeded");
			 PreparedStatement stmt=con.prepareStatement("select * from emp");
			 ResultSet rs1=stmt.executeQuery();
				while(rs1.next()) {
					 System.out.println(rs1.getString(1)+" "+rs1.getString("ename"));
				 }
			PreparedStatement pst=con.prepareStatement("select * from emp where sal>1000 and sal<2000");
			 ResultSet rs2=stmt.executeQuery();
			 while(rs2.next()) {
				 System.out.println(rs2.getString(1)+" "+rs2.getString("ename"));
			 }

		 }
		 catch(ClassNotFoundException cnfe) {
			 System.out.println(cnfe);
		 }
		 catch(SQLException se) {
			 System.out.println(se);
		 }
	}

}
