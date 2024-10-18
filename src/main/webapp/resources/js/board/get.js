//------CSS 파일 추가
// 1. 파일 경로 설정
const CSS_FILE_PATH = '/resources/css/get.css';
// 2. link 태그 생성
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;
// 3. head 태그에 link 엘리먼트 추가
document.head.appendChild(linkEle);

const f = document.forms[0];

function setStorageData(pageNum, amount){
	let pageData = {
		pageNum : pageNum,
		amount : amount
	};
	localStorage.setItem('page_data', JSON.stringify(pageData));
}
function getStorageData(){
	return JSON.parse(localStorage.getItem('page_data'));
	
}

// 버튼 이벤트
document.querySelectorAll("button").forEach(btn => {
    btn.addEventListener('click', (e) => {
        e.preventDefault();
		// 버튼의 id 속성 값 확인
        let type = btn.getAttribute('id');

        if (type === 'indexBtn') {// 목록으로 이동
        	let pageData = getStorageData();
			let sendData = `pageNum=${pageData.pageNum}&amount=${pageData.amount}`;
			location.href = '/board/list?' + sendData; // 목록으로 이동
        } else if (type === 'modifyBtn') {// 게시글 수정 버튼
            let boardno = f.boardno.value;
            location.href = '/board/modify?boardno=' + boardno;
		}else if(type === 'addReplyBtn'){
			// 댓글 등록 실행
			registerReply();
		}else if(type === 'closeModalBtn'){// 댓글 등록창 닫기
			closeModal();
		}else if(type === 'addReplyBtn'){
			// 댓글 등록 실행
			registerReply();
		}else if(type === 'modifyReplyBtn'){
			// 댓글 수정 실행 버튼
			modifyReply();
		}else if(type === 'removeReplyBtn'){
			// 댓글 수정 실행 버튼
			removeReply();
		}
        
	});
});

//------------댓글 관련 스크립트------------
const rs = replyService;	// reply.js에서 CRUD를 담당하는 객체

showList();
// 댓글 목록 가져오는 함수
function showList(){
	let boardno = f.boardno.value;
	let replyUL = document.querySelector('.chat');
	
	 rs.getList(boardno, function(data){
		 
		 let msg = '';
		 
		 data.forEach(vo => {
			 msg += '<li data-replyno="' + vo.replyno + '" onclick="modifyModalPage(this)">';
			 msg +=  '<div>';
			 msg += 	'<div class="chat-header">';
			 msg += 	 '<strong class="primary-font">' + vo.replyer + '</strong>';
		     msg += 	 '<small class="pull-right">' +displayTime(vo.replyDate)+ '</small>';
			 msg += 	'</div>';
			 msg += 	'<p>' + vo.reply + '</p>';
			 msg += 	'</div>';
			 msg += '</li>';
			 
		 });
		 
		 replyUL.innerHTML = msg;
	 });
	 
}

// 날짜 변환 함수
function displayTime(unixTimeStamp){
	let myDate = new Date(unixTimeStamp); // 초 단위일 때
	// let myDate = new Date(unixTimeStamp / 1000); // 밀리초 단위일 때

	let y = myDate.getFullYear();
	let m = String(myDate.getMonth() + 1).padStart(2, '0');
	let d = String(myDate.getDate()).padStart(2, '0');

	let date = `${y}-${m}-${d}`;
	return date;
}

//-------------------모달 관련 스크립트------------------
const modal = document.querySelector('#modal');
const inputReply = document.querySelector('input[name="reply"]');
const modalinputReply = document.querySelector('input[name="modalreply"]');
const inputReplyer = document.querySelector('input[name="replyer"]');
const modalinputReplyer = document.querySelector('input[name="modalreplyer"]');
const inputReplydate = document.querySelector('input[name="replydate"]');
const modalinputReplydate = document.querySelector('input[name="modalreplydate"]');
const addReplyBtn = document.querySelector('#addReplyBtn');
const modifyReplyBtn = document.querySelector('#modifyReplyBtn');
const removeReplyBtn = document.querySelector('#removeReplyBtn');
const closeReplyBtn = document.querySelector('#closeReplyBtn');

function openModal(){
	modal.style.display = "block";
}
function closeModal(){
	modal.style.display = "none";
}

