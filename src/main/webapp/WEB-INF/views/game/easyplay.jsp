<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Easy Play</title>
</head>
<body>
    <h1>게임 모드: easy</h1>
    <h2>장르: ${gameJenre}</h2>

    <div id="questContainer">
        <c:forEach var="gvo" items="${questList}">
            <div class="quest" style="display:none;">
                <h3>Quest: ${gvo.gameQuest}</h3>
                <input type="hidden" class="correctAnswer" value="${gvo.gameAnswer}" />
            </div>
        </c:forEach>
    </div>

    <div class="buttons">
        <!-- 버튼에 id 추가 -->
        <button id="btn-o" class="btn-o">O</button>
        <button id="btn-x" class="btn-x">X</button>
    </div>

    <script type="text/javascript" src="/resources/js/game/easyplay.js"></script>
</body>
</html>

