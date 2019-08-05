<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		int uno = (int) session.getAttribute("uno");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
</head>
<body>
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
			<td>${grade }</td>
			<td>${point}p</td>
		</tr>
		<tr>
			<td><input type="button" value="구매목록" onclick="location.href='memberBuyListForm.do?uno=<%=uno%>'"></td>
			<td><input type="button" value="찜목록" onclick="location.href='myCartForm.do?uno=<%=uno%>'"></td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<br>
	<table align="center">
		<tr>
			<th>계정정보</th>
		</tr>
	</table>
	<table border=1 align="center">
		<form name='frm1' method='post' action="memberMyPageUpdateForm.do">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="${id}" readonly></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="pw" value="${pw}" readonly></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${name}" readonly></td>
			</tr>
			<tr>
				<td>생일</td>
				<td><input type="text" name="birth" value="${birth}" readonly></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel" value="${tel}" readonly></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" value="${address}" readonly></td>
			</tr>
			<tr>
				<td><input type="submit" value="회원정보 변경"></td>
				<td><input type="button" value="메인으로 이동"	onclick="location.href='bookMain.do'"></td>
			</tr>
		</form>
	</table>
</body>
</html>