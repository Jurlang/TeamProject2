<%@page import="_DAO.BookDAO"%>
<%@page import="_DAO.MemberDAO"%>
<%@page import="_DTO.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.star-input>.input, .star-input>.input>label:hover, .star-input>.input>input:focus+label,
	.star-input>.input>input:checked+label {
	display: inline-block;
	vertical-align: middle;
	background: url('img/grade_img.png') no-repeat;
}

.star-input {
	display: inline-block;
	white-space: nowrap;
	width: 225px;
	height: 40px;
	padding: 25px;
	line-height: 30px;
}

.star-input>.input {
	display: inline-block;
	width: 150px;
	background-size: 150px;
	height: 28px;
	white-space: nowrap;
	overflow: hidden;
	position: relative;
}

.star-input>.input>input {
	position: absolute;
	width: 1px;
	height: 1px;
	opacity: 0;
}

star-input>.input.focus {
	outline: 1px dotted #ddd;
}

.star-input>.input>label {
	width: 30px;
	height: 0;
	padding: 28px 0 0 0;
	overflow: hidden;
	float: left;
	cursor: pointer;
	position: absolute;
	top: 0;
	left: 0;
}

.star-input>.input>label:hover, .star-input>.input>input:focus+label,
	.star-input>.input>input:checked+label {
	background-size: 150px;
	background-position: 0 bottom;
}

.star-input>.input>label:hover ~label {
	background-image: none;
}

.star-input>.input>label[for="p1"] {
	width: 30px;
	z-index: 5;
}

.star-input>.input>label[for="p2"] {
	width: 60px;
	z-index: 4;
}

.star-input>.input>label[for="p3"] {
	width: 90px;
	z-index: 3;
}

.star-input>.input>label[for="p4"] {
	width: 120px;
	z-index: 2;
}

.star-input>.input>label[for="p5"] {
	width: 150px;
	z-index: 1;
}

.star-input>output {
	display: inline-block;
	width: 60px;
	font-size: 18px;
	text-align: right;
	vertical-align: middle;
}

.star-rating {
	width: 205px;
}

.star-rating, .star-rating span {
	display: inline-block;
	height: 39px;
	overflow: hidden;
	background: url('img/grade_img.png') no-repeat;
}

