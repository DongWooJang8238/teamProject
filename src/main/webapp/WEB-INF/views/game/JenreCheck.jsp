<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장르 선택</title>
</head>
<body>
<form>
	<input type="hidden" class="userMno" value="${mno}" />
	<input type="hidden" name="gameMode" value="${gameMode }" >
	<p>${gameMode }
	
	<div class="panel-body-btns">
		<button type="button" class="btn btn-fir" id="jenre1">고전시가</button>
		<button type="button" class="btn btn-fir" id="jenre2">소설</button>
		<button type="button" class="btn btn-fir" id="jenre3">현대시가</button>
		<button type="button" class="btn btn-fir" id="jenre4">시조</button>
		<button type="button" class="btn btn-fir" id="jenre5">희곡</button>
		<button type="button" class="btn btn-fir" id="jenre6">역사소설</button>
		<button type="button" class="btn btn-fir" id="jenre7">한국시</button>
		<button type="button" class="btn btn-fir" id="jenre8">산문</button>
		<button type="button" class="btn btn-fir" id="jenre9">현대소설</button>
	</div>
</form>


    
	<script type="text/javascript" src="/resources/js/game/JenreCheck.js"></script>


</body>
</html>