<%@page import="_DTO.Member"%>
<%@page import="_DAO.MemberDAO"%>
<%@ page contentType="text/html; charset=EUC-KR" %>
<%
	request.setCharacterEncoding("EUC-KR");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pw");
	
	MemberDAO mDao = MemberDAO.getInstance();
	
	int uno = mDao.loginMember(id, pwd);
	
	Member m = new Member();
	m = mDao.getMemberInfo(uno);
	
	String msg = "�α��� ����";
	
	if(uno != 0){
		msg = "�α��� ����";
		session.setAttribute("uno", m.getUno());
	}
%>

<script>
alert("<%= msg%>");
location.href="Main.jsp";

</script>