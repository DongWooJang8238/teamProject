// 댓글 좋아요 버튼 클릭 이벤트 핸들러
document.addEventListener('click', function (event) {
    if (event.target.classList.contains('reply-like-btn')) {
        var replyno = event.target.getAttribute('data-replyno');
        var mno = document.getElementById('like-btn').getAttribute('data-mno'); // 유저 ID를 기존의 좋아요 버튼에서 가져옴

        
        fetch('/reply/like', {
            method: 'POST',
            headers: {'Content-Type': 'application/json; charset=utf-8' },
            body: JSON.stringify({ replyno: replyno, mno: mno })
        })
        .then(response => response.text())
        .then(data => {
            console.log(data);
            // 좋아요 수 갱신
            document.getElementById('reply-like-count-' + replyno).textContent = result.likeCount;
        })
        .catch(error => console.error(error));
    }
});
