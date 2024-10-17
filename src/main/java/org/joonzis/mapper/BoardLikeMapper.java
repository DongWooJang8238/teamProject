package org.joonzis.mapper;

import org.joonzis.domain.BoardLikeVO;

public interface BoardLikeMapper {
	// 좋아요 추가
	public void insertLike(BoardLikeVO vo);
	// 좋아요 삭제
	public void deleteLike(BoardLikeVO vo);
	// 좋아요 개수
	public int countLikes(int boardno);
	// 사용자가 이미 좋아요를 눌렀는지 확인 (1: true, 0: false)
    public int isLiked(int boardno, int mno);
}
