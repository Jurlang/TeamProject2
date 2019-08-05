package _DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import _DTO.Book;
import _DTO.BuyList;
import _DTO.CartList;
import _DTO.Review;

public class BookDAO {
	private BookDAO() {}
	private static BookDAO dao = new BookDAO();
	
	public static BookDAO getInstance() {
		return dao;
	}
	
	public void bookInsert(Book book) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into book(no, name, genre, writer, publish, content, price, imgfile, bookfile) "
						 + "values(book_seq.nextval, ?, ?, ?,?,?,?,?,?)";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getName());
			ps.setString(2, book.getGenre());
			ps.setString(3, book.getWriter());
			ps.setString(4, book.getPublish());
			ps.setString(5, book.getContent());
			ps.setInt(6, book.getPrice());
			ps.setString(7, book.getImgFile());
			ps.setString(8, book.getBookFile());
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
	
	public List<Book> bookSelectAll() {
		List<Book> list = new ArrayList<Book>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from book order by no";

		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
					Book book = new Book();
					book.setNo(rs.getInt("no"));
					book.setName(rs.getString("name"));
					book.setGenre(rs.getString("genre"));
					book.setWriter(rs.getString("writer"));
					book.setPublish(rs.getString("publish"));
					book.setContent(rs.getString("content"));
					book.setRead_count(rs.getInt("read_count"));
					book.setReply_count(rs.getInt("reply_count"));
					book.setPrice(rs.getInt("price"));
					book.setScore(rs.getInt("score"));
					book.setBuyCount(rs.getInt("buycount"));
					book.setImgFile(rs.getString("imgfile"));
					book.setBookFile(rs.getString("bookfile"));
					list.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return list;
	}

	public List<Book> bookSelectTop(){
		List<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select ";

		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		
		return list;
	}
	
	public List<Book> bookSelectPage(int start, int pageSize){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="select * from "
				+"(select rownum as rn,  a.* "
				+"from (select * from book order by no) a "
				+"where rownum<=?)b "
				+"where b.rn>=?";
		List<Book> blist = new ArrayList<Book>();
		
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start+pageSize);
			ps.setInt(2, start+1);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				book.setNo(rs.getInt("no"));
				book.setName(rs.getString("name"));
				book.setGenre(rs.getString("genre"));
				book.setWriter(rs.getString("writer"));
				book.setPublish(rs.getString("publish"));
				book.setContent(rs.getString("content"));
				book.setRead_count(rs.getInt("read_count"));
				book.setReply_count(rs.getInt("reply_count"));
				book.setPrice(rs.getInt("price"));
				book.setScore(rs.getInt("score"));
				book.setBuyCount(rs.getInt("buycount"));
				book.setImgFile(rs.getString("imgfile"));
				book.setBookFile(rs.getString("bookfile"));
				blist.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return blist;
	}
	
	public List<String> bookSelectGenre(){
		List<String> genreArr = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select distinct genre from book";

		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String genre = rs.getString(1);
				genreArr.add(genre);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		
		return genreArr;
	}

	public int getTotalBook() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from book";
		int count = -1;
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {	
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return count;
	}
	
	public Book getbook(int bookno) {
		
		Book book=null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from book where no=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookno);
			rs = ps.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				book=new Book();
				book.setNo(rs.getInt("no"));
				book.setName(rs.getString("name"));
				book.setGenre(rs.getString("genre"));
				book.setWriter(rs.getString("writer"));
				book.setPublish(rs.getString("publish"));
				book.setContent(rs.getString("content"));
				book.setRead_count(rs.getInt("read_count"));
				book.setReply_count(rs.getInt("reply_count"));
				book.setPrice(rs.getInt("price"));
				book.setScore(rs.getInt("score"));
				book.setBuyCount(rs.getInt("buycount"));
				book.setImgFile(rs.getString("imgfile"));
				book.setBookFile(rs.getString("bookfile"));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		System.out.println(book);
		return book;

	}

	public void getBookbuy(int uno, int bno) {
	Connection conn = null;
	PreparedStatement ps = null;
	String sql = "insert into buylist(uno,no,currdate)"
					 + "values(?,?,SYSDATE)";
	try {
		conn = DBConn.getConnect();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, uno);
		ps.setInt(2, bno);
		int n = ps.executeUpdate();
		
		if(n != 0) {
			DBConn.commit(conn);
			System.out.println("구매완료");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBConn.close(ps);
		DBConn.close(conn);
	}
}

	public int getUserPoint(String u_id) { 	//세션에 있는 유저 아이디

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select u_point from member where u_id=?";
		int n = 0;
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u_id);
			System.out.println();
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				n = rs.getInt(1);
			}

			//member = new member();
			//member.setU_point(rs.getInt(1));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return n;
		
	}

	public void getBuy(int bprice, String u_id) {	//유저 아이디와 책 가격을 가져옴 
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "update member set u_point="
				+ "u_point-? "
				+ "where u_id=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bprice);
			ps.setString(2, u_id);
			int n = ps.executeUpdate();
			if(n==1) {
				DBConn.commit(conn);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBConn.close(ps);

			DBConn.close(conn);
		}
	}
	
	public int getuno(String u_id) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select uno from member where u_id=?";
		int n=0;
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u_id);
			
			rs = ps.executeQuery();
			while(rs.next()){
				n = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBConn.close(ps);

			DBConn.close(conn);
		}
		return n;
	}
	
	public List<BuyList> buylistSelectAll(int uno) {	 //회원번호로 구매한책,날짜가져옴
		List<BuyList> buylist = new ArrayList<BuyList>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select b.imgfile, b.name, b.bookfile, m.u_name, l.currdate, b.genre, b.price, b.publish from book b, member m, buylist l where l.no = b.no and m.uno = l.uno and l.uno = ?";

		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uno);
			
			rs = ps.executeQuery();
			while (rs.next()) {
					BuyList book = new BuyList();
					book.setImgfile(rs.getString("imgfile"));
					book.setName(rs.getString("name"));
					book.setBookfile(rs.getString("bookfile"));
					book.setU_name(rs.getString("u_name"));
					book.setCurrdate(rs.getDate("currdate"));
					book.setGenre(rs.getString("genre"));
					book.setPrice(rs.getInt("price"));
					book.setPublish(rs.getString("publish"));
					File f = new File("C:/Users/whaks/Desktop/개발/CODE/BusanIT_Project2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Team_Project/upload/"+rs.getString("bookfile"));
					book.setBooksize((int) f.length());
					buylist.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return buylist;
	}
	
	public List<CartList> BasketlistSelectAll(int uno) {	 //찜 목록 에서  표현해줄 데이터값.
		List<CartList> cartlist = new ArrayList<CartList>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select b.imgfile, b.name, b.bookfile, m.u_name, l.currdate, b.genre, b.price, b.publish from book b, member m, cartlist l where l.no = b.no and m.uno = l.uno and l.uno = ?";

		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uno);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
					CartList book = new CartList();
					
					book.setImgfile(rs.getString("imgfile"));
					book.setName(rs.getString("name"));
					book.setBookfile(rs.getString("bookfile"));
					book.setU_name(rs.getString("u_name"));
					book.setCurrdate(rs.getDate("currdate"));
					book.setGenre(rs.getString("genre"));
					book.setPrice(rs.getInt("price"));
					book.setPublish(rs.getString("publish"));
					File f = new File("C:/Users/whaks/Desktop/개발/CODE/BusanIT_Project2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Team_Project/upload/"+rs.getString("bookfile"));
					book.setBooksize((int) f.length());
					cartlist.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return cartlist;
	}
	
	public void getCartInsert(int uno,int no) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql =  "insert into cartlist(uno,no,currdate)"
				 + "values(?,?,SYSDATE)";
		
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uno);
			ps.setInt(2, no);
			int n = ps.executeUpdate();
			
			if(n!=0) {
				DBConn.commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
	
	public int bookReviewInsert(int uno, int no, String u_id, String r_content,int score) {	//리뷰 등록후 업데이트해줘야할 그책의 평균값 리턴
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		Connection conn2 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		
		int n = 0;
		int avg=0;
		
		String sql =  "insert into review(rno,uno,no,u_id,r_content,r_date,score)"
				 + "values(rno_seq.nextval,?,?,?,?,SYSDATE,?)";
		
		String sql2 = "select avg(score) from review where no=?";
			
		try {

			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uno);
			ps.setInt(2, no);
			ps.setString(3, u_id);
			ps.setString(4, r_content);
			ps.setInt(5, score);
			n = ps.executeUpdate();
			

			if(n==1) {//insert 성공했을시에 평균값 구하기 시작
				System.out.println("책 리뷰등록 성공하였습니다.");
				DBConn.commit(conn);
				conn2 = DBConn.getConnect();
				ps2 = conn2.prepareStatement(sql2);
				ps2.setInt(1, no);
				rs = ps2.executeQuery();
				
				while(rs.next()){
					avg = rs.getInt(1);
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}

		return avg;
	}
	
	public void bookScore(int avg, int no) {	// 업데이트를 해줘야할 평균값과 그 책번호를 가지고 업데이트함 
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "update book set score=? where no=?";
		
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, avg);
			ps.setInt(2, no);
			int n = ps.executeUpdate();
			if(n!=0) {
				System.out.println("등록하신 책 점수가 평균으로 반영되었습니다");
				DBConn.commit(conn);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBConn.close(ps);
			DBConn.close(conn);
		}
	}
		
	public List<Review> getReview(int bno) { //bno로 책 번호를 넣어서 그 책의 리뷰를 꺼내기 
		
		List<Review> list = new ArrayList<Review>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from review where no=? order by r_date";

		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			
			rs = ps.executeQuery();
			while (rs.next()) {
					Review review = new Review();
					review.setRno(rs.getInt("rno"));
					review.setUno(rs.getInt("uno"));
					review.setNo(rs.getInt("no"));
					review.setU_id(rs.getString("u_id"));
					review.setR_content(rs.getString("r_content"));
					review.setR_date(rs.getDate("r_date"));
					review.setScore(rs.getInt("score"));
					list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return list;
	}

	public int getTotalReviewCount(int no) {
		int n=0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from review where no=?";
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			while (rs.next()) {
				n=rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return n;
	}
	
	public List<Review> getReviewPage(int start, int size,int no){
		List<Review> list=new ArrayList<Review>();
		Connection conn = null;	
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		String sql="select * from "
		+"(select rownum as rn, "
		+"a.* "
		+"from (select * from review where no=? order by r_date desc) a "
		+"where rownum<=?)b "
		+"where b.rn>=?" ;
		
		try {
			conn = DBConn.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setInt(2, start+size);
			ps.setInt(3, start+1);
			rs = ps.executeQuery();
			while (rs.next()) {
				Review review = new Review();
				review.setRno(rs.getInt("rno"));
				review.setUno(rs.getInt("uno"));
				review.setNo(rs.getInt("no"));
				review.setU_id(rs.getString("u_id"));
				review.setR_content(rs.getString("r_content"));
				review.setR_date(rs.getDate("r_date"));
				review.setScore(rs.getInt("score"));
				list.add(review);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(rs);
			DBConn.close(ps);
			DBConn.close(conn);
		}
		return list;
	}
	
}
