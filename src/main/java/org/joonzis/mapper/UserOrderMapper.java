package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.UserOrderVO;

public interface UserOrderMapper {
	public List<UserOrderVO> userOrderSelect(int mno);
	
	
}
