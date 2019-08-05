package _Service_Member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _Service_Book.Service;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import _DAO.BookDAO;
import _DAO.MemberDAO;
import _DTO.Book;
import _DTO.Member;

public class MemberMyPageUpdateService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDAO mDao = MemberDAO.getInstance();
		int uno = mDao.updateMemberInfo(id, pw, tel, address);
		
		response.sendRedirect("memberMyPage.do?uno="+uno);
	}
}
