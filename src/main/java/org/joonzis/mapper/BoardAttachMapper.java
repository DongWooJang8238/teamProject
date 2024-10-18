package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.BoardAttachVO;

public interface BoardAttachMapper {
	public int register(BoardAttachVO vo);
	public int remove(String uuid);
	public List<BoardAttachVO> findByBoardno(int boardno);
}
