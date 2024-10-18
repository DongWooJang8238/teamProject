console.log('like js');

const likeService = (function(){
    // 좋아요 버튼 클릭 이벤트
    $('#like-btn').click(function(){
        var boardno = $(this).data('boardno');
        var mno = $(this).data('mno');
        
        var likeData = {
            boardno: boardno,
            mno: 1
        };
        
        // 좋아요 토글 요청
        $.ajax({
            type: 'POST',
            url: '/like/toggle',
            contentType: 'application/json',
            data: JSON.stringify(likeData),
            success: function(response) {
                alert(response); // "Like added" 또는 "Like removed" 메시지 표시
                // 좋아요 개수 업데이트
                updateLikeCount(boardno);
            },
            error: function(error) {
                console.log("Error: " + error);
            }
        });
    });
    
    // 좋아요 개수 업데이트 함수
    function updateLikeCount(boardno) {
        $.ajax({
            type: 'GET',
            url: '/like/count/' + boardno,
            success: function(count) {
                $('#like-count').text(count);
            },
            error: function(error) {
                console.log("Error: " + error);
            }
        });
    }
});
