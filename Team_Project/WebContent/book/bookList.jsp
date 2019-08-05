<%@page import="_DTO.PageMaker"%>
<%@page import="_DTO.Book"%>
<%@page import="java.util.List"%>
<%@page import="_DAO.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
String  spage = request.getParameter("page");		// 시작 페이지를 받아온다
if(spage == null) {
   spage="1";
}																							// 시작페이지가 없으면 spage를 1 로 둔다 ( 방금 켜진 페이지가 1 이라는 증거 ) 
int pageC = Integer.parseInt(spage);							// 만약 spage를 받아왓으면 string 형이기때문에 int로 바꿔준다
BookDAO bDao = BookDAO.getInstance();			// 인스턴스 생성
int totalCount = bDao.getTotalBook();					// 총 갯수를 샌다
PageMaker pageMaker = new PageMaker(pageC, totalCount);	// pagemaker 클래스 생성 생성자 : 스타트 페이지와 총 게시물 갯수
List<Book> bookList = bDao.bookSelectPage(pageMaker.getStart(), pageMaker.getPageSize()); 
// 게시판에 보여줄 페이지를 출력 ( 시작 페이지와 페이지에 출력할 게시물 크기 사이즈 )
request.setAttribute("bookList", bookList);	// 페이지 리스트 출력
request.setAttribute("pageMaker", pageMaker);	// pagemaker 클래스 같이 넘김
%>
	<table>
		<tr>
		<c:if test="${pageMaker.prev }">
			<td rowspan=3>
				<input type="button" onclick="location.href='bookMain.do?page=${pageMaker.curPage - 1 }'"value="이전">
			</td>
		</c:if>
			<c:forEach begin="0" end="2" var="book">
				<td onclick="location.href='bookInfo.do?no=${bookList[book].no}'"><img
					src="upload/${bookList[book].imgFile }">
					<div>${bookList[book].name }</div>
					<div>${bookList[book].price }원</div></td>
			</c:forEach>
		<c:if test="${pageMaker.next }">
			<td rowspan=3>
				<input type="button"  onclick="location.href='bookMain.do?page=${pageMaker.curPage + 1 }'" value="다음">
			</td>
		</c:if>
		</tr>
		<tr>
			<c:forEach begin="3" end="5" var="book">
				<td onclick="location.href='bookInfo.do?no=${bookList[book].no}'"><img
					src="upload/${bookList[book].imgFile }">
					<div>${bookList[book].name }</div>
					<div>${bookList[book].price }원</div></td>
			</c:forEach>
		</tr>
		<tr>
			<c:forEach begin="6" end="8" var="book">
				<td onclick="location.href='bookInfo.do?no=${bookList[book].no}'"><img
					src="upload/${bookList[book].imgFile }">
					<div>${bookList[book].name }</div>
					<div>${bookList[book].price }원</div></td>
			</c:forEach>
		</tr>
	</table>
