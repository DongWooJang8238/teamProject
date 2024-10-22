package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.UserOrderVO;

public interface UserOrderService {
	public List<UserOrderVO> userOrderSelect(int mno);

}
