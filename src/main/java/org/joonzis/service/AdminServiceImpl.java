package org.joonzis.service;

import org.joonzis.domain.UserVO;
import org.joonzis.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;


@Log4j
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper admapper;
	
	@Override
	public int userUpdate(UserVO uvo) {
		log.info(".............."+uvo);
		return admapper.userUpdate(uvo);
	}

}
