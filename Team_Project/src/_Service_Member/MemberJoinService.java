package _Service_Member;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.MemberDAO;
import _DTO.Member;
import _Service_Book.Service;

public class MemberJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");

		Member m = new Member();
		m.setU_id(request.getParameter("id"));
		m.setU_pw(request.getParameter("pw"));
		m.setU_name(request.getParameter("name"));
		String birth = request.getParameter("birth");
		Date date = Date.valueOf(birth);
		m.setU_birth(date);
		m.setU_tel(request.getParameter("tel"));
		m.setU_address(request.getParameter("addr"));
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.insertMember(m);
		
		response.sendRedirect("bookMain.do");
	}

}