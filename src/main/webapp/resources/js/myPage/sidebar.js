

/*-------------- 사이드바  이벤트 핸들러------*/
document.querySelectorAll(".sidebar a").forEach(a => {
	a.addEventListener('click', e=>{
		e.preventDefault();
		console.log(a.id);
		let menu = a.getAttribute('href');
		if(a.id === "checkPage"){
			location.href = menu;
		}else if(a.id === "aa"){
			location.href = menu;
		}
		
	});
});

/*-------------- 사이드바 ------*/
function toggleSubMenu(id) {
	var subMenu = document.getElementById(id);
	if (subMenu.style.display === "block") {
		subMenu.style.display = "none";
	} else {
		subMenu.style.display = "block";
	}
}




