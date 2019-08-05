package _Service_Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.BookDAO;
import _Service_Book.Service;

public class MemberMyCartSelect implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub찜하기를 눌렀을때 
		int uno=Integer.parseInt(request.getParameter("uno"));	
		int no=Integer.parseInt(request.getParameter("bno"));
		BookDAO bDao = BookDAO.getInstance();
			
		bDao.getCartInsert(uno,no);
		
		response.sendRedirect("bookInfo.do?no="+no);
	}

}
