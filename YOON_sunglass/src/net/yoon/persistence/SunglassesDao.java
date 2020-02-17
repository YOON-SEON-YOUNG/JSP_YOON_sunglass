package net.yoon.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.yoon.domain.PagingDto;
import net.yoon.domain.SearchDto;
import net.yoon.domain.SunglassesVo;

public class SunglassesDao {
	
	private static SunglassesDao instance;
	
	private SunglassesDao() { /* singleton*/};
	
	public static SunglassesDao getInstance () {
		if (instance == null) {
			instance = new SunglassesDao();
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
	
	
	// 선글라스 게시글 등록
	public void write(SunglassesVo sunglassesVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into sunglasses"
					+ "				(sunglasses_num, sunglasses_kind, sunglasses_name," 
					+ "				sunglasses_price, sunglasses_count, sunglasses_img,"
					+ "				 sunglasses_content, discount_rate, sunglasses_writer)" 
					+ "		values (seq_sunglasses_num.nextval, ?, ?, " 
					+ "				?, ?, ?,"
					+ "				?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString		(1, sunglassesVo.getSunglasses_kind());
			pstmt.setString		(2, sunglassesVo.getSunglasses_name());
			pstmt.setInt		(3, sunglassesVo.getSunglasses_price());
			pstmt.setInt		(4, sunglassesVo.getSunglasses_count());
			pstmt.setString		(5, sunglassesVo.getSunglasses_img());
			pstmt.setString		(6, sunglassesVo.getSunglasses_content());
			pstmt.setInt		(7, sunglassesVo.getDiscount_rate());
			pstmt.setString		(8, sunglassesVo.getSunglasses_writer());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
	}// 선글라스 게시글 등록
	
		
	// 관리자 상품 리스트 가져오기
	public List<SunglassesVo> getList(PagingDto pagingDto, SearchDto searchDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from"
					+ "    (select rownum rnum, a.* from" 
					+ "        (select * from sunglasses";
			if (!searchDto.getSearchType().equals("") &&
					!searchDto.getKeyword().equals("")) {
				sql += "          where " + searchDto.getSearchType() +
					   "          like '%" + searchDto.getKeyword() + "%'";
			}
			sql +=	"        order by reg_date desc) a)" 
					+ "where rnum >= ? and rnum <= ?";
			
//				String sql = "select * from sunglasses"
//						+ "		order by sunglasses_num desc";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pagingDto.getStartRow());
			pstmt.setInt(2, pagingDto.getEndRow());
			rs = pstmt.executeQuery();
			
			List<SunglassesVo> list = new ArrayList<>();
			while(rs.next()) {
				int 		sunglasses_num 		= rs.getInt("sunglasses_num");
				String 		sunglasses_kind 	= rs.getString("sunglasses_kind");
				String 		sunglasses_name 	= rs.getString("sunglasses_name");
				int			sunglasses_price 	= rs.getInt("sunglasses_price");
				int 		sunglasses_count 	= rs.getInt("sunglasses_count");
				String 		sunglasses_img 		= rs.getString("sunglasses_img");
				String 		sunglasses_content 	= rs.getString("sunglasses_content");
				int 		discount_rate 	 	= rs.getInt("discount_rate");
				Timestamp 	reg_date 			= rs.getTimestamp("reg_date");
				
				SunglassesVo sunglassesVo = new SunglassesVo();
				sunglassesVo.setSunglasses_num(sunglasses_num);
				sunglassesVo.setSunglasses_kind(sunglasses_kind);
				sunglassesVo.setSunglasses_name(sunglasses_name);
				sunglassesVo.setSunglasses_price(sunglasses_price);
				sunglassesVo.setSunglasses_count(sunglasses_count);
				sunglassesVo.setSunglasses_img(sunglasses_img);
				sunglassesVo.setSunglasses_content(sunglasses_content);
				sunglassesVo.setDiscount_rate(discount_rate);
				sunglassesVo.setReg_date(reg_date);
				
				list.add(sunglassesVo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}	// 관리자 상품 리스트 가져오기
		
	
		
	
		
		
		// 상세보기
		public SunglassesVo getContentByNum(int sunglasses_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				String sql = "select * from sunglasses"
						+ "		where sunglasses_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sunglasses_num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String 	sunglasses_kind 	= rs.getString("sunglasses_kind");
					String 	sunglasses_name 	= rs.getString("sunglasses_name");
					int		sunglasses_price 	= rs.getInt("sunglasses_price");
					String 	sunglasses_img 		= rs.getString("sunglasses_img");
					String 	sunglasses_content 	= rs.getString("sunglasses_content");
					String 	sunglasses_writer 	= rs.getString("sunglasses_writer");
					int 	sunglasses_count	= rs.getInt("sunglasses_count");
					Timestamp reg_date 			= rs.getTimestamp("reg_date");
					
					SunglassesVo sunglassesVo = new SunglassesVo();
					sunglassesVo.setSunglasses_num		(sunglasses_num);
					sunglassesVo.setSunglasses_kind(sunglasses_kind);
					sunglassesVo.setSunglasses_name(sunglasses_name);
					sunglassesVo.setSunglasses_price(sunglasses_price);
					sunglassesVo.setSunglasses_img(sunglasses_img);
					sunglassesVo.setSunglasses_content(sunglasses_content);
					sunglassesVo.setSunglasses_writer(sunglasses_writer);
					sunglassesVo.setSunglasses_count(sunglasses_count);
					sunglassesVo.setReg_date(reg_date);
					
					
					return sunglassesVo;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(conn, pstmt, rs);
			}
			
			return null;
		} // 상세보기
		
		
		// 수정하기
		public void update(SunglassesVo sunglassesVo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = getConnection();
				String sql = "update sunglasses set" 
					 	+ 	"    	sunglasses_kind	= ?,"
					 	+	"    	sunglasses_name	 = ?,"
					 	+ 	"    	sunglasses_price	= ?,"
					 	+ 	"    	sunglasses_count	= ?,"
					 	+ 	"    	sunglasses_writer	= ?";
				if (sunglassesVo.getSunglasses_img() != null &&
						!sunglassesVo.getSunglasses_img().equals("")) {
					sql +=	"    	, sunglasses_img = ?";
				}
				sql +=	"			, sunglasses_content = ?"
						+ "	where sunglasses_num = ?";
					
				pstmt = conn.prepareStatement(sql);
				int i = 0;
				pstmt.setString	(++i, sunglassesVo.getSunglasses_kind());
				pstmt.setString	(++i, sunglassesVo.getSunglasses_name());
				pstmt.setInt	(++i, sunglassesVo.getSunglasses_price());
				pstmt.setInt	(++i, sunglassesVo.getSunglasses_count());
				pstmt.setString	(++i, sunglassesVo.getSunglasses_writer());
				if (sunglassesVo.getSunglasses_img() != null &&
						!sunglassesVo.getSunglasses_img().equals("")) {
					pstmt.setString	(++i, sunglassesVo.getSunglasses_img());
				}
				pstmt.setString	(++i, sunglassesVo.getSunglasses_content());
				pstmt.setInt(++i, sunglassesVo.getSunglasses_num());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(conn, pstmt, null);
			}
		} // 수정하기
		
		
		// 이미지 삭제
		public String getImage(int sunglasses_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = getConnection();
				String sql = "select sunglasses_img from sunglasses"
						+ "   where sunglasses_num = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sunglasses_num);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					String sunglasses_img = rs.getString("sunglasses_img");
					return sunglasses_img;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(conn, pstmt, rs);
			}
			return null;
		} // 이미지 삭제
		
		
		// 데이터 삭제
		public boolean delete(int sunglasses_num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = getConnection();
				String sql = "delete from sunglasses"  
						+ "		where sunglasses_num = ?";
				pstmt= conn.prepareStatement(sql);
				pstmt.setInt (1, sunglasses_num);
				
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
		
		
		
		// 조회수
		public int getCount(SearchDto searchDto) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				String sql = "select count(*) from sunglasses";
				if (!searchDto.getSearchType().equals("") &&
						!searchDto.getKeyword().equals("")) {
					sql += "	where " + searchDto.getSearchType() +
							"	like '%" + searchDto.getKeyword() + "%'";
				}
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					int cnt = rs.getInt(1);
					return cnt;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(conn, pstmt, rs);
			}
			return 0;
		}
		
}
