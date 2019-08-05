package _Service_Book;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.BookDAO;
import _DTO.Book;
import _DTO.Review;
import _DTO.ReviewPageMaker;


public class BookInfoService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bDao = BookDAO.getInstance();
		int bno = Integer.parseInt(request.getParameter("no"));
		
		String spage=request.getParameter("page");
		if(spage==null) {
			spage="1";
		}
		int page=Integer.parseInt(spage);
		int totalCount=bDao.getTotalReviewCount(bno);
		ReviewPageMaker pageMaker=new _DTO.ReviewPageMaker(page,totalCount);		
		System.out.println("bookinfoservice.java : startPage : " + pageMaker.getStartPage() + "   endPage : " + pageMaker.getEndPage());

		Book book = bDao.getbook(bno); 
		
		File f = new File("C:/Users/whaks/Desktop/개발/CODE/BusanIT_Project2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Team_Project/upload/"+book.getBookFile());
		System.out.println("aa : " + f.length());
		
		
		List<Review> review=bDao.getReviewPage(pageMaker.getStart(),pageMaker.getPageSize(),bno);

		
		request.setAttribute("reviewlist", review);
		request.setAttribute("ReviewPageMaker", pageMaker);
		request.setAttribute("book", book); 	
		request.setAttribute("size", f.length());
		request.getRequestDispatcher("/book/bookInfo.jsp?no="+bno).forward(request, response);
	}
}