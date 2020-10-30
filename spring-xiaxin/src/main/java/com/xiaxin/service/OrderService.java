package com.xiaxin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cxq
 * @date 2020/9/9 17:03
 * @description
 */
@Component
public class OrderService {

	@Autowired
	UserService userService;

	public OrderService() {
		System.out.println("orderService");
	}

}
