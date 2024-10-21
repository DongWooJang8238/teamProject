
console.log(document.querySelector('#gender').getAttribute('gender'));
console.log(document.querySelector('.gender-group input[value="woman"]'));
const genderOne = document.querySelector('.gender-group input[value="woman"]');
const gender = document.querySelector('#gender').getAttribute('gender');
let userEmailvalue = document.getElementById('userEmail').value;
let userEmail = document.getElementById('userEmail')

console.log(userEmail);
// 만약 유저 VO에 저장된 값이 woman이라면 checked 코드
if(gender === "woman"){
	document.querySelector('.gender-group input[value="woman"]').checked = true;
}




function updateUserInfo(form) {
	if(form.userEmail.value === ''){
		alert("메일을 입력해주세요.");
		return;
	}
	
	if(form.userAddress.value === ''){
		form.userAddress.value = '';
	}
	
	if(form.userPhonenumber.value === ''){
		form.userPhonenumber.value = '';
	}
	
	
	form.userEmail.value = form.userEmail.value + '@' + form.emailDomain.value;
	
	let formData = new FormData(form);
	console.log(form.userId.value);
	console.log(form.userGender.value);
	console.log(form.userAddress.value);
	console.log(form.userDate.value);
	console.log(form.userPhonenumber.value);
	console.log(form.userEmail.value);
	console.log("변경완료");
	form.action = "/User/updateUserInfo";
	form.submit();
	
//	console.log(userGender.value);
//	console.log(userPhonenumber.value);
//	console.log(userEmail.value);
	
}