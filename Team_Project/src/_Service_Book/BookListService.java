package _Service_Book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.BookDAO;
import _DTO.Book;
import _DTO.PageMaker;

public class BookListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageCount = request.getParameter("page");
		if (pageCount == null) {
			pageCount = "1";
		}
		int curPage = Integer.parseInt(pageCount);
		
		BookDAO bDao = BookDAO.getInstance();
		
		int totalCount = bDao.getTotalBook(); 
		PageMaker pm = new PageMaker(curPage, totalCount);

		List<Book> list = bDao.bookSelectPage(pm.getStart(), pm.getPageSize());
		request.setAttribute("bookList", list);
		request.getRequestDispatcher("/book/bookList.jsp").forward(request, response);
	}

}
