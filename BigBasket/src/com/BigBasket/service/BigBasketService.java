package com.BigBasket.service;

import com.BigBasket.dao.BigBasketDAO;
import com.BigBasket.dao.BigBasketDAOInterface;
import com.BigBasket.entity.BigBasketConsumer;

public class BigBasketService implements BigBasketServiceInterface
{
	
	private BigBasketService()
	{}
	

	public static BigBasketServiceInterface createServiceObject() {
		// TODO Auto-generated method stub
		return new BigBasketService();
	}


	@Override
	public int createProfile(BigBasketConsumer bbc) {
		BigBasketDAOInterface bbd=BigBasketDAO.createDAOOject();
		
		// TODO Auto-generated method stub
		return bbd.createDAOProfile(bbc);
	}


	 

}
