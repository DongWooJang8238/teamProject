<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>한국 문학 위인 게임</title>
    
</head>
<body>
 <input type="hidden" class="userMno" value="${mno}" />
 <!-- 씨큐리티 적용시 받아오기. -->

<form action="JenreCheck" method="get">
	<div class="panel-body-btns">
		<button type="button" class="btns" id="easyBtn">쉬움 난이도</button>
		<button type="button" class="btns" id="nomalBtn">기본 난이도</button>
		<!--  <button type="button" class="btns" id="hardBtn">어려움 난이도</button>-->
	</div>
</form>
    

   
	<script type="text/javascript" src="/resources/js/game/gameEntrance.js"></script>
</body>
</html>