package org.joonzis.service;

import org.joonzis.domain.UserVO;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
	
	public int userUpdate(UserVO uvo);
	
	

}
