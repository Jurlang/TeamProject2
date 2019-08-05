package _Service_Member;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.BookDAO;
import _DTO.Book;
import _DTO.BuyList;
import _DTO.CartList;
import _Service_Book.Service;

public class MemberMyCartListForm implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uno=Integer.parseInt(request.getParameter("uno"));	 //받음
		BookDAO bDao = BookDAO.getInstance();
		
		
		List<CartList> list = bDao.BasketlistSelectAll(uno);
		
		request.setAttribute("cartList",  list);
		request.getRequestDispatcher("book/bookCartList.jsp").forward(request, response);	
		
		
	}
}
