//console.log(123);
console.log(123);

let gameMode;
const f = document.forms[0];


document.querySelectorAll(".btns").forEach( btn =>{
	btn.addEventListener('click', ()=>{
		let type = btn.getAttribute('id');
		console.log(type);
		if(type ==='easyBtn'){
			console.log(gameMode);
			gameMode = 0;
			location.href = '/game/JenreCheck?gameMode='+gameMode+'&mno='+1;
		}else if(type ==='nomalBtn'){
			console.log(gameMode);
			gameMode = 1;
			location.href = '/game/JenreCheck?gameMode='+gameMode+'&mno='+1;
		}else if(type === 'hardBtn'){
			console.log(gameMode);
			gameMode = 2;
			location.href = '/game/JenreCheck?gameMode='+gameMode;			
		}
	})
});





