package org.joonzis.service;

import org.joonzis.domain.BoardCommentLikeVO;
import org.joonzis.domain.BoardLikeVO;

public interface BoardLikeService {
	// 게시판 좋아요
	// 좋아요 추가
	public int insertLike(BoardLikeVO vo);
	// 좋아요 삭제
	public int deleteLike(BoardLikeVO vo);
	// 좋아요 개수
	public int countLikes(int boardno);
	// 좋아요 여부 확인
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
}
