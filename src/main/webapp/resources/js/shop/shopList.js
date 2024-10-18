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