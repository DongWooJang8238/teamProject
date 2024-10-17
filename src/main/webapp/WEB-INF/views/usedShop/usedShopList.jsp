<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/usedShopList.css">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../layout/header.jsp" />

	중고 상점 리스트 페이지
	
	<button onclick="goUsedInsert()">상품 등록</button>
	
	<div class="sidebar">
		<h3>카테고리</h3>
		<hr>
		<a href="0">초기화</a> 
		<hr>
		<a href="1">소설</a> <a href="2">역사</a> <a href="3">과학</a>
		<a href="4">예술</a> <a href="5">철학</a> <a href="6">자기계발</a> <a href="7">기술/공학</a>
		<a href="8">경제/경영</a> <a href="9">사회과학</a> <a href="10">종교</a>
		<hr>
	</div>
	
	<jsp:include page="../layout/footer.jsp" />

</body>
<script type="text/javascript" src="/resources/js/usedShop/usedShopList.js"></script>
</html>