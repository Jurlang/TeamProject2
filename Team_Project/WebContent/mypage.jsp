<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%!Connection connection;
	Statement statement;
	ResultSet resultSet;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "project";
	String upw = "1234";
	String query2 =  "select u_grade,u_point from member";
	String query = "select u_id,u_pw,u_name,u_birth,u_tel," + "u_address from member";%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
try {
	Class.forName(driver);
	connection = DriverManager.getConnection(url, uid, upw);
	statement = connection.createStatement();
	resultSet = statement.executeQuery(query2);
	
	
	while(resultSet.next())
	{
		String point = resultSet.getString("u_point");
		String grade = resultSet.getString("u_grade");
	
%>

	<table align="center">
		<tr>
			<th>나의 이용정보</th>
		</tr>
	</table>

	<table border=1 align="center">
		<tr align="center">
			<td>등급</td>
			<td>보유포인트</td>
		</tr>
		<tr align="center">
			<td><%=grade%></td>
			<td><%=point%>p</td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<br>

	<!-- <table align="center">
<tr>
<th>구매목록</th>
</tr>
</table>

<table border=1 align="center">
<tr align="center">
<td>번호</td><td>제목</td><td>저자</td><td>출판사</td><td>가격</td>
</tr>
<tr><td colspan="5">d</td></tr>
</table>
<br><br><br><br> -->
	<%
	}
	
	
	
		resultSet = statement.executeQuery(query);
		while(resultSet.next())
		{
			String id = resultSet.getString("u_id");
			String pw = resultSet.getString("u_pw");
			String name = resultSet.getString("u_name");
			String birth = resultSet.getString("u_birth");
			String tel = resultSet.getString("u_tel");
			String address = resultSet.getString("u_address");
			
			
		
		
	%>
	<table align="center">
		<tr>
			<th>계정정보</th>
		</tr>
	</table>

	<table border=1 align="center">
		<tr>
			<td>ID</td>
			<td><%=id%></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><%=pw%></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>생일</td>
			<td><%=birth%></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=tel%></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><%=address%></td>
		</tr>
	</table>
	
	<form name='frm1'  method='post' action="memberMyPageUpdateForm.do"> 
	<table align="center">
		<tr>
		
			<td><input type="button" id="대체왜" name="btn1" value="회원정보 변경" onclick="javascript:frm1.submit();"/></td>
			<td><input type="button" value="메인으로 이동"></td>
		</tr>
	</table>
	
	</form>
	<%
		}
} catch (Exception e) {
	e.printStackTrace();

} finally {
	try {
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
	} catch (Exception e2) {
		e2.printStackTrace();
	}
}
	
	%>


</body>
</html>
