package org.joonzis.service;

import org.joonzis.domain.UsedBookVO;
import org.joonzis.mapper.UsedShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class UsedShopServiceImpl implements UsedShopService{
	
	@Autowired
	private UsedShopMapper mapper;
	
	@Transactional
	@Override
	public int usedShopInsert(UsedBookVO vo) {
		log.warn("중고상품 입력 서비스..." + vo);
		// 중고 상품 db에 저장
		int result = mapper.usedShopInsert(vo);
		// 저장이 완료됬다면, 이미지 파일들 저장
		return result;
	}
}
