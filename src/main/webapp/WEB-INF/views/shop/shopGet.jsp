<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/shopGet.css">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="../layout/header.jsp" />

	<div class="get-container">
		<h1 class="product-name">${bvo.title}</h1>
		<div class="product-info">
			<div class="product-image">
				<img src="${bvo.bookcover}" alt="책 표지">
			</div>
			<div class="product-details">
				<p>작가: ${bvo.writer}</p>
				<p>출판사: ${bvo.publisher}</p>
				<p>ISBN: ${bvo.isbn}</p>
				<p>출판일: ${bvo.ordDate}</p>
				<div class="stars" data-rating="${bvo.avgRating}">
					<span class="star">&#9733;</span> <span class="star">&#9733;</span>
					<span class="star">&#9733;</span> <span class="star">&#9733;</span>
					<span class="star">&#9733;</span>
				</div>
				<div class="avg-rating">평균 평점:
					${bvo.avgRating}(${bvo.likeCount})</div>
				<h3 class="price">₩${bvo.bookPrice}</h3>
				<div class="total-price">
					총 가격: ₩<span bp="${bvo.bookPrice}">${bvo.bookPrice}</span>
				</div>
				<div class="quantity-control">
					<button id="minus">-</button>
					<input type="number" value="1" min="1" max="99">
					<button id="plus">+</button>
				</div>
				<div class="action-buttons">
					<button id="shopingList">장바구니 담기</button>
					<button id="buy">구매</button>
					<button id="cu">찜하기</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 본문 영역 -->
<<<<<<< HEAD

=======
	<div style="text-align: center;">
		<h2>[상세보기]</h2>
		<div class="product-image">
			<img src="${bvo.bookcover}" alt="책 표지">
		</div>
		<h1>${bvo.shortText}</h1>
	</div>
	<br>
	<hr>
	<br>
>>>>>>> f3f22e68e736948b92548c818ccb6299ea94ae54
	<!-- 리뷰(댓글) 영역 -->
	<div class="review-section">
		<!-- 댓글 영역 -->
		<div class="comment-section">
			<div class="panel-footer">
				<div class="panel-footer-header">
					<div class="panel-footer-title">
						<h1>리뷰</h1>
					</div>
				</div>
				<div class="panel-footer-body">
					<ul class="chat">
						<li data-rno="1">
							<div>
								<div class="chat-header">
									<strong class="primary-font">작성자1</strong> <small
										class="pull-right">2024-10-10</small>
								</div>
<<<<<<< HEAD
=======
								<div class="stars" data-rating="4">
									<span class="star">&#9733;</span> <span class="star">&#9733;</span>
									<span class="star">&#9733;</span> <span class="star">&#9733;</span>
									<span class="star">&#9733;</span>
								</div>
>>>>>>> f3f22e68e736948b92548c818ccb6299ea94ae54
								<p>이 책 정말 재밌어요!</p>
								<!-- 예시 댓글에 사용할 이미지 -->
								<img src="${bvo.bookcover}" alt="예시 이미지" class="comment-image"
									style="max-width: 200px;" />
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="review-header">
<<<<<<< HEAD
=======
			<img id="imagePreview" class="image-preview" alt="첨부한 이미지 미리보기" />
		</div>

		<div class="ratings" data-rating="1">
			<span class="rating" data-value="1">&#9733;</span> <span
				class="rating" data-value="2">&#9733;</span> <span class="rating"
				data-value="3">&#9733;</span> <span class="rating" data-value="4">&#9733;</span>
			<span class="rating" data-value="5">&#9733;</span>
		</div>

		<div class="review-input">
>>>>>>> f3f22e68e736948b92548c818ccb6299ea94ae54
			<div class="file-upload">
				<input type="file" id="imageUpload" accept="image/*"
					onchange="previewImage(event)" /> <label for="imageUpload">이미지
					첨부</label>
			</div>
			<img id="imagePreview" class="image-preview" alt="첨부한 이미지 미리보기" />
		</div>

<<<<<<< HEAD
		<div class="review-input">
			<input type="text" class="user-id" placeholder="사용자 ID" />
			<textarea class="review-body" placeholder="리뷰 내용을 입력하세요..."></textarea>
=======
			<input type="text" class="user-id" placeholder="사용자 ID" />
			<textarea class="review-body" placeholder="리뷰 내용을 입력하세요..."></textarea>
			<input type="hidden" name="ReviewImgUuid"> <input
				type="hidden" name="ReviewImgName">

>>>>>>> f3f22e68e736948b92548c818ccb6299ea94ae54
			<button class="submit-review">리뷰 달기</button>
		</div>
	</div>



	<div class="move-bar">
		<button id="goTop">Top</button>
		<button id="gobottom">Bottom</button>
		<button id="goShopList">목록으로 가기</button>
	</div>

	<jsp:include page="../layout/footer.jsp" />

	<div class="fixed-bar">
		<div class="total-price">
			총 가격: ₩<span bp="${bvo.bookPrice}">${bvo.bookPrice}</span>
		</div>
		<div class="quantity-control">
			<button id="minus">-</button>
			<input type="number" value="1" min="1" max="99">
			<button id="plus">+</button>
		</div>
		<div class="action-buttons">
			<button id="shopingList">장바구니 담기</button>
			<button id="buy">구매</button>
			<button id="cu">찜하기</button>
			<button id="goShopList">목록으로 가기</button>
		</div>
	</div>
	<div id="tooltip">장바구니에 담겼습니다</div>
</body>
<script type="text/javascript" src="/resources/js/shopGet.js"></script>
</html>
