package _Service_Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DTO.Member;
import _Service_Book.Service;

public class MemberMyPageUpdateFormService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String addr = request.getParameter("address");
		String tel = request.getParameter("tel");
		
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		request.setAttribute("addr", addr);
		request.setAttribute("tel", tel);
		request.getRequestDispatcher("/member/change.jsp").forward(request, response);
	}

}
