<%@page import="_DAO.MemberDAO"%>
<%@page import="_DTO.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("EUC-KR");
	Integer uno = (Integer) session.getAttribute("uno");
	Member m = null;
	if (uno != null) {
		MemberDAO mDao = MemberDAO.getInstance();
		m = mDao.getMemberInfo(uno);
	}
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="bookbuy.do?uno=<%=uno %>" method="get" enctype="multipart/form-data"
		name="boradform">
		<input type="hidden" name="bno" value="${book.no}">  
		<input type="hidden" name="uno" value="<%=m.getUno()%>"> 
		<input	type="hidden" name="u_id" value="<%=m.getU_id()%>">
		<!--세션으로 나중에 받자 -->
		<input type="hidden" name="bprice" value="${book.price}">
		<input type="hidden" name="buy" id="buy" value="${buy }">
		<script>
			var a = document.getElementById("buy").value;
			if (a == 'bad') {
				alert("포인트가 부족하여 구매에 실패하였습니다.");
			} else if (a == 'good') {
				alert("구매 완료 하였습니다.");
				location.href = "memberBuyListForm.do?uno=<%=uno%>";
			} else {
			}
		</script>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<table border="1" align="center">

			<tr>
				<th width="800" colspan="2">상품명</th>

				<th width="100">장르</th>

				<th width="100">출판사</th>

				<th width="100">가격</th>

				<th width="200">파일 이름&용량</th>

				<th width="200">배송일</th>
			</tr>

			<tr>

				<td width="100" height="130" align="center"><img
					src="upload/${book.imgFile }"></td>
				<td>${book.name}</td>

				<td>${book.genre}</td>

				<td>${book.publish}</td>

				<td>${book.price}</td>

				<td>${book.bookFile}<br/>${size } bytes</td>

				<td>결제후 즉시 다운로드가능</td>

			</tr>

		</table>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<table align="center">
			<tr>
				<td colspan=2 align="center">
					<input type="submit" value="구매">
					<input type="button" value="고민중">
					<input type="button" value="이전으로" onclick="location.href='bookInfo.do?no=${book.no}'">
				</td>
		</table>
	</form>
</body>
<script>
	
</script>
</html>
