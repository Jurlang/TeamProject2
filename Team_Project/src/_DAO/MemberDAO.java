package _DAO;

import java.sql.*;

import _DTO.Member;

public class MemberDAO {
	private MemberDAO() {}
	
	private static MemberDAO dao = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public int getIdCheck(String id) {
		int col = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from member where u_id = ?";

		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				col = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return col;
	}
	
	public void insertMember(Member m) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into member(uno,u_id,u_pw,u_name,u_birth,u_tel,u_address)  values(mem_seq.nextval, ?,?,?,?,?,?)";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, m.getU_id());
			ps.setString(2, m.getU_pw());
			ps.setString(3, m.getU_name());
			ps.setDate(4, m.getU_birth());
			ps.setString(5, m.getU_tel());
			ps.setString(6, m.getU_address());
			int n = ps.executeUpdate();
			
			if(n != 0) {
				DBConn.commit(conn);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}

	public int loginMember(String id, String pw) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select uno from member where u_id = ? and u_pw = ?";
		int uno = 0;
		
		
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			while (rs.next()) {
				uno = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return uno;
	}

	public Member getMemberInfo(int uno) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Member m = new Member();
		
		String sql = "select * from member where uno=?";
		
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uno);
			rs = ps.executeQuery();
			while (rs.next()) {
				m.setUno(rs.getInt("uno"));
				m.setU_id(rs.getString("u_id"));
				m.setU_pw(rs.getString("u_pw"));
				m.setU_name(rs.getString("u_name"));
				m.setU_birth(rs.getDate("u_birth"));
				m.setU_tel(rs.getString("u_tel"));
				m.setU_address(rs.getString("u_address"));
				m.setU_point(rs.getInt("u_point"));
				m.setU_grade(rs.getInt("u_grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		
		return m;
	}

	public int updateMemberInfo(String id, String pw, String tel, String addr) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int uno = -1;
		String sql = "update member set u_pw=?, u_tel=?, u_address=? where u_id=?";
		String sql2 = "select uno from member where u_id = ?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1,pw);
			ps.setString(2,tel);
			ps.setString(3,addr);
			ps.setString(4,id);
			int n = ps.executeUpdate();
			ps.close();
			
			ps = conn.prepareStatement(sql2);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				uno = rs.getInt("uno");
			}
			if(n != 0 && uno != -1) {
				DBConn.commit(conn);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
		
		return uno;
	}
}