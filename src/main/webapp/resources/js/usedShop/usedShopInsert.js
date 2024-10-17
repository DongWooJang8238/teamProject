// 필드
const f = document.forms[0];

// 버튼 이벤트
document.querySelectorAll('button').forEach(btn => {
	btn.addEventListener('click', () => {
		console.log(btn.innerHTML);
		if(btn.innerHTML === "등록"){
			usedShopInsert();
		}else if(btn.innerHTML === "취소"){
			location.href = "/used/list";
		}
	});
});

// 상품 등록 함수
function usedShopInsert() {
	console.log('등록데스네');
}
/*
 * 이미지 업로드 시 비동기로 물리 폴더에 저장 후
 * 이미지 미리보기 영역에 이미지 출력 ( 이미지 여러장이면 옆으로 쭉 나열 )
 */
document.querySelector('.fileUpload input').addEventListener('change', e => {
	const files = e.target.files; // 선택한 이미지 파일 필드 저장
	const fileResult = document.querySelector('.fileResult ul'); // 미리보기 표시할 영역 지정
	fileResult.innerHTML = '';
	// 이미지 파일이 여러장 일 수 있으니 for문 돌면서 사용
	for (let i = 0; i < files.length; i++) {
		let imgFile = new FileReader(); // 미리보기 파일 필드
		imgFile.onload = (event) => {
			// 파일이 로드되면, 새로운 리스트 아이템(li)을 생성하고 그 안에 이미지 추가
			const li = document.createElement('li');
			const img = document.createElement('img');
			img.src = event.target.result; // 로드된 파일의 데이터 URL을 이미지의 소스로 설정
			img.style.width = '100px'; // 이미지 크기 조정
			img.style.height = '100px'; // 이미지 크기 조정
			li.appendChild(img); // 리스트 아이템에 이미지 추가
			fileResult.appendChild(li); // 미리보기 영역에 리스트 아이템 추가
		};
		imgFile.readAsDataURL(files[i]); // 파일을 읽고 데이터 URL로 변환
	}
});