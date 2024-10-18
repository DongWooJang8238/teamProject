
const CSS_FILE_PATH = '/resources/css/read.css';
let linkEle = document.createElement('link');
linkEle.rel = 'stylesheet';
linkEle.href = CSS_FILE_PATH;
document.head.appendChild(linkEle);


const f = document.forms[0];
let mno;

document.querySelectorAll("button").forEach( btn =>{
	btn.addEventListener('click', ()=>{
		let type = btn.getAttribute('id');
		
		if(type ==='userUpdate'){
			let mno = f.mno.value;
			location.href = '/admin/update?mno='+mno;
			
		}
	})
});

