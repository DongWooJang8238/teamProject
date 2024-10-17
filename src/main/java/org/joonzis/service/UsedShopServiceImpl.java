package org.joonzis.service;

import org.joonzis.domain.UsedBookVO;
import org.joonzis.mapper.UsedShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class UsedShopServiceImpl implements UsedShopService{
	
	@Autowired
	private UsedShopMapper mapper;
	
	@Override
	public int usedShopInsert(UsedBookVO vo) {
		log.warn("중고상품 입력 서비스..." + vo);
		return mapper.usedShopInsert(vo);
	}
}
