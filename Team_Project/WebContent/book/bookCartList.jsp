<%@page import="_DAO.MemberDAO"%>
<%@page import="_DTO.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1" align="center">
			<tr>
				<th width="800" colspan="2">상품명</th>
				<th width="100">장르</th>
				<th width="100">출판사</th>
				<th width="100">가격</th>
				<th width="200">파일 이름&용량</th>
				<th width="200">배송일</th>
			</tr>
			<c:forEach items="${cartList }" var="cart">
			<tr>
				<td width="100" height="130" align="center">
				<img src="upload/${cart.imgfile }"></td>
				<td>${cart.name }</td>
				<td>${cart.genre }</td>
				<td>${cart.publish }</td>
				<td>${cart.price }</td>
				<td>${cart.bookfile}<br />${cart.booksize } byte
				</td>	
				<td>결제후 즉시 다운로드가능</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>
