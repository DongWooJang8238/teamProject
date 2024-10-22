<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<div>
		<h1 class="page-header">회원 목록</h1>
	</div>
	
	<div class="panel-body">
		<table>
			<thead>
				<tr>
					<th>회원번호</th>
					<th>회원 이름</th>
					<th>회원아이디</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.bno }</td>
					<td><a href="${vo.bno }">${vo.title } <b>[${vo.replycnt }]</b></a></td>
					<td>${vo.writer }</td>
					<td>${vo.regdate }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- page -->
      <div class="page-wrap">
         <ul class="page-nation">
            <c:if test="${pageMaker.prev }">
               <li class="previous">
                  <a href="${pageMaker.startPage-1 }"> &lt; </a>
               </li>
            </c:if>
            <c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" step="1">
               <li>
                  <a href="${num }" class="${pageMaker.cri.pageNum == num ? 'active' : '' }"> ${num } </a>
               </li>
            </c:forEach>
            <c:if test="${pageMaker.next }">
               <li><a href="${pageMaker.endPage+1 }"> &gt; </a></li>
            </c:if>
         </ul>
       </div>
		
		
		
	</div>

	<script type="text/javascript" src="/resources/js/boardList.js"></script>

</body>
</html>