.star-rating span {
	background-position: left bottom;
	line-height: 0;
	vertical-align: top;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>로그인</title>
<body>
	<%
		String score = request.getParameter("score");
		System.out.println(score);
		request.setCharacterEncoding("EUC-KR");
		Integer uno = (Integer) session.getAttribute("uno");
		Member m = null;
		if (uno != null) {
			MemberDAO mDao = MemberDAO.getInstance();
			m = mDao.getMemberInfo(uno);
		} else {
			m = new Member();
			m.setU_id("0");
			m.setU_name("0");
		}
	%>

	<br>
	<br>
	<div align="center">
		<table width="30%" align="center" bgcolor="">
			<tbody>
				<tr>
					<td align="center" bgcolor="">
						<table width="" bgcolor="" border="1">
							<tbody>
								<tr bgcolor="">
									<td colspan="3" align="center"><font color="" size="5px">${book.name}</font>
									</td>
								</tr>
								<tr>
									<td width="30%" align="center"><img
										src="upload/${book.imgFile }" height="200" width="150">
									</td>
									<td width="30%" align="center">
										<table>
											<tbody>
												<tr>
													<td><b>저자 : ${book.writer }</b></td>
												</tr>
												<tr>
													<td><b>출판사 : ${book.publish }</b></td>
												</tr>
												<tr>
													<td><b>평점 : </b><span class="star-rating"><span
															style="width:${20*book.score}%"></span></span></td>
												</tr>
												<tr>
													<td><b>파일 크기 : ${size }</b> bytes</td>
												</tr>
												<tr>
													<td><b>가격 : ${book.price }</b>원</td>
												</tr>
												<tr>
													<td><b>수량 : </b><input name="quantity" size="5"
														value="1">개</td>
												<tr>
													<td><input type="button" value="구매하기"
														onclick="location.href='bookbuyform.do?bno=${book.no}'">
														<!-- 책 구매 페이지로 넘겨주기 --> <input type="button" value="찜하기"
														onclick="location.href='myCartselect.do?bno=${book.no}&uno=<%=uno%>'">
														<!-- 페이지 넘겨주기 하시오 --> <input type="submit" value="리뷰 페이지"
														onclick="location.href='?page=${page }'"> <!-- 페이지 넘겨주기 하시오 -->
													<td>
												</tr>
											</tbody>
										</table> <input type="hidden" name="productNo" value="3"> <input
										type="hidden" name="flag" value="insert">
									</td>
								</tr>
							</tbody>
						</table>
			</tbody>
		</table>

		<div>
			<h2 align="left">책소개</h2>
			<textarea rows="10" cols="135">${book.content}</textarea>
		</div>
		<h2 align="left">리뷰 남기기</h2>
		<div>
			<form action="replyWrite.do">
				<input type="hidden" name="uno" id="uno" value=<%=uno%>>
				<!-- 유저넘버 -->
				<input type="hidden" name="no" id="no" value=${book.no }>
				<!-- 책넘버 -->
				<input type="hidden" name="u_id" id="u_id" value=<%=m.getU_id()%>>
				<!-- 유저아이디 -->
				<table border=1>
					<tr>
						<th>작성자</th>
						<th>내용</th>
						<th>점수입력</th>
						<th>등록하기</th>
					</tr>

					<tr>
						
						<td width="50"><%=m.getU_id()%></td>
						<td width="400"><textarea name="r_content" id="r_content"
								rows=4 cols=50></textarea></td>
						<td><span class="star-input"> <span class="input">
									<input type="radio" name="star-input" value="1" id="p1">
									<label for="p1">1</label> <input type="radio" name="star-input"
									value="2" id="p2"> <label for="p2">2</label> <input
									type="radio" name="star-input" value="3" id="p3"> <label
									for="p3">3</label> <input type="radio" name="star-input"
									value="4" id="p4"> <label for="p4">4</label> <input
									type="radio" name="star-input" value="5" id="p5"> <label
									for="p5">5</label>
							</span> <output for="star-input" id="score">
									<b>0</b>점
								</output>
						</span></td>
						<td width="50"><input type="button" value="리뷰작성"
							onclick="javascript:review()"></td>
					</tr>
				</table>
			</form>
		</div>
		<br> <br>

		<div>
			<table border=1>
				<tr>
					<th>아이디</th>
					<th>내용</th>
					<th>작성일</th>
					<th>점수</th>
				</tr>
				<!-- 동기화 하기위해서 쓴건데 테스트용 -->

				<c:forEach items="${reviewlist }" var="review">
					<tr>
						<td>${review.u_id}</td>
						<td>${review.r_content}</td>
						<td>${review.r_date}</td>
						<td>${review.score}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan=5><c:if test="${ReviewPageMaker.prev }">
							<a
								href="bookInfo.do?page=${ReviewPageMaker.startPage-ReviewPageMaker.pageSize}&no=${book.no}">[이전]</a>
						</c:if> <c:forEach begin="${ReviewPageMaker.startPage }"
							end="${ReviewPageMaker.endPage }" var="page">
							<c:choose>
								<c:when test="${page==ReviewPageMaker.currPage }">${page }</c:when>
								<c:otherwise>
									<a href="bookInfo.do?page=${page}&no=${book.no}">${page}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> <c:if test="${ReviewPageMaker.next }">
							<a
								href="bookInfo.do?page=${ReviewPageMaker.endPage+1}&no=${book.no}">[다음]</a>
						</c:if></td>
				</tr>
			</table>
		</div>
	</div>
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/star.js"></script>
	<script>
		function review() {
			$.ajax({
				type : 'POST',
				url : 'bookReview.do',
				data : {
					uno : $('#uno').val(),
					no : $('#no').val(),
					u_id : $('#u_id').val(),
					r_content : $('#r_content').val(),
					score : $('#score').val(),
				},
				success : function(data) {
					if (data == 1) {
						location.reload();
					}
				}

			}); // end ajax
		}
	</script>
</body>