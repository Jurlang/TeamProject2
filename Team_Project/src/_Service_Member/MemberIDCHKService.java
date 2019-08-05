package _Service_Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _DAO.MemberDAO;
import _Service_Book.Service;

public class MemberIDCHKService implements Service{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		// DB 검사해주고
		MemberDAO mDao = MemberDAO.getInstance();
		int col = mDao.getIdCheck(id);
		
		PrintWriter pw = response.getWriter();
		
		pw.println(col);
	}

}
