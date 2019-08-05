<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="memberJoin.do" method="post">
		<input type="hidden" name="command" value="join">
		<table border=1>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id">
				<input type="button" id="btn_idck" value="중복확인" onclick="javascript:idchk()"></td>
			</tr>
			<tr>
				<td colspan="2"><div id="res_idck" style="text-align: center;'"></div></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" id="pw"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" name="p" id="pwck"
					onkeyup="javascript:pwchk();"></td>
			</tr>
			<tr>
				<td colspan="2"><div id="res_pwck" style="text-align: center;'"></div></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="birth"></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td colspan=2 style="text-align: center;"><input type="submit"
					id="btn_submit" value="회원가입"> <input type="reset"
					value="다시쓰기"> <input type="button" value="메인으로"
					onclick="location.href='bookMain.do'"></td>
			</tr>
		</table>
	</form>
</body>

<script>
	function idchk() {
		$.ajax({
			type : 'POST',
			url : 'memberIDCK.do',
			data : {
				id : $('#id').val()
			},
			success : function(data) {
				if (data == 1) {
					$('#res_idck').html("사용불가능");
				} else {
					$('#res_idck').html("사용가능");
				}
			}
		}); // end ajax
	}
	function pwchk() {
		var pw = document.getElementById("pw").value;
		var pwck = document.getElementById("pwck").value;

		if (pw == pwck) {
			document.getElementById("res_pwck").innerHTML = "비밀번호 일치";
			document.getElementById("res_pwck").style.color = "green";
		} else {
			document.getElementById("res_pwck").innerHTML = "비밀번호 불일치";
			document.getElementById("res_pwck").style.color = "red";
		}
	}
</script>
</html>