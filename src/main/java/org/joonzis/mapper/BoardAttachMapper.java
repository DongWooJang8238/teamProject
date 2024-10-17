package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.BoardAttachVO;

public interface BoardAttachMapper {
	public void register(BoardAttachVO vo);
	public void remove(String uuid);
	public List<BoardAttachVO> findByBoardno(int boardno);
}
