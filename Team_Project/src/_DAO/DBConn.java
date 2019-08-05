package _DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {
	
//■■■■■■■■■■■■■■ CONNECTION ■■■■■■■■■■■■■■■
	public static Connection getConnect() {
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();												//컨텍스트를 하나 초기화 해서 얻는다.
			Context envContext  = (Context)initContext.lookup("java:/comp/env"); 	// 자바 컴파일 환경인 컨텍스트를 하나 얻는다.
			DataSource ds = (DataSource)envContext.lookup("jdbc/oracle_db");		// 디비에 연결하는 소스를 들고온다.
			conn = ds.getConnection();
			conn.setAutoCommit(false); // 자동으로 commit이 되는 것을 막는다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
//■■■■■■■■■■■■■■ CONNECTION ■■■■■■■■■■■■■■■

//■■■■■■■■■■■■■■ CLOSE ■■■■■■■■■■■■■■■
	public static void close(Connection conn) {
		try {
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement ps) {
		try {
			ps.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//■■■■■■■■■■■■■■ CLOSE ■■■■■■■■■■■■■■■

	
//■■■■■■■■■■■■■■ COMMIT & ROLLBACK■■■■■■■■■■■■■■■
	public static void commit(Connection conn) {
		try {
			conn.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//■■■■■■■■■■■■■■ COMMIT & ROLLBACK■■■■■■■■■■■■■■■

}
