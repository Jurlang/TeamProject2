<%@page import="_DTO.Member"%>
<%@page import="_DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("EUC-KR");
	Integer uno = (Integer)session.getAttribute("uno");
	Member m = null;
	if(uno != null){
		MemberDAO mDao = MemberDAO.getInstance();
		m = mDao.getMemberInfo(uno);
	}
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<style>
body {
	margin: 0 15%;
}

.header {
	width: 100%;
	display: flex;
}

.site_info {
	display: flex;
}

.mem_info_form {
	display: flex;
	margin-left: auto;
}

.mem_info {
	display: flex;
}

.search {
	text-align: center;
}

.main_container {
	background-color: blue;
	display: flex;
}

.booklist {
	width: 70%;
	height: 100%;
	background-color: pink;
}

.toplist {
	width: 30%;
	height: 100%;
	background-color: yellow;
}

td {
	text-align: center;
}

img {
	max-width: 100%;
	height: auto;
}
</style>
</head>

<body>

	<div class="header">
		<div class="site_info">
			<div class="logo">
				<img src="" alt="로고사진">
			</div>
			<div class="site_title">사이트제목</div>
		</div>
		<%if (uno != null){ %>
				<form class="mem_info_form">
					<div class="mem_info">
						<p><%=m.getU_name() %>님환영합니다.<br/>보유 포인트 : <%=m.getU_point() %></p>
						<input type="button" value="마이페이지" onclick="javascript:location.href='memberMyPage.do?uno=<%=uno%>'">
						<input type="button" value="로그아웃" onclick="javascript:logout()">
					</div>
				</form>
		<%} else { %>
				<form action="loginProc.jsp" method="post" name="loginFrm"
					class="mem_info_form">
					<div class="mem_info">
						<div class="login_ID">
							<span class="id">ID</span> <input type="text" name="id" class="id">
						</div>
						<div class="login_PW">
							<span class="pw">PW</span> <input type="password" name="pw" class="pw">
						</div>
						<input type="button" value="로그인" onclick="loginCheck()"> <input
							type="button" value="회원가입"
							onclick="location.href='memberJoinForm.do'">
					</div>
				</form>
		<%} %>
	</div>
	<hr />
	<div class="search">
		<div class="s_genre_price">
			<select name="genre">
				<option value='' selected>---장르---</option>
			</select> <input type="text" name="start_price">원 ~ <input type="text"
				name="end_price">원
		</div>
		<div class="s_title">
			책 제목 <input type="text" class="s_title_data"> <input
				type="submit" values="검색">
		</div>
	</div>
	<hr />
	<div class="main_container">
		<div class="booklist">
			<jsp:include page="/book/bookList.jsp"></jsp:include>
		</div>
		<div class="toplist">
			<p>여기 top 10 들어가야하는데 너무나도 귀찬쓰,,</p>
		</div>
	</div>
</body>
<script>
	function loginCheck() {
		if (document.loginFrm.id.value == "") {
			alert("아이디를 입력해 주세요.");
			document.loginFrm.id.focus();
			return;
		}
		if (document.loginFrm.pw.value == "") {
			alert("비밀번호를 입력해 주세요.");
			document.loginFrm.pwd.focus();
			return;
		}
		document.loginFrm.submit();
	}
	
	function logout(){
		location.href="logout.jsp";
	}
</script>
</html>