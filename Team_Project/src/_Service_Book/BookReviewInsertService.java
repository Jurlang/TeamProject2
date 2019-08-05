package _Service_Book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.BookDAO;
import _DTO.Member;
import _DTO.Review;

public class BookReviewInsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			BookDAO bDao = BookDAO.getInstance();	
			int bookavg = -1;	//insert 후에 업데이트 해줘야할 값을 비교하기위해 초기값설정
			
			
			int uno=Integer.parseInt(request.getParameter("uno")); //유저 아이디
			int no=Integer.parseInt(request.getParameter("no")); //책 번호
			String u_id = request.getParameter("u_id"); // 유저아이디
			String r_content = request.getParameter("r_content"); // 리뷰 내용
			String scorestr = request.getParameter("score");
			String scorestr2 = scorestr.substring(0, 1);
			
			int score = Integer.parseInt(scorestr2); //리뷰 점수
			
			System.out.println(uno+no+u_id+r_content+score);
			
			
			
		
			bookavg  = bDao.bookReviewInsert(uno,no,u_id,r_content,score); //insert 후에 그 책에 평균값을 리턴받는  n 은 그 책의 평균점수
			if(bookavg!=-1) {	//n이라는 숫자가 insert 성공후에 평균값을 가지고왔을시에
				bDao.bookScore(bookavg,no);
	
			}
			int ab = 1;
			
			PrintWriter re = response.getWriter();
			re.println(ab);

			
	}
	

}
