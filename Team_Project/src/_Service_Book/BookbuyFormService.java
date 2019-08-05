package _Service_Book;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.BookDAO;
import _DTO.Book;



public class BookbuyFormService implements Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bno=Integer.parseInt(request.getParameter("bno"));	//책넘버 잘받구  
		BookDAO bDao=BookDAO.getInstance();	
		Book book=bDao.getbook(bno); 
		File f = new File("C:/Users/whaks/Desktop/개발/CODE/BusanIT_Project2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Team_Project/upload/"+book.getBookFile());

		request.setAttribute("book", book);
		request.setAttribute("size", f.length());

		request.getRequestDispatcher("/book/bookBuy.jsp")
		.forward(request, response);
	}

}
