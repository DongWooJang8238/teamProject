/*-------------- Form 관련 요소들 ------*/
//const f = document.forms[0];

// 헤더 요소들 (로그인,로그아웃,회원가입,마이페이지,카트)
const loginButton = document.getElementById('login');
const logoutButton = document.getElementById('logout');
const signupButton = document.getElementById('signup');
const mypageButton = document.getElementById('mypage');
const cart = document.getElementById('cart');
const userId = document.querySelector('input[name="userId"]');

// 헤더 각 버튼 이벤트 핸들러
document.querySelectorAll(".user-options button").forEach(a => {
	a.addEventListener('click', ()=>{
		const form = new FormData();
		form.append(userId);
		let menu = a.id;
		 console.log(menu);
		if(menu === "login"){
			location.href = '/User/login';
		}else if(menu === "logout"){
			
		}else if(menu === "signup"){
			location.href = '/User/signup';
		}else if(menu === "cart"){
			goToCart();
		}else if(menu === "myPage"){
			
			form.action = "/User/myPage";
			form.submit();
		}
		
	});
});
function setStorageData(pageNum, amount, gener) {
	let pageData = {
			pageNum : pageNum,
			amount : amount,
			gener : gener
	};
	localStorage.setItem('page_data', JSON.stringify(pageData));
}
function getStorageData() {
	return JSON.parse( localStorage.getItem('page_data') );
}

function shopListGo() {
//	console.log(123);
	// 상단바에서 쇼핑리스트로 이동 시 gener = 0, pageNum = 1 으로 전송
	location.href = '/shop/list?gener=0';
}
function shopUsedList() {
	location.href = '/used/list';
}
function goToCart() {
	location.href = '/shop/cartListBuy?mno=' + 1;
}
function goBoard() {
	location.href = '/board/list?pageNum=1&amount=5';
}
function goGame(){
	location.href = '/game/entrance?mno='+1;
}
const books = document.querySelector('#books');

function toggleSubcategories(e){
	if(books.style.display === "none"){
		books.style.display = "block";
	}else if(books.style.display === "block"){
		books.style.display = "none";
	}
}
