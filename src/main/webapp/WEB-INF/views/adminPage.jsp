<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>

	<div class="page-header">
		<h1>관리자 화면</h1>
	</div>
	<div class="panel-body">
		<form method="POST">
			<table>
				<tbody>
					<tr>
						<th>계정번호</th>
						<td><input type="text" name="mno" value="${uvo.mno}" readonly></td>
					</tr>
					<tr>
						<th>유저 이름</th>
						<td><input type="text" name="userName"
							value="${uvo.userName }" ></td>
					</tr>
					<tr>
						<th>유저 아이디</th>
						<td><input type="text" name="userId" value="${uvo.userId }"
							></td>
					</tr>
					<tr>
						<th>유저 비밀번호</th>
						<td><input type="text" name="userPw" value="${uvo.userPw }"
							></td>
					</tr>
					<tr>
						<th>유저 전화번호</th>
						<td><input type="text" name="userPhonenumber"
							value="${uvo.userPhonenumber }" ></td>
					</tr>
					<tr>
						<th>유저 주소</th>
						<td><input type="text" name="userAddress"
							value="${uvo.userAddress }" ></td>
					</tr>
					<tr>
						<th>유저 생년월일</th>
						<td><input type="text" name="userDate"
							value="${uvo.userDate }" ></td>
					</tr>
					<tr>
						<th>유저 이메일</th>
						<td><input type="text" name="userEmail"
							value="${uvo.userEmail }" ></td>
					</tr>
					<tr>
						<th>유저 성별</th>
						<td><input type="text" name="userGender"
							value="${uvo.userGender }" ></td>
					</tr>
					<tr>
						<th>유저 권한</th>
						<td><input type="text" name="userRole"
							value="${uvo.userRole }" ></td>
					</tr>
					<tr>
						<th>유저 포인트</th>
						<td><input type="text" name="userPoint"
							value="${uvo.userPoint }" ></td>
					</tr>
					<tr>
						<th>유저 닉네임</th>
						<td><input type="text" name="nickName"
							value="${uvo.nickName }" ></td>
					</tr>
					<tr>
						<th>유저 아이콘</th>
						<td><input type="text" name="userIcon"
							value="${uvo.userIcon }" ></td>
					</tr>

				</tbody>
			</table>
		</form>
	</div>
	<div class="panel-body-btns">
      	
      	
         <button type="button" class="btn btn-sec" id="userUpdate">수정</button>
      </div>
	

	<script type="text/javascript" src="/resources/js/adminPage.js"></script>
</body>
</html>