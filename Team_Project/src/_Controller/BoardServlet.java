package _Controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _Service_Book.BookInfoService;
import _Service_Book.BookInsertFormService;
import _Service_Book.BookInsertService;
import _Service_Book.BookListService;
import _Service_Book.BookMainService;
import _Service_Book.BookPageListService;
import _Service_Book.BookReviewInsertService;
import _Service_Book.BookbuyFormService;
import _Service_Book.BookbuyService;
import _Service_Book.Service;
import _Service_Member.MemberBuyListForm;
import _Service_Member.MemberIDCHKService;
import _Service_Member.MemberJoinFormService;
import _Service_Member.MemberJoinService;
import _Service_Member.MemberLoginService;
import _Service_Member.MemberMyPageService;
import _Service_Member.MemberMyPageUpdateFormService;
import _Service_Member.MemberMyPageUpdateService;
import _Service_Member.MemberMyCartListForm;
import _Service_Member.MemberMyCartSelect;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("*.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Service service = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		// URL = 프로토콜 + 도메인
		// URI = 실제 리소스가 있는 곳 ( 파일명이 있는 경로 )
		String contextPath = request.getContextPath();
		// 현재 프로젝트 만들면 나오는 경로
		String command = requestURI.substring(contextPath.length() );
		// 전체 URI 에서 contextPath를 빼면 ㅇㅇ.do 가 나온다.
		
		if(command.contentEquals("/bookMain.do")) {
			service = new BookMainService();
		} else if(command.equals("/bookInsertForm.do")) {
			service = new BookInsertFormService();
		} else if(command.contentEquals("/bookInsert.do")) {
			service = new BookInsertService();
		} else if(command.equals("/bookList.do")) {
			service = new BookListService();
		} else if(command.contentEquals("/memberJoinForm.do")) {
			service = new MemberJoinFormService();
		} else if(command.contentEquals("/memberJoin.do")) {
			service = new MemberJoinService();
		} else if(command.contentEquals("/memberIDCK.do")) {
			service = new MemberIDCHKService();
		} else if(command.equals("/bookbuy.do")) {
			service = new BookbuyService();
		} else if(command.equals("/bookbuyform.do")) {
			service = new BookbuyFormService();
		} else if(command.equals("/bookInfo.do")) {
			service = new BookInfoService();
		} else if(command.contentEquals("/memberMyPage.do")) {
			service = new MemberMyPageService();
		}else if(command.equals("/memberMyPageUpdateForm.do")) {
			service = new MemberMyPageUpdateFormService();
		} else if(command.contentEquals("/memberMyPageUpdate.do")) {
			service = new MemberMyPageUpdateService();
		} else if(command.contentEquals("/memberBuyListForm.do")) {
			service = new MemberBuyListForm();
		} else if(command.contentEquals("/myCartForm.do")) {//메인화면에서 찜목록 눌럿을때 
			service = new MemberMyCartListForm();
		} else if(command.contentEquals("/myCartselect.do")) { //찜하기 눌렀을떄
			service = new MemberMyCartSelect();
		} else if(command.contentEquals("/bookPageList.do")){
			service = new BookPageListService();
		} else if(command.contentEquals("/bookReview.do")) { //찜하기 눌렀을떄
			service = new BookReviewInsertService();
		}
		
		
		
		service.execute(request, response);
	}
	
}
