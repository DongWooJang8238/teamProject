// 카테고리 클릭 이벤트 - 조회
document.querySelectorAll('.sidebar a').forEach(a => {
	a.addEventListener('click', e => {
		e.preventDefault();
		
		gener = a.getAttribute('href');
		filterType = a.getAttribute('filterType');
		if(gener === null){
			gener = new URLSearchParams(location.search).get('gener');
		}
		if(filterType === null){
			filterType = new URLSearchParams(location.search).get('filterType');
		}
		setStorageData(pageNum, amount, gener, filterType);
		
		let sendData = `pageNum=1&amount=${amount}&gener=${gener}&filterType=${filterType}`;
		console.log(sendData);
		
		location.href = `/shop/list?${sendData}`;
	});
});

let checkCategorys = [];
document.querySelectorAll('input[name="gno"]').forEach(igno => {
	igno.addEventListener('change', e => {
		console.log(e.target.value);
		console.log(e.target.checked);
		
		if(e.target.checked){
			checkCategorys.push(e.target.value);
		}else {
			checkCategorys = checkCategorys.filter(value => value !== e.target.value);
		}
		
		console.log(checkCategorys);
		location.href = `/shop/list?checkCategorys=${checkCategorys}`;
	});
});

const selectOp = document.querySelector('select[name="selectOption"]');
const selectVl = document.querySelector('input[name="selectBook"]');
// 검색 옵션 이벤트
selectOp.addEventListener('change', e => {
	console.log(e.target.value);
	if(e.target.value === "title"){
		document.querySelector('input[name="selectBook"]').placeholder = "제목으로 검색";
	}else if(e.target.value === "writer"){
		document.querySelector('input[name="selectBook"]').placeholder = "작가명으로 검색";
	}
});

// 검색 이벤트
function selectBookShoping() {
	console.log(selectOp.value);
	location.href = "/shop/listSelect?selectOption=" + selectOp.value + "&selectValue=" +  selectVl.value;
}

document.querySelectorAll('.card-title a').forEach(a => {
	a.addEventListener('click', e => {
		e.preventDefault();
	});
});

// 상품 클릭 이벤트 - 조회
function goGet(bno) {
//	console.log(bno);
	location.href = '/shop/get?bno=' + bno;
}

function goShopInsert() {
	location.href = '/shop/goInsert';
}

//별점 js
document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll('.stars').forEach(starsContainer => {
        const rating = parseFloat(starsContainer.getAttribute('data-rating'));
        const stars = starsContainer.querySelectorAll('.star');
        stars.forEach((star, index) => {
            if (index < Math.floor(rating)) {
                star.style.color = '#FFD700'; // 노란색
            } else if (index === Math.floor(rating) && rating % 1 >= 0.5) {
                star.style.color = '#FFD700'; // 노란색 반 개
            } else {
                star.style.color = '#FFF'; // 흰색
            }
        });
    });
});



// 새 상품 등록 이벤트 (권한 필요)

// 페이지 정보 부여 이벤트
let pageNum = new URLSearchParams(location.search).get('pageNum');
let amount = new URLSearchParams(location.search).get('amount');
let gener = new URLSearchParams(location.search).get('gener');
let filterType = new URLSearchParams(location.search).get('filterType');

if(!pageNum || !amount || !gener || !filterType){
	pageNum = 1;
	amount = 20;
	gener = 0;
	filterType = 'status';
}
setStorageData(pageNum, amount, gener, filterType);

//페이지 버튼 클릭 이벤트
document.querySelectorAll(".page-nation li a").forEach( a => {
	a.addEventListener('click', e => {
		e.preventDefault();
		
		pageNum = a.getAttribute('href');
		setStorageData(pageNum, amount, gener, filterType);
		
		let sendData = `pageNum=${pageNum}&amount=${amount}&gener=${gener}&filterType=${filterType}`;
		
		location.href = `/shop/list?${sendData}`;
	});
});