<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<div class="panel-body">
		<form method="POST">
			<table>
				<tbody><input type="hidden" name="boardno" value="${vo.boardno}"
							readonly>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" value="${vo.title }"
							readonly></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="writer" value="${vo.writer }"
							readonly></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="10" cols="76" name="content" readonly>${vo.content }</textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<div class="file-container">
   <div class="file-header">
      <div class="file-title">
         <a>파일 첨부</a>
      </div>
   </div>
   <div class="file-body">
      <div class="uploadResult">
         <ul></ul>
      </div>
   </div>
	</div>
	<div id="like-section">
        <div id="like-count">
        <h1 id="like-countMy">${likecount}</h1>
        </div>
        <button id="like-btn" data-boardno="${vo.boardno}" data-mno="${vo.mno}">
            좋아요
        </button>
    </div>
		<div class="panel-body-btns">
			<button type="button" class="btn btn-sec" id="modifyBtn">수정</button>			
		<button type="button" class="btn btn-fir" id="indexBtn">목록으로 이동</button>
		</div>
	

	<div id="reply">
		<div class="reply-content">
			<div class="reply-title">
				<a>새 댓글 등록</a>
			</div>
			<hr>
			<div class="reply-body">
						<div>
							<div>
								<span class="reply-font">작성자</span>
							</div>
							<p>
								<input type="text" name="replyer">
							</p>
						</div>
						<div>
							<div>
								<span class="reply-font">댓글</span>
							</div>
							<p>
								<input type="text" name="reply">
							</p>
						</div>
			</div>
			<div class="reply-footer">
				<button type="button" class="btn btn-sec" id="addReplyBtn">등록</button>
			</div>
		</div>
	</div>
	
	<div class="panel-footer">
		<div class="panel-footer-body">
			<ul class="chat">
				<li data-replyno="10">
					<div>
						<div class="chat-header">
							<strong class="primary-font">작성자</strong> <small
								class="pull-right">0000-00-00</small>
								<!-- 댓글 좋아요 버튼 및 개수 추가 -->
					<div class="reply-like-section">
						<div class="reply-like-count" id="reply-like-count-10">0</div> <!-- 기본 값 0 -->
						<button type="button" class="reply-like-btn" data-replyno="10">좋아요</button>
					</div>
						</div>
						
						<p>내용</p>
						
					</div>
				</li>
			</ul>
		</div>
	</div>
	
	<div id="modal">
		<div class="modal-content">
			<div class="modal-title">
				<a>댓글 수정</a>
			</div>
			<hr>
			<div class="modal-body">
				<ul class="chat">
					<li>
						<div>
							<div>
								<span class="modal-font">댓글</span>
							</div>
							<p>
								<input type="text" name="modalreply">
							</p>
						</div>
					</li>
					<li>
						<div>
							<div>
								<span class="modal-font">작성자</span>
							</div>
							<p>
								<input type="text" name="modalreplyer">
							</p>
						</div>
					</li>
						<input type="hidden" name="modalreplydate">
				</ul>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-thi" id="modifyReplyBtn">수정</button>
				<button type="button" class="btn btn-fou" id="removeReplyBtn">삭제</button>
				<button type="button" class="btn btn-fir" id="closeModalBtn">취소</button>
			</div>
		</div>
		
	</div>
	<jsp:include page="../layout/footer.jsp" />
	<script type="text/javascript" src="/resources/js/board/reply.js"></script>
	<script type="text/javascript" src="/resources/js/board/get.js"></script>
	<script type="text/javascript" src="/resources/js/board/like.js"></script>
	<script type="text/javascript" src="/resources/js/board/commentlike.js"></script>
</body>
</html>