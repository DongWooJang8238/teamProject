package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BookBuyListVO;
import org.joonzis.domain.BookVO;
import org.joonzis.domain.Criteria;
import org.joonzis.domain.OrderBookListVO;
import org.joonzis.domain.OrderDetailVO;
import org.joonzis.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	ShopMapper mapper;
	
	@Override
	public List<BookVO> getBookList(Criteria cri) {
	    log.info("서비스 책리스트..");
	    List<BookVO> list = mapper.getBookList(cri);
	    list.forEach(vo -> {
	    	log.warn("서비스 책 평점 조회.." + vo.getBno());
	    	vo.setLikeCount(mapper.getTotalLikeByBno(vo.getBno()));
	    	log.warn("서비스 책 평점 조회 결과.." + vo.getLikeCount());
	    });
	    return list;
	}



	
	@Override
	public List<BookVO> getBookListGe(Criteria cri) {
		log.info("서비스 책 카테고리 조회... " + cri);
		return mapper.getBookListGe(cri);
	}
	
	@Override
	public int getTotal() {
		log.info("토탈스..");
		return mapper.getTotal();
	}
	
	@Override
	public int getTotalByGno(int gno) {
		log.info("토탈스..장르.. " + gno);
		return mapper.getTotalByGno(gno);
	}
	
	@Override
	public int insertShopBook(BookVO vo) {
		log.warn("책 데이터 인서트.." + vo);
		return mapper.insertShopBook(vo);
	}
	
	@Override
	public BookVO getBookOne(int bno) {
		log.info("서비스 책 단일 데이터 조회.." + bno);
		BookVO vo = mapper.getBookOne(bno);
		vo.setLikeCount(mapper.getTotalLikeByBno(bno));
		log.warn("서비스 책 단일 데이터 조회 결과.. " + vo);
		log.warn("서비스 단일 데이터 조회 좋아요 수 : " + vo.getLikeCount());
		return vo;
	}
	
	@Override
	public String getBookContent(int bno) {
		log.warn("서비스 책 컨텐트 조회.." + bno);
		return mapper.getBookContent(bno);
	}
	
	@Override
	public List<String> getBookContentImg(int bno) {
		log.warn("서비스 책 이미지 조회" + bno);
		return mapper.getBookContentImg(bno);
	}
	
	@Override
	public int updateAvgRating(int bno) {
		log.warn("업데이트 전 .. " + bno);
		double avgRating = mapper.selectAvgRating(bno);
		log.warn("업데이트 전 avg 결과.. " + avgRating);
		BookVO vo = new BookVO();
		vo.setAvgRating(avgRating);
		vo.setBno(bno);
		
		log.warn("업데이트 전 vo에 avg 저장.. " + vo.getAvgRating());
		
		return mapper.updateAvgRating(vo);
	}
	
	@Override
	public int buyList(BookBuyListVO vo) {
		log.warn("장바구니 담기 서비스.." + vo);
		BookBuyListVO bblvo= mapper.buyListCount(vo.getBno());
		log.warn("서비스 장바구니 카운트 결과.. " + bblvo);
		int result;
		if(bblvo == null) {
			result = mapper.buyList(vo);
		}else {
			result = mapper.buyListCountUp(vo);
		}
		
		return result;
	}
	
	@Override
	public List<BookBuyListVO> buyListSelect(int mno) {
		log.warn("서비스 장바구니 조회 by.mno : " + mno);
		
		return mapper.buyListSelect(mno);
	}
	
	@Override
	public int deleteCart(int bno) {
		log.warn("서비스 장바구니 삭제 by.bno : " + bno);
		return mapper.deleteCart(bno);
	}
	
	@Transactional
	@Override
	public int insertOrderDetail(OrderDetailVO vo) {
		log.warn("서비스 인서트 상세주문" + vo);
		int result = mapper.insertOrderDetail(vo);
		log.warn("서비스 인서트 상세주문 결과 .. " + result);
		log.warn("서비스 장바구니 삭제 mno .. " + vo.getMno());
		
		int deleteCart = mapper.deleteCartAll(vo.getMno());
		log.warn("서비스 장바구니 삭제 결과.." + deleteCart);
		return result;
	}
	
	@Override
	public int selectOrderDetailOdno(int mno) {
		return mapper.selectOrderDetailOdno(mno);
	}
	
	@Override
	public OrderDetailVO selectOrderDetailByMno(int mno) {
		log.warn("서비스 상세 주문 셀렉트.. " + mno);
		return mapper.selectOrderDetailByMno(mno);
	}

	@Override
	public OrderDetailVO selectOrderDetailByOdno(int odno) {
		log.warn("서비스 상세 주문 셀렉트.. " + odno);
		return mapper.selectOrderDetailByOdno(odno);
	}
	
	@Override
	public int insertOrderBookList(OrderBookListVO vo) {
		log.warn("서비스 인서트 주문리스트");
		return mapper.insertOrderBookList(vo);
	}
	
	@Override
	public int cuNext(BookBuyListVO bblvo) {
		log.warn("서비스 찜 리스트 추가.." + bblvo);
		return mapper.cuNext(bblvo);
	}
	
	@Override
	public int selectCuNext(BookBuyListVO bblvo) {
		log.warn("서비스 찜 리스트 조회.." + bblvo);
		return mapper.selectCuNext(bblvo);
	}
}