package _Service_Book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.BookDAO;
import _DAO.MemberDAO;
import _DTO.Member;



public class BookbuyService implements Service {	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String u_id= request.getParameter("u_id");	//유저번호 세션으로 끌고올값
		int bno=Integer.parseInt(request.getParameter("bno"));	//책넘버
		int bprice=Integer.parseInt(request.getParameter("bprice")); // 책 포인트

		BookDAO bDao=BookDAO.getInstance();
		
		int uno = bDao.getuno(u_id); 	//세션의 아이디값으로 uno를 구함
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★"+uno);
		int upoint = bDao.getUserPoint(u_id); 	// 유저 포인트 ()안에는 유저 번호 들어가야함 
		System.out.println(upoint);
		System.out.println(bprice);
		
		String buy;
		if(upoint<bprice){
			buy = "bad";
			request.setAttribute("buy", buy);
			request.getRequestDispatcher("bookbuyform.do?bno="+bno).forward(request, response);
		}
		else if(upoint>bprice){
			buy = "good";
			bDao.getBuy(bprice,u_id);
			
			
			bDao.getBookbuy(uno,bno); // 구매완료후에 회원의 구매목록 테이블에 데이터가 들어감.
			request.setAttribute("buy", buy);
			request.getRequestDispatcher("bookbuyform.do?bno="+bno).forward(request, response);
		}		
	}
}





