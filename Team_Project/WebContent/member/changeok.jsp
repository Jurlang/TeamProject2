<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"

    pageEncoding="EUC-KR"%>
<% 
	request.setCharacterEncoding("euc-kr");
	Connection connection;
	ResultSet resultSet;
	PreparedStatement pstmt = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.87:1521:xe";
	String uid = "project";
	String upw = "1234";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Insert title here</title>
	<script>
	alert("수정되었습니다");
	
	</script>
</head>

<body>

<%-- <%

	request.setCharacterEncoding("euc-kr");
	String id=request.getParameter("id");	
	String pw=request.getParameter("pw");
	String tel=request.getParameter("tel");
	String address=request.getParameter("address");


	Class.forName(driver);
	connection = DriverManager.getConnection(url, uid, upw);


	//db에 저장하기



	

	String sql = "update member set u_pw=?, u_tel=?, u_address=? where u_id=?";



	try{

		pstmt = connection.prepareStatement(sql);

		pstmt.setString(1, pw);

		pstmt.setString(2, tel);

		pstmt.setString(3, address);

		pstmt.setString(4, id);
		pstmt.executeUpdate();
	}
	finally{
		
	}
	
	response.sendRedirect("memberMyPage.do");
%> --%>




	

	



</body>

</html>
