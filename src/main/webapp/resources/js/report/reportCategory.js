console.log("kaak");
document.addEventListener('DOMContentLoaded', function() {
    console.log("kaak");

    const form = document.getElementById('reportForm');
    // form이 제대로 가져왔는지 확인
    if (!form) {
        console.error("Form이 존재하지 않습니다.");
    } else {
        
          {
            let gameMode = gameModeInput.value;
            console.log("장르체크");
            console.log(gameMode);

            let gameJenre;

            document.querySelectorAll(".panel-body-btns button").forEach(btn => {
                btn.addEventListener('click', () => {
                    let type = btn.getAttribute('id');

                    if (type === 'reportall') {
                        gameJenre = "전체보기";
                        if (gameMode == 0) {
                            location.href = '/game/easyplay?gameMode=' + gameMode + '&gameJenre=' + gameJenre;
                        } else if (gameMode == 1) {
                            location.href = '/game/nomalplay?gameMode=' + gameMode + '&gameJenre=' + gameJenre + '&mno=' + 1;
                        }
                    }else if(type ==='reportUser'){
           			 gameJenre = "회원정보";
        			 if(gameMode == 0){
        					location.href = '/game/easyplay?gameMode='+gameMode+'&gameJenre='+gameJenre;
        				}else if(gameMode == 1){
        					location.href = '/game/nomalplay?gameMode='+gameMode+'&gameJenre='+gameJenre+'&mno='+1;
        				}
        			
        		}else if(type === 'reportWriter'){
        			 gameJenre = "작가";
        			 if(gameMode == 0){
        					location.href = '/game/easyplay?gameMode='+gameMode+'&gameJenre='+gameJenre;
        				}else if(gameMode == 1){
        					location.href = '/game/nomalplay?gameMode='+gameMode+'&gameJenre='+gameJenre+'&mno='+1;
        				}
        				
        		}else if(type === 'reportSystem'){
        			 gameJenre = "시스템";
        			 if(gameMode == 0){
        					location.href = '/game/easyplay?gameMode='+gameMode+'&gameJenre='+gameJenre;
        				}else if(gameMode == 1){
        					location.href = '/game/nomalplay?gameMode='+gameMode+'&gameJenre='+gameJenre+'&mno='+1;
        				}
        				
        		}else if(type === 'reportShop'){
        			 gameJenre = "구매";
        			 if(gameMode == 0){
        					location.href = '/game/easyplay?gameMode='+gameMode+'&gameJenre='+gameJenre;
        				}else if(gameMode == 1){
        					location.href = '/game/nomalplay?gameMode='+gameMode+'&gameJenre='+gameJenre+'&mno='+1;
        				}
        				
        		}else if(type === 'reportRefund'){
        			 gameJenre = "환불";
        			 if(gameMode == 0){
        					location.href = '/game/easyplay?gameMode='+gameMode+'&gameJenre='+gameJenre;
        				}else if(gameMode == 1){
        					location.href = '/game/nomalplay?gameMode='+gameMode+'&gameJenre='+gameJenre+'&mno='+1;
        				}
        				
        		}else if(type === 'reportProfile'){
        			 gameJenre = "프로필";
        			 if(gameMode == 0){
        					location.href = '/game/easyplay?gameMode='+gameMode+'&gameJenre='+gameJenre;
        				}else if(gameMode == 1){
        					location.href = '/game/nomalplay?gameMode='+gameMode+'&gameJenre='+gameJenre+'&mno='+1;
        				}
        				
        		}else if(type === 'reportFesta'){
        			 gameJenre = "대회";
        			 if(gameMode == 0){
        					location.href = '/game/easyplay?gameMode='+gameMode+'&gameJenre='+gameJenre;
        				}else if(gameMode == 1){
        					location.href = '/game/nomalplay?gameMode='+gameMode+'&gameJenre='+gameJenre+'&mno='+1;
        				}
        				
        		}else if(type === 'reportHeadhunter'){
        			 gameJenre = "캐스팅";
        			 if(gameMode == 0){
        					location.href = '/game/easyplay?gameMode='+gameMode+'&gameJenre='+gameJenre;
        				}else if(gameMode == 1){
        					location.href = '/game/nomalplay?gameMode='+gameMode+'&gameJenre='+gameJenre+'&mno='+1;
        				}
        		}
                });
            });
        }
    }
});
       