package dc.human.kimbanbagi.tableJava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dc.human.kimbanbagi.tableJava.common.DBConnectionManager;
import dc.human.kimbanbagi.tableJava.dto.*;


public class LoginDAO {
	private Connection conn;
	
	public String match(String uid, String pw) {
		String id=uid;
		String pwd=pw;
		
		String result = "";
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "SELECT COUNT(*) AS cnt FROM users WHERE user_id=? AND user_pwd=?"; 
			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int cnt=rs.getInt("cnt");
				
				// 로그인 정보 대조 성공
				if(cnt==1) {
					result = getRole(id);
					
				// 로그인 정보 대조 실패
				}else {
					System.out.println("정보를 찾지못했습니다.");
				}
			}
			
			conn.close();
			pstmt.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// user_role( 사용자 or 사장님 )과 store_register(식당 등록 여부) 확인하는 메소드
	public String getRole(String id) {
		String role="";
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql= "SELECT user_role FROM users WHERE user_id=?";
			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs=pstmt.executeQuery();
			
			 while (rs.next()) {
				 role = rs.getString("user_role");
			 }
			
			 conn.close();
			 pstmt.close();
			 rs.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 return role;
	}
	
	// 식당 등록 여부 확인하는 메소드
	public boolean getRegister(String id) {
		boolean result = false;
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "SELECT store_register FROM users WHERE user_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String reg = rs.getString("store_register");
				if(reg.equals("1")) result=true; 
			}
			
			conn.close();
			pstmt.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// restaurant_id 얻는 메소드
	public String getRid(String id) {
		String rId="";
		
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "SELECT restaurant_id FROM restaurants WHERE user_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rId = rs.getString("restaurant_id");
			}
			
			conn.close();
			pstmt.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rId;
	}

}
