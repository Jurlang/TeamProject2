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
<title>�ƢƢ� ȸ������ ���� �ƢƢ�</title>
</head>
<body>
	
	
	<%
	
	String id=request.getParameter("id");

	%>
	
<form name='frm1' method='post' action='memberMyPageUpdate.do'> 
	
		<br><center><h2> �ƢƢ� ȸ������ ���� �ƢƢ� </h2>
		<font color="ccccff">������ �����մϴ�.</font>
		<br><br>
		<table width="600" cellpadding = "6" cellspacing="0" border="1">
		<tr>
		<td bgcolor="#666cc" align="center" width="200">
		<B><font color="white">���̵� :</font></B>
		 <input type="text" name="id" value="${id }" /><br />
       	<B><font color="white">��й�ȣ : </font></B>
       	<input type="text" name="pw" value="${pw }" /><br />
        <B><font color="white">��ȭ��ȣ : </font></B>
        <input type="text" name="tel" value="${tel }" /><br />   
       	<B><font color="white"> �ּ� : </font></B>
       	<input type="text" name="address" value="${addr }" /><br />
	</table>
	<input type="submit" name="btn1" value="����"/>
</center>
</form>
<%

%>

</body>
</html>