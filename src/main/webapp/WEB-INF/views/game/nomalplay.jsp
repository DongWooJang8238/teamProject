<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 실행 페이지</title>
</head>
<body>
<input type="hidden" class="userMno" value="${mno}" />
	<div id="questContainer">
        <c:forEach var="gvo" items="${questList}">
            <div class="quest" style="display:none;">
                <h3>Quest: ${gvo.gameQuest}</h3>
                <input type="hidden" class="correctAnswer" value="${gvo.gameAnswer}" />
            </div>
        </c:forEach>
    </div>

    <div id="answerContainer">
        <input type="text" id="answerInput" placeholder="정답 입력" />
        <button type="button" onclick="checkAnswer()">정답 제출</button>
    </div>
	

		<script type="text/javascript" src="/resources/js/game/nomalplay.js"></script>
	
</body>
</html>