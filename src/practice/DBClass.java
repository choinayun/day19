package practice;

import java.sql.*;

public class DBClass {

	Connection con;
	
	PreparedStatement ps;
	
	ResultSet rs;
	
	public DBClass() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "java2", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insert(Info info) {
	
		String sql = "insert into list vlaues(?,?,?)";
		
		int result = 0;
			
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, info.getName());
			ps.setInt(2, info.getBirth());
			ps.setString(3, info.getHobby());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Info selectOne(String name) {
		
		String sql = "select * from list where name = ? ";
		
		Info info = null;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) { 
				
				info = new Info();
				
				info.setName(rs.getString("name"));
				info.setBirth(rs.getInt("brith"));
				info.setHobby(rs.getString("hobby"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
	
	public void select() {
		
	}
	
}
