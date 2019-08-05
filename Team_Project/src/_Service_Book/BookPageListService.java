package _Service_Book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.BookDAO;
import _DTO.Book;
import _DTO.PageMaker;

public class BookPageListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  spage = request.getParameter("page");		// 시작 페이지를 받아온다
	      if(spage == null) {
	         spage="1";
	      }																							// 시작페이지가 없으면 spage를 1 로 둔다 ( 방금 켜진 페이지가 1 이라는 증거 ) 
	      int page = Integer.parseInt(spage);							// 만약 spage를 받아왓으면 string 형이기때문에 int로 바꿔준다
	      BookDAO bDao = BookDAO.getInstance();			// 인스턴스 생성
	      int totalCount = bDao.getTotalBook();					// 총 갯수를 샌다
	      PageMaker pageMaker = new PageMaker(page, totalCount);	// pagemaker 클래스 생성 생성자 : 스타트 페이지와 총 게시물 갯수
	      List<Book> bookList = bDao.bookSelectPage(pageMaker.getStart(), pageMaker.getPageSize()); 
	      // 게시판에 보여줄 페이지를 출력 ( 시작 페이지와 페이지에 출력할 게시물 크기 사이즈 )
	      request.setAttribute("bookList", bookList);	// 페이지 리스트 출력
	      request.setAttribute("pageMaker", pageMaker);	// pagemaker 클래스 같이 넘김
	      request.getRequestDispatcher("/book/bookList.jsp?page="+page).forward(request, response); // 리스트 출력
	}
}
