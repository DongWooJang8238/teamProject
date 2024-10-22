<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/css/myPage.css">
<title>마이페이지</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<!-- Main content -->
	<form method="post">
		<div class="main-content">
			<div class="header">
				<div class="input-group">
					<label for="username">아이디</label> <input type="text" id="userId"
						name="userId" placeholder="아이디 입력" value="${result.userId }"
						readonly>
					<div class="invalid-feedback" id="mIdValidState"></div>
				</div>

				<div class="input-group">
					<label for="userPw">비밀번호</label> <input type="password" id="userPw"
						name="userPw" placeholder="비밀번호 입력" required>
					<div class="invalid-feedback" id="mPwValidState"></div>
				</div>
			</div>
			<button type="button" class="signup-btn" id="checkPassword">확인</button>
		</div>
	</form>
	<div class="sidebar">
		<h3>마이페이지</h3>
		<ul>
			<li><a href="#" onclick="toggleSubMenu('shopping-info')">쇼핑정보</a>
				<ul id="shopping-info" class="sub-menu">
					<li><a href="#">주문목록/배송조회</a></li>
					<li><a href="#">취소/반품/교환 내역</a></li>
				</ul></li>
			<li><a href="#" onclick="toggleSubMenu('benefit-management')">혜택관리</a>
				<ul id="benefit-management" class="sub-menu">
					<li><a href="#">쿠폰</a></li>
					<li><a href="#">적립금</a></li>
				</ul></li>
			<li><a href="userInfo" onclick="toggleSubMenu('member-info')">회원정보</a>
				<ul id="member-info" class="sub-menu">
					<li><a id="checkPage"
						href="/User/checkPassword?userId=${result.userId }">회원정보 수정</a></li>
					<li><a href="#">배송지 관리</a></li>
				</ul></li>
			<li><a href="#">나의 게시글</a></li>
		</ul>
	</div>


	<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="/resources/js/myPage.js"></script>
<script type="text/javascript" src="/resources/js/sidebar.js"></script>
</html>
