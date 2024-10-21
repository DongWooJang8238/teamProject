package org.joonzis.domain;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserOrderVO {
	private int mno, odno, bno, totalPrice, count;
	private String orderAddr, orderPhone, orderStatus;
	
	private Date orderDate;

}