// 댓글 등록 창 함수
function resisterModalPage(){
	// 보여질 목록 수정
	regReplyModalStyle();
	// 수정, 삭제 버튼 숨기기
	// 등록, 취소 버튼 보이기
	
	// input 입력창 내용 초기화
	inputReply.value = ''; // 댓글 등록 후 댓글 등록창 댓글 내용 초기화
	inputReplyer.value = ''; // 댓글 등록 후 댓글 등록창 작성자 내용 초기화
	
	openModal();
}
// 댓글 등록 버튼 시 스타일 변경 함수
function regReplyModalStyle(){
	
	addReplyBtn.classList.remove('hide');
	modifyReplyBtn.classList.add('hide');
	removeReplyBtn.classList.add('hide');
	inputReplydate.closest('div').classList.add('hide');
	inputReplyer.removeAttribute('readonly');
}
// 실제 댓글 등록 함수
function registerReply(){

	if(inputReply.value == '' || inputReplyer.value == ''){
		alert('모든 내용을 입력하세요.');
		return;
	}
	
	rs.add(
			{
				reply : inputReply.value,
				replyer : inputReplyer.value,
				boardno : f.boardno.value,
				mno : 1
			},
			function(result){
				console.log("result : " + result);

				showList();
				// 입력후 댓글창 리스트 업데이트
			}
	);
}

// 댓글 리스트 클릭 이벤트
let replyno;
function modifyModalPage(li){
	modifyReplyModalStyle();
	
	// 입력 내용
	replyno = li.getAttribute('data-replyno');
	const parent = document.querySelector('li[data-replyno="'+replyno+'"] div');
	const data_reply = parent.lastChild.innerText;
	const data_replyer = parent.firstChild.firstChild.innerText;
	const data_replydate = parent.firstChild.lastChild.innerText;
	
	modalinputReply.value = data_reply;		 // 댓글 수정창에서 기존 데이터가 바인딩 됨
	modalinputReplyer.value = data_replyer;
	modalinputReplydate.value = data_replydate;
	
	openModal();
	
}
// 댓글 리스트 클릭 시 스타일 변경 함수
function modifyReplyModalStyle(){
	addReplyBtn.classList.add('hide');
	modifyReplyBtn.classList.remove('hide');
	removeReplyBtn.classList.remove('hide');
	modalinputReplydate.closest('div').classList.remove('hide');
	
	modalinputReplyer.setAttribute('readonly', true);	// 댓글 수정창에서 바인딩된 데이터 수정 불가로 만듬
	modalinputReplydate.setAttribute('readonly', true);
}
// 댓글 수정
function modifyReply(){
	// 수정할 내용 필수 입력 검증
	if(inputReply.value == ''){
		alert('수정할 내용을 입력하세요.');
		return;
	}
	// 실제 update 기능 실행
	rs.update({
		reply : modalinputReply.value,
		replyno : replyno
	} , function(result){
		console.log("result : " + result);
		// update 성공 시 댓글 리스트 출력, 모달 창 해지
		closeModal();
		// 수정후 댓글입력창 닫기
		showList();
		// 수정후 댓글창 리스트 업데이트
	}); 

}
function removeReply(){
	// 댓글 삭제할지 confirm으로 물어보기
	// 실제 remove 기능 실행
	// 삭제 후 댓글 리스트 출력, 모달 창 해지
	if(confirm("진짜 삭제하시겠습니까?")){
		rs.remove(replyno, data => {
			console.log(data);
			closeModal();
			// 입력후 댓글입력창 닫기
			showList();
			// 입력후 댓글창 리스트 업데이트
		}); 
	}
}

//------------ 첨부 파일 스크립트
fetch('/board/getAttachList/' + f.boardno.value)
	.then(response => response.json())
	.then(result =>{
		console.log(result);
		showUploadFile(result);
	})
	.catch(err => console.log(err));

let uploadResult = document.querySelector('.uploadResult ul');
function showUploadFile(uploadResultArr){
	
	if(!uploadResultArr || uploadResultArr.length==0) return;
	
	let str = '';
	uploadResultArr.forEach( file => {
		let fileCallPath = encodeURIComponent(file.uploadPath + "/" +
											file.uuid + "_" + file.fileName);
		
		
		str += `<li path="${file.uploadPath}" uuid="${file.uuid}" fileName="${file.fileName}">`;
		str += '<a href="/download?fileName=' + fileCallPath + '">';
		//str += '<a>';
		str += file.fileName;
		str += "</a>";
		//str += "<span data-file='" + fileCallPath + "'> X </span>";
		str += "</li>";
	});
	uploadResult.innerHTML = str;
}

//
//rs.add(
//		{
//			reply : inputReply.value,
//			replyer : inputReplyer.value,
//			bno : f.bno.value
//		},
//		function(result){
//			console.log("result : " + result);
//			closeModal();
//			// 입력후 댓글입력창 닫기
//			showList();
//			// 입력후 댓글창 리스트 업데이트
//		}
//rs.getList(f.bno.value, function(data){
//data.forEach(vo => {
//console.log(vo);
//});
//});
//
//let rno = 10;
//rs.remove(rno, data => {
//console.log(data);
//});
//
//rs.update({
//reply : '테스트',
//rno : 12
//} , function(result) {
//console.log(result);
//}); 
//
//
//rs.get(11, data => {
//	console.log(data);
//});














