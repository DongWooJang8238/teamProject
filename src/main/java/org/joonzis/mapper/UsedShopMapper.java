package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.Criteria;
import org.joonzis.domain.UsedBookVO;
import org.joonzis.domain.usedBookImgVO;

public interface UsedShopMapper {
	// 책 목록 리스트
	public List<UsedBookVO> getuBookList(Criteria cri);
	// 책 목록 카테고리 리스트
	public List<UsedBookVO> getuBookListGe(Criteria cri);
	// 전체 게시글 수
	public int getTotal();
	// 전체 게시글 수
	public int getTotalByGno(int gno);
	// 중고상품 insert
	public int usedShopInsert(UsedBookVO vo);
	// 중고상품ubno select
	public int selectUbno();
	// 중고상품이미지 insert
	public int usedShopImgInsert(usedBookImgVO vo);
}
