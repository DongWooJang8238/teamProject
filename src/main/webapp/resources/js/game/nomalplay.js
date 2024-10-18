console.log("kaak");


let currentIndex = 0;

function showNextQuest() {
    const questList = document.getElementsByClassName("quest");
    if (currentIndex < questList.length) {
        questList[currentIndex].style.display = 'block';
    }
}

function checkAnswer() {
    const questList = document.getElementsByClassName("quest");
    const answerInput = document.getElementById("answerInput").value;
    const correctAnswer = document.getElementsByClassName("correctAnswer")[currentIndex].value;

    if (answerInput.trim() === correctAnswer) {
        alert("정답입니다!");

        questList[currentIndex].style.display = 'none';

        currentIndex++;
        document.getElementById("answerInput").value = ''; // 입력창 비우기

        if (currentIndex < questList.length) {
            showNextQuest(); 
        } else {
            alert("모든 퀘스트를 완료했습니다!");
            
            location.href='/game/gameDone?mno='+1;
        }
    } else {
        alert("오답입니다. 다시 시도하세요.");
    }
}


window.onload = function() {
    showNextQuest(); 
};





