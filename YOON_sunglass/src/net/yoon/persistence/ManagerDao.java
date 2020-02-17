package net.yoon.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.yoon.domain.ManagerLoginDto;
import net.yoon.domain.ManagerVo;

public class ManagerDao {
	
	private static ManagerDao instance;
	
	private ManagerDao() {/*singleton*/}
	
	public static ManagerDao getInstance () {
		if (instance == null) {
			instance = new ManagerDao();
		}
		return instance;
		
	}
	
	
	private Connection getConnection() {
		
		try {
			// javax.naming.Context, javax.naming.InitialContext
			Context context = new InitialContext();
			
			// javax.sql.DataSource
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oraclexe");
			//-> 커넥션  풀 참조 얻기
			
			Connection conn = ds.getConnection();
			//-> 커넥션 풀에서 이미 생성된 커넥션 객체 얻기
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (conn != null) 	try { conn.close(); }	catch (Exception e) { }
		if (pstmt != null) 	try { pstmt.close(); }	catch (Exception e) { }
		if (rs != null) 	try { rs.close(); }		catch (Exception e) { }
	}
	
	
	// 관리자 인증 체크
	public boolean checkManager(ManagerLoginDto managerLoginDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select count(*) from manager" + 
					"		where manager_id = ? and manager_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, managerLoginDto.getManager_id());
			pstmt.setString(2, managerLoginDto.getManager_pw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					return true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return false;
	}// 관리자 인증 체크
		
		
	// 관리자 추가
	public boolean insertManager(ManagerVo managerVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into tbl_member(manager_id, manager_pw, manager_name)" + 
					"		values (?, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, managerVo.getManager_id());
			pstmt.setString(2, managerVo.getManager_pw());
			pstmt.setString(3, managerVo.getManager_name());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	} // 관리자 추가
	
	
	// 중복처리
	public boolean checkDupManagerId(String manager_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select count(*) from manager"
					+ "		where manager_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, manager_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if(count > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return false;
	} // 중복처리

}
