package org.joonzis.service;

import org.joonzis.domain.BoardLikeVO;

public interface BoardLikeService {
	// 좋아요 추가
	public void insertLike(BoardLikeVO vo);
	// 좋아요 삭제
	public void deleteLike(BoardLikeVO vo);
	// 좋아요 개수
	public int countLikes(int boardno);
	// 좋아요 여부 확인
    public boolean isLiked(int boardno, int mno);
	
}
