<%@ page contentType="text/html; charset=EUC-KR" %>

<%
	session.removeAttribute("idKey");
	session.removeAttribute("nameKey");
	session.invalidate();
	response.sendRedirect("Main.jsp");
%>