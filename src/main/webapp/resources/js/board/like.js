document.addEventListener('DOMContentLoaded', function() {
    // 좋아요 버튼 클릭 이벤트
    document.getElementById('like-btn').addEventListener('click', function() {
        var boardno = this.getAttribute('data-boardno');
        var mno = this.getAttribute('data-mno');
        
        var likeData = {
            boardno: boardno,
            mno: 1
        };

        // 좋아요 토글 요청
        fetch('/like/get', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(likeData)
        })
        .then(response => response.text())
        .then(data => {
            alert(data); // "Like added" 또는 "Like removed" 메시지 표시
            // 좋아요 개수 업데이트
            updateLikeCount(boardno);
        })
        .catch(error => console.error('Error:', error));
    });

    // 좋아요 개수 업데이트 함수
    function updateLikeCount(boardno) {
        fetch('/like/count/' + boardno)
        .then(response => response.text())
        .then(count => {
            document.getElementById('like-count').textContent = count;
        })
        .catch(error => console.error('Error:', error));
    }
});
