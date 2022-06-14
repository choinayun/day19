package day19;

import java.sql.*;
import java.util.ArrayList;

public class DBClass {
	
	// ������ �ϱ����� ��ü 
	Connection con;
	// �����ͺ��̽��� ��ɾ�(������)�� �����ϱ� ���� ��ü
	PreparedStatement ps; 
	// select�� ��� ���� �ޱ� ���� ��ü 
	ResultSet rs; 
	
	public DBClass() {
		
		System.out.println("������ ����");
		
		try { // �ڹٿ��� ����Ŭ ��ɾ �����ϱ� ���� ����� ����ϴ� ���� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// ����Ŭ�� �����ϴ� ����
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "java2", "1234");
									// ��ȣ�ȿ�(url, ����Ŭ����, ��й�ȣ)
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int insert(Info info) {
		
		String sql = "insert into newst values(?, ?, ?)"; 
		
		int result = 0;
		
		try { 
			// ����� ��ü�� �̿��ؼ� ��ɾ� ���۰�ü�� ���´� 
			ps = con.prepareStatement(sql);
			
			// ? �ڸ��� �� ���� ä���ִ� ���� 
			ps.setString(1, info.getId());
			ps.setString(2, info.getName());
			ps.setInt(3, info.getAge());
			
			// ��ɾ �����ϰڴٴ� �ǹ�
			// executeUpdate : ���� select�� ������ �������� ���
			// �����̸� 1, ���и� 0 �Ǵ� ���� (return �� : int ���� / sql developer ���� Ȯ�� ����)
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return result;
	}
	
	public Info selectOne(String id) {
		
		String sql = "select * from newst where id = '"+id+"'";
		
		Info info = null;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) { // �����Ͱ� ������ true , ������ false
				
				info = new Info(); 
				
				info.setId(rs.getString("id"));
				info.setName(rs.getString("name"));
				info.setAge(rs.getInt("age"));
				
				// ������ ������� ���ο��� 
				// System.out.println(rs.getString("id"));
				// System.out.println(rs.getString("name"));
				// System.out.println(rs.getInt("age"));		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
		
	}
	
	public ArrayList<Info> select() {
		
		String sql = "select * from newst"; // �������� �����ͺ��̽����� ���� �ȳ����� Ȯ���غ��� ���� 
		
		ArrayList<Info> list = new ArrayList<Info>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Info info = new Info();
				
				info.setId(rs.getString("id"));
				info.setName(rs.getString("name"));
				info.setAge(rs.getInt("age"));
				
				list.add(info);
				
				// System.out.println(rs.getString("id"));
				// System.out.println(rs.getString("name"));
				// System.out.println(rs.getInt("age"));
				// System.out.println("----------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}














