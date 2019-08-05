<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write title here</title>
<style>
table, td, th{
	border : 1px solid;
}
</style>
</head>
<body>
	<form action="bookInsert.do" method="post" enctype="multipart/form-data" name="bookform">
		<table>
<!-- 		no, name, genre, writer, publish, content, price, filename -->
		<tr>
			<th>책 이름</th><td><input type="text" name="name" ></td>
		</tr>
		<tr>
			<th>책 장르</th><td><input type="text" name="genre" ></td>
		</tr>
		<tr>
			<th>책 저자</th><td><input type="text" name="writer" ></td>
		</tr>
		<tr>
			<th>책 출판사</th><td><input type="text" name="publish" ></td>
		</tr>
		<tr>
			<th>책 가격</th><td><input type="text" name="price" ></td>
		</tr>
		<tr>
			<th>줄거리</th><td><textarea rows=10 cols=50 name="content"></textarea></td>
		</tr>
		<tr>
			<th>책 사진</th><td><input type="file" name="imgfile"></td>
		</tr>
		<tr>
			<th>책 파일</th><td><input type="file" name="bookfile"></td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="submit" value="등록">
				<input type="reset" value="다시쓰기">
				<input type="button" value="목록" onclick="location.href='bookList.do'">
			</td>
		</tr>
		</table>
	</form>
</body>
</html>