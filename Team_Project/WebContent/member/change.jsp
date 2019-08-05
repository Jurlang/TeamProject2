<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>▒▒▒ 회원정보 수정 ▒▒▒</title>
</head>
<body>
	
	
	<%
	
	String id=request.getParameter("id");

	%>
	
<form name='frm1' method='post' action='memberMyPageUpdate.do'> 
	
		<br><center><h2> ▒▒▒ 회원정보 수정 ▒▒▒ </h2>
		<font color="ccccff">정보를 수정합니다.</font>
		<br><br>
		<table width="600" cellpadding = "6" cellspacing="0" border="1">
		<tr>
		<td bgcolor="#666cc" align="center" width="200">
		<B><font color="white">아이디 :</font></B>
		 <input type="text" name="id" value="${id }" /><br />
       	<B><font color="white">비밀번호 : </font></B>
       	<input type="text" name="pw" value="${pw }" /><br />
        <B><font color="white">전화번호 : </font></B>
        <input type="text" name="tel" value="${tel }" /><br />   
       	<B><font color="white"> 주소 : </font></B>
       	<input type="text" name="address" value="${addr }" /><br />
	</table>
	<input type="submit" name="btn1" value="수정"/>
</center>
</form>
<%

%>

</body>
</html>