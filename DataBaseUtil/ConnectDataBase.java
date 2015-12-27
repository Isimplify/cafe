package DataBaseUtil;
import java.sql.*;


public class ConnectDataBase {
	private static String user = "cafe";
	private static String pwd = "12345678";
	private static Statement stmt = null;
	private static ResultSet rs = null;
	synchronized public static ResultSet Select(String SQLstatement) {
		String drivername="com.mysql.jdbc.Driver";
		try{
			Driver driver = null;
			driver = (Driver) Class.forName(drivername).newInstance();
			DriverManager.registerDriver(driver);
			System.out.println("数据库驱动程序"+drivername+"加载成功！");
		}catch (Exception e){
			System.out.println("数据库驱动程序"+drivername+"加载失败！");
			e.printStackTrace();
		}
		try {
		      java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema1",user,pwd);
		      System.out.println("Success connect Mysql server!");
		      stmt = connect.createStatement();
		      rs = stmt.executeQuery(SQLstatement);
		      //connect.close();
		      
		}catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		}
		return rs;
	}
	synchronized public static void Update(String SQLstatement) throws SQLException{
		String drivername="com.mysql.jdbc.Driver";
		try{
			Driver driver = null;
			driver = (Driver) Class.forName(drivername).newInstance();
			DriverManager.registerDriver(driver);
			System.out.println("数据库驱动程序"+drivername+"加载成功！");
		}catch (Exception e){
			System.out.println("数据库驱动程序"+drivername+"加载失败！");
			e.printStackTrace();
		}
		try {
		      java.sql.Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema1",user,pwd);
		      System.out.println("Success connect Mysql server!");
		      stmt = connect.createStatement();
		      stmt.executeUpdate(SQLstatement);
		      //connect.close();
		      		      
		}catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		}
	}
}
