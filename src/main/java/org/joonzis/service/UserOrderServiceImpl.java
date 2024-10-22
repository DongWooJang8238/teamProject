package org.joonzis.service;


import java.util.List;

import org.joonzis.domain.UserOrderVO;
import org.joonzis.mapper.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class UserOrderServiceImpl implements UserOrderService {
	
	@Autowired
	private UserOrderMapper mapper;
	
	@Override
	public List<UserOrderVO> userOrderSelect(int mno) {
		log.warn("서비스 : " + mno);
		return mapper.userOrderSelect(mno);
	}

	
	
}
