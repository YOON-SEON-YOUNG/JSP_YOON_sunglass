package net.yoon.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.yoon.domain.ReviewVo;

public class ReviewDao {
	
	private static ReviewDao instance;
	
	private ReviewDao() {/*singleton*/}
	
	public static ReviewDao getInstance () {
		if (instance == null) {
			instance = new ReviewDao();
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
	
	
	// 글쓰기
	public void write(ReviewVo reviewVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into tbl_review(review_num, review_subject, review_content, review_writer," 
					+ "                    review_ref, review_filename)"
					+ "		values (seq_review_num.nextval, ?, ?, ?,"
					+ "         ?, seq_review_num.nextval, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewVo.getReview_subject());
			pstmt.setString(2, reviewVo.getReview_content());
			pstmt.setString(3, reviewVo.getReview_writer());
			pstmt.setString(5, reviewVo.getReview_filename());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
	}	//글쓰기
	
	
	// 목록 가져오기
	public List<ReviewVo> getReviewList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from tbl_review"
					+ "		order by review_num desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			List<ReviewVo> list = new ArrayList<>();
			while(rs.next()) {
				int 	review_num = rs.getInt("review_num");
				String 	review_subject 	 	= rs.getString("review_subject");
				String 	review_content 	 	= rs.getString("review_content");
				String 	review_writer 	 	= rs.getString("review_writer");
				int 	review_read_count 	= rs.getInt("review_read_count");
				int 	review_ref 		 	= rs.getInt("review_ref");
				int 	review_re_step 	 	= rs.getInt("review_re_step");
				int 	review_re_level 	= rs.getInt("review_re_level");
				Timestamp review_reg_date 	= rs.getTimestamp("review_reg_date");
				String 	review_filename 	= rs.getString("review_filename");
				
				ReviewVo reviewVo = new ReviewVo();
				reviewVo.setReview_num			(review_num);
				reviewVo.setReview_subject		(review_subject);
				reviewVo.setReview_content		(review_content);
				reviewVo.setReview_writer		(review_writer);
				reviewVo.setReview_read_count	(review_read_count);
				reviewVo.setReview_ref			(review_ref);
				reviewVo.setReview_re_step		(review_re_step);
				reviewVo.setReview_re_level		(review_re_level);
				reviewVo.setReview_reg_date		(review_reg_date);
				reviewVo.setReview_filename		(review_filename);
				
				list.add(reviewVo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}	// 목록 가져오기
	
	
	
	
	// 상세보기
	public ReviewVo getReviewContentByNum(int review_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from tbl_review"
					+ "		where review_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String 	review_subject 	 	= rs.getString("review_subject");
				String 	review_content 		= rs.getString("review_content");
				String 	review_writer 	 	= rs.getString("review_writer");
				int 	review_read_count 	= rs.getInt("review_read_count");
				int 	review_ref 		 	= rs.getInt("review_ref");
				int 	review_re_step 		= rs.getInt("review_re_step");
				int 	review_re_level 	= rs.getInt("review_re_level");
				Timestamp review_reg_date 	= rs.getTimestamp("review_reg_date");
				String 	review_filename 	= rs.getString("review_filename");
				
				
				ReviewVo reviewVo = new ReviewVo();
				reviewVo.setReview_num			(review_num);
				reviewVo.setReview_subject		(review_subject);
				reviewVo.setReview_content		(review_content);
				reviewVo.setReview_writer		(review_writer);
				reviewVo.setReview_read_count	(review_read_count);
				reviewVo.setReview_ref			(review_ref);
				reviewVo.setReview_re_step		(review_re_step);
				reviewVo.setReview_re_level		(review_re_level);
				reviewVo.setReview_reg_date		(review_reg_date);
				reviewVo.setReview_filename		(review_filename);
				
				return reviewVo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return null;
	} // 상세보기
	
	
	// 수정하기
	public void update(ReviewVo reviewVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "update tbl_review set" 	+ 
					"   	review_writer = ?," 		+ 
					"    	review_subject = ?," 	+ 
					"    	review_content = ?";
			if (reviewVo.getReview_filename() != null &&
					!reviewVo.getReview_filename().equals("")) {
				sql +=	"    	, review_filename = ?";
			}
			sql +=	"	where review_num = ?";
				
			pstmt = conn.prepareStatement(sql);
			int i = 0;
			pstmt.setString(++i, reviewVo.getReview_writer());
			pstmt.setString(++i, reviewVo.getReview_subject());
			pstmt.setString(++i, reviewVo.getReview_content());
			if (reviewVo.getReview_filename() != null &&
					!reviewVo.getReview_filename().equals("")) {
				pstmt.setString	(++i, reviewVo.getReview_filename());
			}
			pstmt.setInt(++i, reviewVo.getReview_num());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
	} // 수정하기
	
	
	// 이미지 삭제
	public String getReviewFilename(int review_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select review_filename from tbl_review"
					+ "   where review_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String review_filename = rs.getString("review_filename");
				return review_filename;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	} // 이미지 삭제
	
	
	// 데이터 삭제
	public boolean delete(int review_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "delete from tbl_review"  
					+ "		where review_num = ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt	(1, review_num);
			
			int count = pstmt.executeUpdate();
			if(count > 0) {
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	} // 데이터 삭제
	
	
	// 답글달기
	public void reply(ReviewVo reviewVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into tbl_review(review_num, review_subject, review_content, review_writer, review_ref, review_filename) " + 
					"	values (seq_review_num.nextval, ?, ?, ?, seq_review_num.nextval, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString	(1, reviewVo.getReview_subject());
			pstmt.setString	(2, reviewVo.getReview_content());
			pstmt.setString	(3, reviewVo.getReview_writer());
			pstmt.setString	(5, reviewVo.getReview_filename());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
	} // 답글달기
	
	
}
