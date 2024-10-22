package org.joonzis.service;

import org.joonzis.domain.BoardLikeVO;
import org.joonzis.mapper.BoardLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardLikeServiceImpl implements BoardLikeService {
	
	@Autowired
	private BoardLikeMapper mapper;



	@Override
	public int insertLike(BoardLikeVO vo) {
		// 좋아요가 이미 눌렸는지 확인 후 처리
				log.info("insertLike... " + vo);
		        
		        return mapper.insertLike(vo);
			}

	@Override
	public int deleteLike(BoardLikeVO vo) {
		log.info("deleteLike... " + vo);
		return mapper.deleteLike(vo);
	}

	@Override
	public int countLikes(int boardno) {
		log.info("countLikes... " + boardno);
		return mapper.countLikes(boardno);
	}

	@Override
	public int isLiked(BoardLikeVO vo) {
		// 좋아요 여부 확인: 반환값이 0보다 크면 이미 좋아요가 눌린 상태
		return mapper.isLiked(vo);
	}
}
