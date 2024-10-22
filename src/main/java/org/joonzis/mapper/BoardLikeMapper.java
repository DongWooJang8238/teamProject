package org.joonzis.mapper;

import org.joonzis.domain.BoardCommentLikeVO;
import org.joonzis.domain.BoardLikeVO;

public interface BoardLikeMapper {
	// 게시판 좋아요
	// 좋아요 추가
	public int insertLike(BoardLikeVO vo);
	// 좋아요 삭제
	public int deleteLike(BoardLikeVO vo);
	// 좋아요 개수
	public int countLikes(int boardno);
	// 사용자가 이미 좋아요를 눌렀는지 확인 (1: true, 0: false)
    public int isLiked(BoardLikeVO vo);
    
    // 댓글 좋아요
    // 좋아요 추가
 	public int cominsertLike(BoardCommentLikeVO vo);
 	// 좋아요 삭제
 	public int comdeleteLike(BoardCommentLikeVO vo);
 	// 좋아요 개수
 	public int comcountLikes(int boardno);
 	// 좋아요 여부 확인
     public int comisLiked(BoardCommentLikeVO vo);
    
    // 보드 삭제시 삭제
    public int deleteBoard(int boardno);
}
