package _Service_Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.MemberDAO;
import _DTO.Member;
import _Service_Book.Service;

public class MemberMyPageService implements Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uno = Integer.parseInt(request.getParameter("uno"));
		MemberDAO mDao = MemberDAO.getInstance();
		Member m = new Member();
		m = mDao.getMemberInfo(uno);
		
		request.setAttribute("uno", m.getUno());
		request.setAttribute("id", m.getU_id());
		request.setAttribute("pw", m.getU_pw() );
		request.setAttribute("name", m.getU_name());
		request.setAttribute("birth", m.getU_birth());
		request.setAttribute("tel", m.getU_tel());
		request.setAttribute("address", m.getU_address());
		request.setAttribute("point", m.getU_point());
		request.setAttribute("grade", m.getU_grade());
		
		
		request.getRequestDispatcher("/member/myPage.jsp").forward(request, response);
	}
	
}
