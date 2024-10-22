package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BookBuyListVO;
import org.joonzis.domain.BookVO;
import org.joonzis.domain.Criteria;
import org.joonzis.domain.OrderBookListVO;
import org.joonzis.domain.OrderDetailVO;
import org.joonzis.domain.SelectDTO;

public interface ShopService {
	public List<BookVO> getBookList(Criteria cri);
	public List<BookVO> getBookListGe(Criteria cri);
	public int getTotal();
	public int getTotalByGno(int gno);
	public BookVO getBookOne(int bno);
	public int buyList(BookBuyListVO vo);
	public List<BookBuyListVO> buyListSelect(int mno);
	public int deleteCart(int bno);
<<<<<<< HEAD
	public int insertOrderDetail(OrderDetailVO vo);
	public int insertOrderBookList(OrderBookListVO vo);
	public int selectOrderDetail(int mno);
=======

	public int insertOrderDetail(OrderDetailVO vo, int check);

	public int insertOrderBookList(OrderBookListVO vo);

	public OrderDetailVO selectOrderDetailByMno(int mno);

	public OrderDetailVO selectOrderDetailByOdno(int odno);

	public int selectOrderDetailOdno(int mno);
	
	public int cuNext(BookBuyListVO bblvo);

	public int selectCuNext(BookBuyListVO bblvo);
	
	public List<BookVO> getBookListSelect(SelectDTO sel);
>>>>>>> f3f22e68e736948b92548c818ccb6299ea94ae54
}
